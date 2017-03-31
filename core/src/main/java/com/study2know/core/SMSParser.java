package com.study2know.core;

import com.google.gson.JsonObject;
import com.study2know.core.utils.Util;
import com.study2know.exceptions.InvalidPatternException;
import com.study2know.exceptions.InvalidTypeException;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.study2know.core.Types.DataType;

/**
 * Created by kurtesy on 16/8/15.
 */
public class SMSParser {


    /*recode to use qualifiers and variables
        Ex : Thanks for registering on CouchPotatoz.com. Your login id is QSTRID, please call us at ^2^ or write to us at %Variable% for any assistance.
        qualifier : Thanks for registering on CouchPotatoz.com
        variables : [{loginid , Your login id is (.+), STRING}]
     */


    private static SMSParser parser = null;
    private Map<String, Set<Pattern>> patterns;


    private SMSParser() {
        patterns = new HashMap<>();
    }

    public static void main(String[] args) throws InvalidPatternException, ParseException {
        SMSTemplate template = new SMSTemplate();
        String msg = "Thanks for registering on CouchPotatoz.com. Your login id is %OTP%, please call us at .+ or write to us at af for any assistance.";
        template.setTemplate(msg);
        template.setDelimiter("%");
        template.setSenderId("COUCHP");
        template.setSmsEvent("SMSEvent.class.getName()");
        template.setId(100l);
        JsonObject jo = new JsonObject();
        JsonObject type = new JsonObject();
        type.addProperty("type", "STRING");
        jo.add("OTP", type);
        jo.add("SOMEVAR", type);
        template.setParams(Util.gson.toJson(jo));
        List<SMSTemplate> t = new ArrayList<>();
        t.add(template);
        SMSParser p = instance();
        p.updatePatterns(t);
        String otp = p.extractValue("COUCHP", "Thanks for registering on CouchPotatoz.com. Your login id is QSTRID, please call us at ^2^ or write to us at %Variable% for any assistance.", "OTP");
        System.out.println(otp);
        System.out.println(Arrays.asList(StringUtils.splitByWholeSeparator("1ABCD1", "ABCD", 2)));
    }

    public static synchronized SMSParser instance() {
        if (parser == null) {
            parser = new SMSParser();
        }
        return parser;
    }

    public void updatePatterns(List<SMSTemplate> templates) {
        List<String> invalidIds = new ArrayList<>();
        for (SMSTemplate template : templates) {
            try {
                JsonObject param = (JsonObject) Util.gsonParser.parse(template.getParams());
                String msg = template.getTemplate();
                String[] tokens = msg.split(template.getDelimiter());
                int count = StringUtils.countMatches(msg, template.getDelimiter());
                if (count % 2 != 0)
                    throw new InvalidPatternException("Invalid Number of delimiters");
                int start;
                Pattern p = new Pattern(template.getId(), template.getSmsEvent());
                if (msg.startsWith(template.getDelimiter())) {
                    p.startBlock(tokens[2], tokens[1], param);
                    start = 3;
                } else {
                    p.startBlock(tokens[0], null, param);
                    start = 1;
                }
                for (int i = start; i < tokens.length; i++) {
                    ++i;
                    if (i == tokens.length) {
                        p.endBlock(null, tokens[i - 1], param);
                    } else if (i == tokens.length - 1) {
                        p.endBlock(tokens[i], tokens[i - 1], param);
                    } else
                        p.addBlock(tokens[i], tokens[i - 1], param);
                }
                Set<Pattern> senderPatterns = patterns.get(template.getSenderId());
                if (senderPatterns == null) {
                    senderPatterns = new HashSet<>();
                    patterns.put(template.getSenderId(), senderPatterns);
                }
                senderPatterns.remove(p);
                senderPatterns.add(p);
            } catch (InvalidPatternException e) {
                e.printStackTrace();
                invalidIds.add(template.getId() + "");
            }
        }
    }

    public String extractValue(String senderId, String message, String key) throws InvalidPatternException, ParseException {
        Set<Pattern> senderPattern = patterns.get(senderId);
        if (senderPattern == null)
            return null;
        for (Pattern p : senderPattern) {
            Match match = p.extract(message);
            if (match.found) {
                return (String) match.values.get(key);
            }
        }
        return null;
    }
}

class Block {
    boolean isStart = false;
    boolean isEnd = false;
    String constant;
    String variable;
    DataFormat format;

}

class Match {
    boolean found = false;
    Map<String, Object> values = new HashMap<>();
}

class Pattern {
    List<Block> blocks = new ArrayList<>();
    String toEvent;
    long id;

    Pattern(long id, String eventClass) {
        this.id = id;
        this.toEvent = eventClass;
    }

    Block addBlock(String constant, String variable, JsonObject param) throws InvalidPatternException {
        Block b = new Block();
        b.constant = constant;
        b.variable = variable;
        if (!param.has(variable)) {
            throw new InvalidPatternException("Invalid Specification for variable match." + variable);
        }
        try {
            DataFormat f = new DataFormat();
            JsonObject p = (JsonObject) param.get(variable);
            f.type = Types.DataType.fromId(p.get("type").getAsString());
            f.format = p.has("format") ? p.get("format").getAsString() : null;
            f.regex = p.has("regex") ? p.get("regex").getAsString() : null;
            b.format = f;
        } catch (InvalidTypeException e) {
            throw new InvalidPatternException(e);
        }
        blocks.add(b);
        return b;
    }

    void startBlock(String constant, String variable, JsonObject param) throws InvalidPatternException {
        if (variable == null) {
            Block b = new Block();
            b.constant = constant;
            b.isStart = true;
            blocks.add(b);
        } else
            addBlock(constant, variable, param).isStart = true;
    }

    void endBlock(String constant, String variable, JsonObject param) throws InvalidPatternException {
        if (variable == null) {
            Block b = new Block();
            b.constant = constant;
            b.isEnd = true;
            blocks.add(b);
        } else
            addBlock(constant, variable, param).isEnd = true;
    }

    Match extract(String input) throws ParseException {
        String residue = input;

        Match match = new Match();
        for (Block b : blocks) {
            String value = null;
            String prevValue = residue;
            if (b.isStart && b.variable == null) {
                String[] splits = StringUtils.splitByWholeSeparator(input, b.constant, 2);
                residue = splits[0];
            } else if (b.isEnd) {
                if (b.variable == null) {
                    String[] splits = StringUtils.splitByWholeSeparator(residue, b.constant, 2);
                    residue = splits[0];
                    System.out.println("res=" + residue);
                } else {
                    String[] splits = StringUtils.splitByWholeSeparator(residue, b.constant, 2);
                    if (splits.length == 1)
                        value = splits[0];
                    else if (splits.length == 2) {
                        if (splits[1].trim().equals("")) {
                            value = splits[0];
                            //residue = "";
                        } else
                            value = splits[1];
                    } else break;
                }
                match.found = true;
            } else {
                String[] splits = StringUtils.splitByWholeSeparator(residue, b.constant, 2);
                if (splits.length == 1)
                    break;
                residue = splits[1];
                value = splits[0];
            }
//            if(residue.equals(prevValue))
//                break;
            if (value != null) {
                Object val = convertToType(b.format, value);
                match.values.put(b.variable, val);
            }
        }
        return match;
    }

    private Object convertToType(DataFormat format, String value) throws ParseException {
        Object val = null;
        switch (format.type) {
            case DATE:
                SimpleDateFormat date = new SimpleDateFormat(format.format);
                val = date.parse(value);
                break;
            case NUMBER:
                val = Double.parseDouble(value);
                break;
            case STRING:
                val = value;
                break;
            case INTEGER:
                val = Integer.parseInt(value);
                break;
        }
        return val;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pattern)) return false;

        Pattern pattern = (Pattern) o;

        return id == pattern.id;

    }

    @Override
    public int hashCode() {
        return (int) id;
    }
}

class DataFormat {
    DataType type;
    String format;
    String regex;
}

package com.study2know.core;
//import com.study2know.core.entity.Merchant;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by ashish on 8/12/16.
 */
public class DateTimeUtil {

    public static String createTimestamp() {
        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        String timestamp;
        int month = calendar.get(Calendar.MONTH);
        String day=String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        if(calendar.get(Calendar.DAY_OF_MONTH)<10)
            day="0"+day;
        month++;
        if (month > 10)
            timestamp = calendar.get(Calendar.YEAR) + "-" + month + "-" + day + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        else
            timestamp = calendar.get(Calendar.YEAR) + "-0" + month + "-" + day + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);
        return timestamp;
    }

    public static Date getTimeStamp(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        try{
            date=format.parse(createTimestamp());
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateStamp(String timestamp){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        try{
            date=format.parse(timestamp);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

    public static String getReverseDateStamp(Date timestamp){
        SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
        String date="";
        try{
            date=format.format(timestamp);
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static String getTimeStamp(Date timestamp){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date="";
        try{
            date=format.format(timestamp);
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateStamp(){

        return new java.sql.Date(Calendar.getInstance().getTimeInMillis());
    }

    public static Date getDateStamp(Date date){

        return new java.sql.Date(date.getTime());
    }


    public static Date parseRewardExpiryDate(String dateStamp){
        SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
        Date date=new Date();
        try{
            date=format.parse(dateStamp);

        } catch (Exception e){
            e.printStackTrace();
        }
        return getEndDateTimeStamp(date);
    }

    public static Date getTimeStamp(String timestamp){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        try{
            date=format.parse(timestamp);
        } catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    public static Date addHoursToDate(Date date,int hours){
        DateTime dateTime=new DateTime(date);
        dateTime=dateTime.plus(hours*60*60*1000);
        Date tempDate=dateTime.toDate();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date returnDate=new Date();
        try{
            returnDate=format.parse(format.format(tempDate));
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date addDaysToDate(Date date,int days){
        DateTime dateTime=new DateTime(date);
        dateTime=dateTime.plusDays(days);
        Date tempDate=dateTime.toDate();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date returnDate=new Date();
        try{
            returnDate=format.parse(format.format(tempDate));
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date addYearsToDate(Date date,int years){
        DateTime dateTime=new DateTime(date);
        dateTime=dateTime.plusYears(years);
        Date tempDate=dateTime.toDate();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date returnDate=null;
        try{
            returnDate=format.parse(format.format(tempDate));
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date subtractMinutesToDate(Date date,int minutes){
        DateTime dateTime=new DateTime(date);
        dateTime=dateTime.minus(minutes*60*1000);
        Date tempDate=dateTime.toDate();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date returnDate=null;
        try{
            returnDate=format.parse(format.format(tempDate));
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date subtractHoursToDate(Date date,int hours){
        DateTime dateTime=new DateTime(date);
        dateTime=dateTime.minus(hours*60*60*1000);
        //dateTime.plusHours(hours);
        Date tempDate=dateTime.toDate();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date returnDate=new Date();
        try{
            returnDate=format.parse(format.format(tempDate));
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date subtractDaysToDate(Date date,int days){
        DateTime dateTime=new DateTime(date);
        dateTime=dateTime.minusDays(days);
        //dateTime=dateTime.minus(days*24*60*60*1000);
        //dateTime.plusHours(hours);
        Date tempDate=dateTime.toDate();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date returnDate=new Date();
        try{
            returnDate=format.parse(format.format(tempDate));
        } catch (Exception e){
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date getStartDateTimeStamp(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime=new DateTime(getTimeStamp());
        DateTime date=new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth(),0,0,0);
        Date datetimestamp=new Date();
        try{
            datetimestamp=format.parse(format.format(date.toDate()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return datetimestamp;
    }

    public static Date getEndDateTimeStamp(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime=new DateTime(getTimeStamp());
        DateTime date=new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth(),23,59,59);
        Date datetimestamp=new Date();
        try{
            datetimestamp=format.parse(format.format(date.toDate()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return datetimestamp;
    }

    public static Date getStartDateTimeStamp(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime=new DateTime(date);
        DateTime dateTemp=new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth(),0,0,0);
        Date datetimestamp=new Date();
        try{
            datetimestamp=format.parse(format.format(dateTemp.toDate()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return datetimestamp;
    }

    public static Date getEndDateTimeStamp(Date date){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime=new DateTime(date);
        DateTime dateTemp=new DateTime(dateTime.getYear(),dateTime.getMonthOfYear(),dateTime.getDayOfMonth(),23,59,59);
        Date datetimestamp=new Date();
        try{
            datetimestamp=format.parse(format.format(dateTemp.toDate()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return datetimestamp;
    }

    public static String getFormattedDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = null;

        try {

            d1 = date;
            DateTime dt1 = new DateTime(d1);
            int dayOfMonth=dt1.getDayOfMonth();
            int month=dt1.getMonthOfYear();
            String monthTxt;
            switch(month){
                case 1: monthTxt="Jan";
                    break;
                case 2: monthTxt="Feb";
                    break;
                case 3: monthTxt="Mar";
                    break;
                case 4: monthTxt="Apr";
                    break;
                case 5: monthTxt="May";
                    break;
                case 6: monthTxt="June";
                    break;
                case 7: monthTxt="July";
                    break;
                case 8: monthTxt="Aug";
                    break;
                case 9: monthTxt="Sep";
                    break;
                case 10: monthTxt="Oct";
                    break;
                case 11: monthTxt="Nov";
                    break;
                default: monthTxt="Dec";
            }
            int year=dt1.getYear();
            StringBuilder formattedDate=new StringBuilder();
            formattedDate.append(dayOfMonth);
            formattedDate.append(" ");
            formattedDate.append(monthTxt);
            formattedDate.append(" ");
            formattedDate.append(year);
            return formattedDate.toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static Date getMonday(Date date){
        LocalDate localDate=new LocalDate(date);
        localDate=localDate.withDayOfWeek(DateTimeConstants.MONDAY);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        DateTime dateTime=new DateTime(localDate.toDate());
        Date datetimestamp=new Date();
        try{
            datetimestamp=format.parse(format.format(dateTime.toDate()));
            java.sql.Date date1=new java.sql.Date(datetimestamp.getTime());
            System.out.println(date1);
            System.out.println(format.format(dateTime.toDate()));
            return date1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return datetimestamp;
    }

    public static Date getFirstOfMonth(Date date){
        LocalDate localDate=new LocalDate(date);
        localDate=localDate.withDayOfMonth(1);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        DateTime dateTime=new DateTime(localDate.toDate());
        Date datetimestamp=new Date();
        try{
            datetimestamp=format.parse(format.format(dateTime.toDate()));
            java.sql.Date date1=new java.sql.Date(datetimestamp.getTime());
            System.out.println(date1);
            System.out.println(format.format(dateTime.toDate()));
            return date1;
        } catch (Exception e){

            e.printStackTrace();
        }
        return datetimestamp;
    }

    public static Date getLastOfMonth(Date date){

        return getDateStamp(subtractDaysToDate(new DateTime(getFirstOfMonth(date)).plusMonths(1).toDate(),1));
    }

    public static Date getLastOfWeek(Date date){
        return getDateStamp(subtractDaysToDate(new DateTime(getMonday(date)).plusWeeks(1).toDate(),1));
    }

//    public static String[] parseDateString(String string,Merchant merchant) {
//        String[] dates=new String[2];
//        Date start,end;
//
//        switch (string.toLowerCase()) {
//            case "today":
//                start = getStartDateTimeStamp();
//                end   = getEndDateTimeStamp();
//                break;
//
//            case "tomorrow":
//                start = addDaysToDate(getStartDateTimeStamp(),1);
//                end   = addDaysToDate(getEndDateTimeStamp(),1);
//                break;
//            case "yesterday":
//                start = subtractDaysToDate(getStartDateTimeStamp(),1);
//                end   = subtractDaysToDate(getEndDateTimeStamp(),1);
//                break;
//
//            case "next week":
//                start = getStartDateTimeStamp();
//                end   = addDaysToDate(getEndDateTimeStamp(),7);
//                break;
//            case "last week":
//                start = subtractDaysToDate(getStartDateTimeStamp(),7);
//                end   = getEndDateTimeStamp();
//                break;
//            case "next month":
//                start = getStartDateTimeStamp();
//                end   = addDaysToDate(getEndDateTimeStamp(),30);
//                break;
//
//            case "last month":
//                start = subtractDaysToDate(getStartDateTimeStamp(),30);
//                end   = getEndDateTimeStamp();
//                break;
//            case "last 1 month":
//                start = subtractDaysToDate(getStartDateTimeStamp(),30);
//                end   = getEndDateTimeStamp();
//                break;
//            case "last 3 months":
//                start = getFirstOfMonth(new DateTime(getTimeStamp()).minusMonths(3).toDate());
//                end   = getDateStamp(subtractDaysToDate(getFirstOfMonth(getTimeStamp()),1));
//                break;
//            case "next 3 months":
//                start = getStartDateTimeStamp();
//                end   = addDaysToDate(getEndDateTimeStamp(),90);
//                break;
//            case "last 6 months":
//                start = getFirstOfMonth(new DateTime(getTimeStamp()).minusMonths(6).toDate());
//                end   = getDateStamp(subtractDaysToDate(getFirstOfMonth(getTimeStamp()),1));
//                break;
//            case "all time":
//                if(merchant==null){
//                    start=subtractDaysToDate(getStartDateTimeStamp(),24*30);
//                } else {
//                    start=merchant.getCreated_on();
//                }
//
//                end= getEndDateTimeStamp();
//
//                break;
//            default:
//                start = subtractDaysToDate(getStartDateTimeStamp(),30);
//                end   = getEndDateTimeStamp();
//                break;
//        }
//        dates[0] = getTimeStamp(start);
//        dates[1] = getTimeStamp(end);
//        return dates;
//    }

    public static  String getFormattedDateTime(Date d1){

        try {
            DateTime dt1 = new DateTime(d1);
            int dayOfMonth=dt1.getDayOfMonth();
            int month=dt1.getMonthOfYear();
            String monthTxt;
            switch(month){
                case 1: monthTxt="Jan";
                    break;
                case 2: monthTxt="Feb";
                    break;
                case 3: monthTxt="Mar";
                    break;
                case 4: monthTxt="Apr";
                    break;
                case 5: monthTxt="May";
                    break;
                case 6: monthTxt="June";
                    break;
                case 7: monthTxt="July";
                    break;
                case 8: monthTxt="Aug";
                    break;
                case 9: monthTxt="Sep";
                    break;
                case 10: monthTxt="Oct";
                    break;
                case 11: monthTxt="Nov";
                    break;
                default: monthTxt="Dec";
            }
            int year=dt1.getYear();
            int hour=dt1.getHourOfDay();
            String timeOfDay="AM";
            if(hour>12) {
                hour -=12;
                timeOfDay="PM";
            }
            else
            if(hour==12){
                timeOfDay="PM";
            }
            int min=dt1.getMinuteOfHour();
            StringBuilder formattedDate=new StringBuilder();
            formattedDate.append(dayOfMonth);
            formattedDate.append(" ");
            formattedDate.append(monthTxt);
            formattedDate.append(" ");
            formattedDate.append(year);
            formattedDate.append(", ");
            formattedDate.append(hour);
            formattedDate.append(":");
            if(min<10)
                formattedDate.append("0");
            formattedDate.append(min);
            formattedDate.append(" ");
            formattedDate.append(timeOfDay);
            return formattedDate.toString();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

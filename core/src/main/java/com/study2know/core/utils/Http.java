package com.study2know.core.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Http {

    private static Http instance;
    private MultiThreadedHttpConnectionManager connectionManager;

    private Http() {
        connectionManager = new MultiThreadedHttpConnectionManager();
        HttpConnectionManagerParams params = connectionManager.getParams();
        params.setDefaultMaxConnectionsPerHost(200);
        params.setMaxTotalConnections(200);
        connectionManager.setParams(params);
    }

    public static Http instance() {
        if (instance == null)
            synchronized (Http.class) {
                if (instance == null)
                    instance = new Http();
            }
        return instance;
    }
//
//    public static void main(String[] args) throws IOException {
//        //String input = JSONValue.toJSONString(location);
//        GetMethod get = new GetMethod("http://54.254.239.158:9000/api/xeno/userquest/v0/openquests/123");
//        HttpMethodParams params = new HttpMethodParams();
//        params.set
//        Http.instance().post(post, 25);
//    }

    public static void main(String[] args) throws HttpCallException {


//        UserContextInfo ctx1 = JSONValue.parse(payload, UserContextInfo.class);
//        System.out.println(ctx1.apps.getStat("FLIPKART").installTime);
//        payload = JSONValue.toJSONString(ctx);
//        try {
//            post.setRequestEntity(new StringRequestEntity(payload, contentType, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        try {
//            System.out.println(Http.instance().execute(post, 5000));
//        } catch (HttpCallException e) {
//            System.out.println(e.msg + e.status);
//        }
    }

    public String execute(HttpMethod method, int timeout) throws HttpCallException {
        int statusCode;
        String returnStr = "";
        HttpClient httpClient = new HttpClient(connectionManager);
        httpClient.getParams().setSoTimeout(timeout);
        InputStream in = null;
        try {
            statusCode = httpClient.executeMethod(method);


            in = method.getResponseBodyAsStream();
            InputStreamReader inReader = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inReader);

            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            returnStr = sb.toString();
            if (statusCode != HttpStatus.SC_OK) {
                HttpCallException ex = new HttpCallException(statusCode, returnStr);
                throw ex;
            }
            return returnStr;
        } catch (IOException e) {
            HttpCallException ex = new HttpCallException(-1, returnStr);
            throw ex;
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

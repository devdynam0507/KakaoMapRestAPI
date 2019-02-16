package com.ndy.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class HttpConnectUtil {

    public static HttpURLConnection getConnection(String connectURL) {
        try {
            URL url = new URL(connectURL);
            return (HttpURLConnection) url.openConnection();
        }catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public static void setRequestMethod(HttpURLConnection connection, String method) {
        try {
            connection.setRequestMethod(method);
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
    }

    public static void setRequestProperty(HttpURLConnection connection, String headerKey, String headerValue) { connection.setRequestProperty(headerKey, headerValue); }

    public static int getResponseCode(HttpURLConnection connection) {
        try {
            return connection.getResponseCode();
        }catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean isResponseSuccess(int code) { return code == 200; }

    public static String encodeString(String encodeable) {
        try{
            return URLEncoder.encode(encodeable, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();

            return "";
        }
    }

}

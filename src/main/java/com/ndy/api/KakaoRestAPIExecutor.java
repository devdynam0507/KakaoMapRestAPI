package com.ndy.api;

import com.ndy.util.HttpConnectUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class KakaoRestAPIExecutor extends Thread implements Runnable {

    private KakaoRestAPI api;
    private String json;

    public KakaoRestAPIExecutor(KakaoRestAPI api) {
        this.api = api;
    }

    /**
     * @return json
     * */
    public String execute() {
        try {
            start();
            join();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @Override
    public void run() {
        HttpURLConnection connection = api.getConnection();
        HttpConnectUtil.setRequestMethod(connection, api.getApiType().getRequestType().name());
        HttpConnectUtil.setRequestProperty(connection, "Authorization", api.getAuthorization().getAuthorizationKey());

        read(connection);
    }

    private synchronized boolean read(HttpURLConnection connection) {
        int responseCode = HttpConnectUtil.getResponseCode(connection);

        if(!HttpConnectUtil.isResponseSuccess(responseCode)) return false;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder builder = new StringBuilder();

            while((line = reader.readLine()) != null) builder.append(line);

            this.json = builder.toString();
            return true;
        }catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }

}

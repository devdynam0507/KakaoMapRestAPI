package com.ndy.api;

import com.ndy.type.KakaoRestAPIType;
import com.ndy.auth.KakaoAuthorization;
import com.ndy.util.HttpConnectUtil;

import java.net.HttpURLConnection;

public class KakaoRestAPI {

    private KakaoRestAPIType apiType;
    private KakaoAuthorization authorization;
    private String parameter;

    public KakaoRestAPI(KakaoAuthorization authorization, KakaoRestAPIType apiType, String parameter) {
        this.authorization = authorization;
        this.apiType = apiType;
        this.parameter = parameter;
    }

    public static KakaoRestAPIBuilder builder(String restAPIKey) { return new KakaoRestAPIBuilder(restAPIKey); }

    public KakaoAuthorization getAuthorization() { return authorization; }

    public KakaoRestAPIType getApiType() { return apiType; }

    public String getParameter() { return parameter; }

    public HttpURLConnection getConnection() {
        StringBuilder builder = new StringBuilder();

        builder.append(apiType.getHost()).append(parameter);

        return HttpConnectUtil.getConnection(builder.toString());
    }

    public static class KakaoRestAPIBuilder {

        private KakaoAuthorization authorization;
        private KakaoRestAPIType apiType;
        private String parameter;

        public KakaoRestAPIBuilder(String restAPIKey) {
            authorization = new KakaoAuthorization(restAPIKey);
        }

        public KakaoRestAPIBuilder setRestAPIType(KakaoRestAPIType type) {
            this.apiType = type;

            return this;
        }

        public KakaoRestAPIBuilder setParameter(String parameter) {
            this.parameter = parameter;

            return this;
        }

        public KakaoRestAPI build() { return new KakaoRestAPI(authorization, apiType, parameter); }

    }

}

package com.ndy.auth;

public class KakaoAuthorization {

    private final String restAPIKey; /** Kakao developers rest-api key! */

    public KakaoAuthorization(String restAPIKey) {
        this.restAPIKey = restAPIKey;
    }

    public String getAuthorizationKey() { return "KakaoAK " + restAPIKey; }

}

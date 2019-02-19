## Kakao Map Rest-API를 호출하는 방법
```java
        String regionName = HttpConnectUtil.encodeString("카카오프렌즈");
        String query = "query=" + regionName;

        KakaoRestAPI api = KakaoRestAPI
                .builder("KKKKKKKKKKKKKKKKKKKKKK")
                .setRestAPIType(KakaoRestAPIType.SearchingByKeword)
                .setParameter(query)
                .build();

        KakaoRestAPIExecutor executor = new KakaoRestAPIExecutor(api);
        executor.start();
```


## Kakao Map Rest-API를 호출하기 위해 Build를 해주는 클래스
com.ndy.api.KakaoRestAPI



## Kakao Map Rest-API를 호출하는 클래스
com.ndy.api.KakaoRestAPIExecutor

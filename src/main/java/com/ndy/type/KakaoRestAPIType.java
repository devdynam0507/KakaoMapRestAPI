package com.ndy.type;

public enum KakaoRestAPIType {

    SearchAddress("https://dapi.kakao.com/v2/local/search/address.json?", RequestType.GET), /* 주소 검색 */
    CoordinateToAdministrativeAreaInformation("https://dapi.kakao.com/v2/local/geo/coord2regioncode.json?", RequestType.GET), /* 좌표 -> 행정구역정보 */
    CoordinateToAdress("https://dapi.kakao.com/v2/local/geo/coord2address.json?", RequestType.GET), /* 좌표 -> 주소 */
    CoordinateConvert("https://dapi.kakao.com/v2/local/geo/transcoord.json?", RequestType.GET), /* 좌표계 변환 */
    SearchingByKeword("https://dapi.kakao.com/v2/local/search/keyword.json?", RequestType.GET), /* 키워드로 장소검색 */
    SearchingByCategory("https://dapi.kakao.com/vs/local/search/category.json?", RequestType.GET); /* 카테고리로 장소검색 */

    private String host;
    private RequestType type;

    KakaoRestAPIType(String host, RequestType requestType) {
        this.host = host;
        this.type = requestType;
    }

    public String getHost() { return host; }

    public RequestType getRequestType() { return type; }
}

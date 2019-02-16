import com.ndy.api.KakaoRestAPI;
import com.ndy.api.KakaoRestAPIExecutor;
import com.ndy.type.KakaoRestAPIType;
import com.ndy.util.HttpConnectUtil;

public class Main {

    public static void main(String... args) {
        String regionName = HttpConnectUtil.encodeString("카카오프렌즈");
        String query = "query=" + regionName;

        KakaoRestAPI api = KakaoRestAPI
                .builder("KKKKKKKKKKKKKKKKKKKKKK") /* api key */
                .setRestAPIType(KakaoRestAPIType.SearchingByKeword) /* https://developers.kakao.com/docs/restapi/local */
                .setParameter(query)
                .build();

        KakaoRestAPIExecutor executor = new KakaoRestAPIExecutor(api);
        executor.start();
    }

}

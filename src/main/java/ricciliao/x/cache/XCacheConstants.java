package ricciliao.x.cache;

public class XCacheConstants {

    private XCacheConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String HTTP_HEADER_FOR_CACHE_CUSTOMER = "Cache-Customer";
    public static final String HTTP_HEADER_FOR_CACHE_STORE = "Cache-Store";
    public static final String DEFAULT_PROVIDER_OPERATION_PATH = "http://ricci-cache-provider:8083/operation"; //NOSONAR

}

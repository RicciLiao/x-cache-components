package ricciliao.x.cache;

import ricciliao.x.cache.pojo.ConsumerCacheStore;

import java.lang.reflect.Array;

public class CacheOperationUtils {
    private CacheOperationUtils() {
        throw new IllegalStateException("Utility class");
    }

    @SuppressWarnings("unchecked")
    public static <T extends ConsumerCacheData> ConsumerCacheStore<T>[] createArray(int size) {

        return (ConsumerCacheStore<T>[]) Array.newInstance(ConsumerCacheStore.class, size);
    }
}

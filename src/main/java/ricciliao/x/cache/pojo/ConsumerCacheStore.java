package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerCacheData;

import java.io.Serial;
import java.io.Serializable;

public class ConsumerCacheStore<T extends ConsumerCacheData> extends CacheStore<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -8920728831428092290L;

    public ConsumerCacheStore() {
    }

    public ConsumerCacheStore(T data) {
        super();
        this.setData(data);
    }
}

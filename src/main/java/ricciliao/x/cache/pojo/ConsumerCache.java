package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerStore;

import java.io.Serial;
import java.io.Serializable;

public class ConsumerCache<T extends ConsumerStore> extends StoreCache<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -8920728831428092290L;
    private Long ttlSec;

    public ConsumerCache() {
    }

    public ConsumerCache(T data) {
        super();
        this.setStore(data);
    }

    public ConsumerCache(Long ttlSec, T data) {
        super();
        this.setStore(data);
        this.setTtlSec(ttlSec);
    }

    public Long getTtlSec() {
        return ttlSec;
    }

    public void setTtlSec(Long ttlSec) {
        this.ttlSec = ttlSec;
    }
}

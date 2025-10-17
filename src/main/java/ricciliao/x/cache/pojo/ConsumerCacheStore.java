package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerCacheData;
import ricciliao.x.component.response.data.ResponseData;

import java.io.Serial;
import java.time.Instant;
import java.util.List;

public class ConsumerCacheStore<T extends ConsumerCacheData> extends CacheStore<T> implements ResponseData {
    @Serial
    private static final long serialVersionUID = -8920728831428092290L;

    public ConsumerCacheStore() {
    }

    public ConsumerCacheStore(T data) {
        super();
        this.setData(data);
    }

    public ConsumerCacheStore(Long ttlSec, T data) {
        super();
        this.setData(data);
        this.setTtlSec(ttlSec);
    }

    private Long ttlSec;
    private Instant ttlExpiredDtm;

    public Long getTtlSec() {
        return ttlSec;
    }

    public void setTtlSec(Long ttlSec) {
        this.ttlSec = ttlSec;
    }

    public Instant getTtlExpiredDtm() {
        return ttlExpiredDtm;
    }

    public void setTtlExpiredDtm(Instant ttlExpiredDtm) {
        this.ttlExpiredDtm = ttlExpiredDtm;
    }

    public static class Batch<T extends ConsumerCacheData> extends CacheStore.Batch<ConsumerCacheStore<T>> implements ResponseData {
        @Serial
        private static final long serialVersionUID = 5741410145008457634L;

        public Batch(List<ConsumerCacheStore<T>> batch) {
            super(batch);
        }
    }
}

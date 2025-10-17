package ricciliao.x.cache.pojo;

import ricciliao.x.cache.annotation.CacheData;
import ricciliao.x.cache.annotation.CacheId;
import ricciliao.x.cache.query.CacheQuery;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public class CacheStore<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = -7838083516165280621L;

    @CacheQuery.Support(CacheQuery.Property.CACHE_KEY)
    @CacheId
    private String cacheKey;
    @CacheQuery.Support(CacheQuery.Property.CREATED_DTM)
    private Instant createdDtm;
    @CacheQuery.Support(CacheQuery.Property.UPDATED_DTM)
    private Instant updatedDtm;
    @CacheData
    private T data;

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public Instant getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(Instant createdDtm) {
        this.createdDtm = createdDtm;
    }

    public Instant getUpdatedDtm() {
        return updatedDtm;
    }

    public void setUpdatedDtm(Instant updatedDtm) {
        this.updatedDtm = updatedDtm;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public static class Batch<T extends CacheStore<? extends Serializable>> implements Serializable {
        @Serial
        private static final long serialVersionUID = 5741410145008457634L;
        private final List<T> batch;

        public Batch(List<T> batch) {
            this.batch = batch;
        }

        public List<T> batch() {
            return batch;
        }

    }
}

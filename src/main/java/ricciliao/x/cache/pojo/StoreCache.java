package ricciliao.x.cache.pojo;

import ricciliao.x.cache.annotation.CacheId;
import ricciliao.x.cache.annotation.Store;
import ricciliao.x.cache.query.CacheQuery;
import ricciliao.x.component.response.data.ResponseData;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class StoreCache<T extends Serializable> implements ResponseData {
    @Serial
    private static final long serialVersionUID = -7838083516165280621L;

    @CacheQuery.Support(CacheQuery.Property.CACHE_KEY)
    @CacheId
    private String cacheKey;
    @CacheQuery.Support(CacheQuery.Property.CREATED_DTM)
    private Instant createdDtm;
    @CacheQuery.Support(CacheQuery.Property.UPDATED_DTM)
    private Instant updatedDtm;
    private Instant ttlEffectedDtm;
    @Store
    private T store;

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

    public Instant getTtlEffectedDtm() {
        return ttlEffectedDtm;
    }

    public void setTtlEffectedDtm(Instant ttlEffectedDtm) {
        this.ttlEffectedDtm = ttlEffectedDtm;
    }

    public T getStore() {
        return store;
    }

    public void setStore(T store) {
        this.store = store;
    }
}

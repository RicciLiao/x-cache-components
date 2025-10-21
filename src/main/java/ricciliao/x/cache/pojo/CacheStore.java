package ricciliao.x.cache.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ricciliao.x.cache.annotation.CacheData;
import ricciliao.x.cache.annotation.CacheId;
import ricciliao.x.cache.query.CacheQuery;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CacheStore<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = -7838083516165280621L;

    @CacheQuery.Support(CacheQuery.Property.CACHE_KEY)
    @CacheId
    private String cacheKey;
    @CacheQuery.Support(CacheQuery.Property.CREATED_DTM)
    private LocalDateTime createdDtm;
    @CacheQuery.Support(CacheQuery.Property.UPDATED_DTM)
    private LocalDateTime updatedDtm;
    @JsonIgnore
    private LocalDateTime effectedDtm;
    @CacheData
    private T data;

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public LocalDateTime getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(LocalDateTime createdDtm) {
        this.createdDtm = createdDtm;
    }

    public LocalDateTime getUpdatedDtm() {
        return updatedDtm;
    }

    public void setUpdatedDtm(LocalDateTime updatedDtm) {
        this.updatedDtm = updatedDtm;
    }

    public LocalDateTime getEffectedDtm() {
        return effectedDtm;
    }

    public void setEffectedDtm(LocalDateTime effectedDtm) {
        this.effectedDtm = effectedDtm;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

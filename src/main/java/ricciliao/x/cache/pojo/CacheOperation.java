package ricciliao.x.cache.pojo;


import ricciliao.x.cache.annotation.CacheData;
import ricciliao.x.component.response.ResponseData;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class CacheOperation<T extends Serializable> implements ResponseData {
    @Serial
    private static final long serialVersionUID = 4101945702683481033L;
    private Long ttlOfSeconds;
    @CacheData
    private T data;

    public CacheOperation() {
    }

    public CacheOperation(T data) {
        this.data = data;
    }

    public CacheOperation(Long ttlOfSeconds, T data) {
        this.ttlOfSeconds = ttlOfSeconds;
        this.data = data;
    }

    public Long getTtlOfSeconds() {
        return ttlOfSeconds;
    }

    public void setTtlOfSeconds(Long ttlOfSeconds) {
        this.ttlOfSeconds = ttlOfSeconds;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CacheOperation<?> that)) return false;
        return Objects.equals(getTtlOfSeconds(), that.getTtlOfSeconds()) && Objects.equals(getData(), that.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTtlOfSeconds(), getData());
    }

}

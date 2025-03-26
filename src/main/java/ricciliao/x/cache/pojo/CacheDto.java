package ricciliao.x.cache.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ricciliao.x.cache.CacheKey;
import ricciliao.x.component.response.ResponseData;
import ricciliao.x.component.serialisation.LocalDateTime2TimestampSerializer;
import ricciliao.x.component.serialisation.Timestamp2LocalDateTimeDeserializer;

import java.io.Serial;
import java.time.LocalDateTime;

public abstract class CacheDto implements ResponseData {
    @Serial
    private static final long serialVersionUID = -5939196155346350122L;

    @CacheKey
    private String cacheKey;
    @JsonSerialize(using = LocalDateTime2TimestampSerializer.class)
    @JsonDeserialize(using = Timestamp2LocalDateTimeDeserializer.class)
    private LocalDateTime createdDtm;
    @JsonSerialize(using = LocalDateTime2TimestampSerializer.class)
    @JsonDeserialize(using = Timestamp2LocalDateTimeDeserializer.class)
    private LocalDateTime updatedDtm;
    @JsonIgnore
    private LocalDateTime effectedDtm;

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

    public abstract CacheDto buildCacheKey();

}

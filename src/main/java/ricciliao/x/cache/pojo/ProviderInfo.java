package ricciliao.x.cache.pojo;

import ricciliao.x.component.response.ResponseData;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Objects;

public class ProviderInfo implements ResponseData {
    @Serial
    private static final long serialVersionUID = -3013557418500676494L;
    private Long count;
    private LocalDateTime createdDtm;
    private LocalDateTime maxUpdatedDtm;
    private ConsumerIdentifier consumerIdentifier;
    public ProviderInfo() {
    }
    public ProviderInfo(ConsumerIdentifier consumerIdentifier) {
        this.consumerIdentifier = consumerIdentifier;
        this.count = 0L;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public LocalDateTime getCreatedDtm() {
        return createdDtm;
    }

    public void setCreatedDtm(LocalDateTime createdDtm) {
        this.createdDtm = createdDtm;
    }

    public LocalDateTime getMaxUpdatedDtm() {
        return maxUpdatedDtm;
    }

    public void setMaxUpdatedDtm(LocalDateTime maxUpdatedDtm) {
        this.maxUpdatedDtm = maxUpdatedDtm;
    }

    public ConsumerIdentifier getConsumerIdentifier() {
        return consumerIdentifier;
    }

    public void setConsumerIdentifier(ConsumerIdentifier consumerIdentifier) {
        this.consumerIdentifier = consumerIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProviderInfo that)) return false;
        return Objects.equals(getCount(), that.getCount()) && Objects.equals(getCreatedDtm(), that.getCreatedDtm()) && Objects.equals(getMaxUpdatedDtm(), that.getMaxUpdatedDtm()) && Objects.equals(getConsumerIdentifier(), that.getConsumerIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount(), getCreatedDtm(), getMaxUpdatedDtm(), getConsumerIdentifier());
    }
}

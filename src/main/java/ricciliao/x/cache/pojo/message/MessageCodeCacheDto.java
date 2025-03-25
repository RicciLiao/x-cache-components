package ricciliao.x.cache.pojo.message;

import ricciliao.x.cache.pojo.CacheDto;

import java.io.Serial;
import java.util.Objects;

public class MessageCodeCacheDto extends CacheDto {
    @Serial
    private static final long serialVersionUID = 921069393141718604L;

    private String code;
    private String level;
    private String consumer;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MessageCodeCacheDto that)) return false;
        return Objects.equals(getCode(), that.getCode()) && Objects.equals(getLevel(), that.getLevel()) && Objects.equals(getConsumer(), that.getConsumer()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getLevel(), getConsumer(), getDescription());
    }

    @Override
    public MessageCodeCacheDto buildCacheKey() {
        this.setCacheKey(
                String.format(
                        "%s_%s",
                        this.consumer == null ? "" : this.consumer.trim(),
                        this.code == null ? "" : this.code.trim()
                )
        );

        return this;
    }
}

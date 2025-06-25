package ricciliao.x.cache.pojo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ConsumerIdentifier implements Serializable {
    @Serial
    private static final long serialVersionUID = -6723685925978483107L;
    private String consumer;
    private String store;

    public ConsumerIdentifier(String consumer, String store) {
        this.consumer = consumer;
        this.store = store;
    }
    public ConsumerIdentifier() {
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public String toString() {

        return String.format(
                "%s_%s",
                consumer == null ? "" : consumer.trim().toLowerCase(),
                store == null ? "" : store.trim().toLowerCase()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumerIdentifier that)) return false;
        return Objects.equals(getConsumer(), that.getConsumer()) && Objects.equals(getStore(), that.getStore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getConsumer(), getStore());
    }
}

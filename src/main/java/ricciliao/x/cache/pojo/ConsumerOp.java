package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerData;
import ricciliao.x.component.response.ResponseData;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConsumerOp implements Serializable, ResponseData {
    @Serial
    private static final long serialVersionUID = 4101945702683481033L;

    private String id;
    private Long ttlOfMillis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTtlOfMillis() {
        return ttlOfMillis;
    }

    public void setTtlOfMillis(Long ttlOfMillis) {
        this.ttlOfMillis = ttlOfMillis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsumerOp that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTtlOfMillis(), that.getTtlOfMillis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTtlOfMillis());
    }

    public static class Batch<T extends CacheDto> extends ConsumerOp {
        @Serial
        private static final long serialVersionUID = -3756043554516531820L;
        @ConsumerData
        private List<T> data = new ArrayList<>();

        public Batch() {
            super();
        }

        public Batch(List<T> data) {
            super();
            this.data = data;
        }

        public Batch(List<T> data, Long ttlOfMillis) {
            super();
            this.setTtlOfMillis(ttlOfMillis);
            this.data = data;
        }

        public List<T> getData() {
            return data;
        }

        public void setData(List<T> data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Batch<?> batch)) return false;
            if (!super.equals(o)) return false;
            return Objects.equals(getData(), batch.getData());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getData());
        }

    }

    public static class Single<T extends CacheDto> extends ConsumerOp {
        @Serial
        private static final long serialVersionUID = -1531312546295535024L;
        @ConsumerData
        private T data;

        public Single() {
            super();
        }

        public Single(T data) {
            super();
            this.data = data;
        }

        public Single(T data, Long ttlOfMillis) {
            super();
            this.setTtlOfMillis(ttlOfMillis);
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Single<?> single)) return false;
            if (!super.equals(o)) return false;
            return Objects.equals(getData(), single.getData());
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), getData());
        }

    }
}

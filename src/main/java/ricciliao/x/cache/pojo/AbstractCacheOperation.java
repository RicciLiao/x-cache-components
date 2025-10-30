package ricciliao.x.cache.pojo;


import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractCacheOperation<T extends Serializable> implements Serializable {
    @Serial
    private static final long serialVersionUID = -809725412591353599L;
    private T data;

    protected AbstractCacheOperation() {
    }

    protected AbstractCacheOperation(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class Single<T extends StoreCache<? extends Serializable>> extends AbstractCacheOperation<T> {
        @Serial
        private static final long serialVersionUID = -7003500375213385988L;

        public Single() {
            super();
        }

        public Single(T data) {
            super(data);
        }
    }

    public static class Batch<T extends StoreCache<? extends Serializable>> extends AbstractCacheOperation<T[]> {
        @Serial
        private static final long serialVersionUID = -6556552414049238030L;

        public Batch() {
            super();
        }

        public Batch(T[] data) {
            super(data);
        }
    }
}

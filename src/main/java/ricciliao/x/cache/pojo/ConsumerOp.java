package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerCacheData;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;
import java.util.function.IntFunction;

public class ConsumerOp<T extends Serializable> extends CacheOperation<T> {
    @Serial
    private static final long serialVersionUID = -3697115362452176598L;

    public ConsumerOp() {
    }

    public ConsumerOp(T data) {
        super(data);
    }

    public ConsumerOp(Long ttlOfSeconds, T data) {
        super(ttlOfSeconds, data);
    }

    public static class Single<T extends ConsumerCacheData> extends ConsumerOp<ConsumerCacheStore<T>> {
        @Serial
        private static final long serialVersionUID = -4198488521122910649L;

        public Single() {
            super();
        }

        public Single(T data) {
            super(new ConsumerCacheStore<>(data));
        }

        public Single(ConsumerCacheStore<T> data) {
            super(data);
        }

        public Single(Long ttlOfSeconds, ConsumerCacheStore<T> data) {
            super(ttlOfSeconds, data);
        }
    }

    public static class Batch<T extends ConsumerCacheData> extends ConsumerOp<ConsumerCacheStore<T>[]> {
        @Serial
        private static final long serialVersionUID = -4198488521122910649L;

        public Batch() {
            super();
        }

        public Batch(T[] data) {
            super();
            this.setData(
                    Arrays.stream(data)
                            .map(ConsumerCacheStore::new)
                            .toArray((IntFunction<ConsumerCacheStore<T>[]>) ConsumerCacheStore[]::new)
            );
        }

        public Batch(ConsumerCacheStore<T>[] data) {
            super(data);
        }

        public Batch(Long ttlOfSeconds, ConsumerCacheStore<T>[] data) {
            super(ttlOfSeconds, data);
        }
    }

}

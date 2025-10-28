package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerStore;

import java.io.Serial;

public interface ConsumerOperation {

    static <T extends ConsumerStore> Single<T> of(ConsumerCache<T> single) {

        return new ConsumerOperation.Single<>(single);
    }

    static <T extends ConsumerStore> Batch<T> of(ConsumerCache<T>[] batch) {

        return new ConsumerOperation.Batch<>(batch);
    }

    class Single<T extends ConsumerStore> extends AbstractCacheOperation.Single<ConsumerCache<T>> {
        @Serial
        private static final long serialVersionUID = 4494023335265707838L;

        public Single() {
        }

        public Single(ConsumerCache<T> data) {
            super(data);
        }
    }

    class Batch<T extends ConsumerStore> extends AbstractCacheOperation.Batch<ConsumerCache<T>> {
        @Serial
        private static final long serialVersionUID = 2691005713441996866L;

        public Batch() {
        }

        public Batch(ConsumerCache<T>[] data) {
            super(data);
        }
    }

}

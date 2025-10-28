package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerStore;

import java.io.Serial;
import java.util.Arrays;

public interface ConsumerOperation {

    static <T extends ConsumerStore> Single<T> of(ConsumerCache<T> single) {

        return new ConsumerOperation.Single<>(single);
    }

    static <T extends ConsumerStore> Single<T> of(T store) {

        return new ConsumerOperation.Single<>(new ConsumerCache<>(store));
    }

    static <T extends ConsumerStore> Batch<T> of(ConsumerCache<T>[] batch) {

        return new ConsumerOperation.Batch<>(batch);
    }

    static <T extends ConsumerStore> Batch<T> of(T[] stores) {

        return new ConsumerOperation.Batch<>(
                Arrays.stream(stores)
                        .map(ConsumerCache::new)
                        .toArray(ConsumerCache[]::new)
        );
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

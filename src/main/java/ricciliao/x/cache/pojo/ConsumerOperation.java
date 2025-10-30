package ricciliao.x.cache.pojo;

import ricciliao.x.cache.ConsumerStore;

import java.io.Serial;
import java.util.List;
import java.util.function.IntFunction;

public interface ConsumerOperation {

    static <T extends ConsumerStore> Single<T> of(ConsumerCache<T> single) {

        return new ConsumerOperation.Single<>(single);
    }

    static <T extends ConsumerStore> Single<T> ofStore(T store) {

        return new ConsumerOperation.Single<>(new ConsumerCache<>(store));
    }

    static <T extends ConsumerStore> Batch<T> of(List<ConsumerCache<T>> caches) {

        return new ConsumerOperation.Batch<>(caches.toArray((IntFunction<ConsumerCache<T>[]>) ConsumerCache[]::new));
    }

    static <T extends ConsumerStore> Batch<T> ofStore(List<T> stores) {

        return new ConsumerOperation.Batch<>(
                stores.stream()
                        .map(ConsumerCache::new)
                        .toArray((IntFunction<ConsumerCache<T>[]>) ConsumerCache[]::new)
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

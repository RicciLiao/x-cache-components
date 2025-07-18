package ricciliao.x.cache.query;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CacheQuery {

    public enum Property {
        CREATED_DTM,
        UPDATED_DTM,
        CACHE_KEY;

        Property() {
        }

    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Support {
        Property value();
    }

    public static class Sort {

        public enum Direction {
            ASC,
            DESC
        }

    }

}

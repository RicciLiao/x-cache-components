package ricciliao.x.cache.pojo;

import java.io.Serial;
import java.io.Serializable;

public class CacheExtraOperationDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -8084916424068282111L;

    private Long limit;

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

}

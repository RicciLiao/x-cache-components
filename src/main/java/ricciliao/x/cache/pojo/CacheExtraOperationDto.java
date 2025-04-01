package ricciliao.x.cache.pojo;

import org.springframework.util.MultiValueMap;
import ricciliao.x.component.rest.RestQueryParam;

import java.io.Serial;

public class CacheExtraOperationDto implements RestQueryParam {
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

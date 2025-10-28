package ricciliao.x.cache.query;

import java.io.Serial;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public class CacheBatchQuery implements Serializable {
    @Serial
    private static final long serialVersionUID = 5688991327120122635L;

    private Long limit = 0L;
    private CacheQuery.Property sortBy = CacheQuery.Property.CREATED_DTM;
    private CacheQuery.Sort.Direction sortDirection = CacheQuery.Sort.Direction.ASC;
    private Map<CacheQuery.Property, Serializable> criteriaMap = new EnumMap<>(CacheQuery.Property.class);

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public CacheQuery.Property getSortBy() {
        return sortBy;
    }

    public void setSortBy(CacheQuery.Property sortBy) {
        this.sortBy = sortBy;
    }

    public CacheQuery.Sort.Direction getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(CacheQuery.Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public Map<CacheQuery.Property, Serializable> getCriteriaMap() {
        return criteriaMap;
    }

    public void setCriteriaMap(Map<CacheQuery.Property, Serializable> criteriaMap) {
        this.criteriaMap = criteriaMap;
    }

}

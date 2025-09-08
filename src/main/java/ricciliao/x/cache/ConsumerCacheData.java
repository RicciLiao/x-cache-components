package ricciliao.x.cache;


import ricciliao.x.component.response.data.ResponseData;

public interface ConsumerCacheData extends ResponseData {

    String generateCacheKey();

}

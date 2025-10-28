package ricciliao.x.cache;


import ricciliao.x.component.response.data.ResponseData;

public interface ConsumerStore extends ResponseData {

    String generateCacheKey();

}

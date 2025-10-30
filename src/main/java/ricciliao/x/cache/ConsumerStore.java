package ricciliao.x.cache;


import ricciliao.x.component.payload.PayloadData;

public interface ConsumerStore extends PayloadData {

    String generateCacheKey();

}

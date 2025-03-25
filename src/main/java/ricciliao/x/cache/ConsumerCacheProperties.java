package ricciliao.x.cache;


import org.springframework.http.HttpMethod;
import ricciliao.x.cache.pojo.CacheDto;
import ricciliao.x.component.props.ApplicationProperties;
import ricciliao.x.component.rest.RestPathProperties;

import java.util.ArrayList;
import java.util.List;

public class ConsumerCacheProperties extends ApplicationProperties {

    private String consumer;
    private List<OperationProperties> operationList = new ArrayList<>();

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public List<OperationProperties> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<OperationProperties> operationList) {
        this.operationList = operationList;
    }

    public static class OperationProperties {

        private String store;
        private Class<? extends CacheDto> storeClassName;
        private CacheRestPathProperties create = new CacheRestPathProperties("http://ricci-cache-provider:8083/operation", HttpMethod.POST);
        private CacheRestPathProperties update = new CacheRestPathProperties("http://ricci-cache-provider:8083/operation", HttpMethod.PUT);
        private CacheRestPathProperties delete = new CacheRestPathProperties("http://ricci-cache-provider:8083/operation/{id}", HttpMethod.DELETE);
        private CacheRestPathProperties retrieve = new CacheRestPathProperties("http://ricci-cache-provider:8083/operation/{id}", HttpMethod.GET);
        private CacheRestPathProperties batchCreate = new CacheRestPathProperties("http://ricci-cache-provider:8083/operation/batch", HttpMethod.POST);
        private CacheRestPathProperties providerInfo = new CacheRestPathProperties("http://ricci-cache-provider:8083/operation/extra/providerInfo", HttpMethod.GET);

        public CacheRestPathProperties getProviderInfo() {
            return providerInfo;
        }

        public void setProviderInfo(CacheRestPathProperties providerInfo) {
            this.providerInfo = providerInfo;
        }

        public CacheRestPathProperties getBatchCreate() {
            return batchCreate;
        }

        public void setBatchCreate(CacheRestPathProperties batchCreate) {
            this.batchCreate = batchCreate;
        }

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public Class<? extends CacheDto> getStoreClassName() {
            return storeClassName;
        }

        public void setStoreClassName(Class<? extends CacheDto> storeClassName) {
            this.storeClassName = storeClassName;
        }

        public CacheRestPathProperties getCreate() {
            return create;
        }

        public void setCreate(CacheRestPathProperties create) {
            this.create = create;
        }

        public CacheRestPathProperties getUpdate() {
            return update;
        }

        public void setUpdate(CacheRestPathProperties update) {
            this.update = update;
        }

        public CacheRestPathProperties getDelete() {
            return delete;
        }

        public void setDelete(CacheRestPathProperties delete) {
            this.delete = delete;
        }

        public CacheRestPathProperties getRetrieve() {
            return retrieve;
        }

        public void setRetrieve(CacheRestPathProperties retrieve) {
            this.retrieve = retrieve;
        }

        public static class CacheRestPathProperties extends RestPathProperties {

            public CacheRestPathProperties() {
                //default constructor
            }

            public CacheRestPathProperties(String path, HttpMethod method) {
                super();
                this.setPath(path);
                this.setMethod(new HttpMethodWrapper(method.name()));
            }
        }
    }

}

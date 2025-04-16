package ricciliao.x.cache;

import ricciliao.x.cache.pojo.CacheDto;

import java.time.Duration;

public class ProviderCacheProperties {

    private ProviderCacheProperties() {

    }

    public abstract static class StoreProperties {
        private String store = "";
        private String host;
        private Integer port;
        private String password;
        private String database;
        private Class<CacheDto> storeClassName;

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public Class<CacheDto> getStoreClassName() {
            return storeClassName;
        }

        public void setStoreClassName(Class<CacheDto> storeClassName) {
            this.storeClassName = storeClassName;
        }

        public abstract AdditionalProperties getAddition();

    }

    public abstract static class AdditionalProperties {
        private Duration timeout = Duration.ofSeconds(30);
        private Duration ttl = Duration.ofSeconds(60);
        private Boolean statical = false;

        public Duration getTimeout() {
            return timeout;
        }

        public void setTimeout(Duration timeout) {
            this.timeout = timeout;
        }

        public Duration getTtl() {
            return ttl;
        }

        public void setTtl(Duration ttl) {
            this.ttl = ttl;
        }

        public Boolean getStatical() {
            return statical;
        }

        public void setStatical(Boolean statical) {
            this.statical = statical;
        }
    }
}

# X-Cache-Components

## *Cache-Components `🚀️ V1.0.0`*

### 📚 Dependency

Please refer to `dependencies-control-center` for the version number.

| groupId                    | artifactId        | scope    | 
|----------------------------|-------------------|----------|
| org.springframework        | spring-web        | provider | 
| com.fasterxml.jackson.core | jackson-databind  | provider | 
| ricciliao.x                | common-components | compile  | 

### Artifacts Output (org.apache.maven.plugins:maven-assembly-plugin)

* cache-consumer-`${version}`-bsm.jar
    * **assembly**: src/assembly/consumer/bsm.xml
    * **install**
        * **POM**: src/assembly/consumer/bsm-pom.xml
        * **Group Id**: ricciliao.x
        * **Artifact Id**: cache-consumer-bsm
    * **usage**
        * ricci-bsm-svc
* cache-consumer-`${version}`-message.jar
    * **assembly**: src/assembly/consumer/message.xml
    * **install**
        * **POM**: src/assembly/consumer/message-pom.xml
        * **Group Id**: ricciliao.x
        * **Artifact Id**: cache-consumer-message
    * **usage**
        * ricci-message-svc
* cache-consumer-`${version}`-common.jar
    * **assembly**: src/assembly/consumer/common.xml
    * **install**
        * **POM**: src/assembly/consumer/common-pom.xml
        * **Group Id**: ricciliao.x
        * **Artifact Id**: cache-consumer-common
    * **usage**
        * cache-consumer-`${version}`-bsm.jar
        * cache-consumer-`${version}`-message.jar
* cache-provider-`${version}`.jar
    * **assembly**: src/assembly/provider.xml
    * **install**
        * **POM**: src/assembly/provider-pom.xml
        * **Group Id**: ricciliao.x
        * **Artifact Id**: cache.provider
    * **usage**
        * ricci-cache-provider

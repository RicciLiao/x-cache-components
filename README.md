# X-Cache-Components

## *Cache-Components `🚀️ V1.0.0`*

### 📚 Dependency

Please refer to `dependencies-control-center` for the version number.

| groupId                    | artifactId        | scope    | 
|----------------------------|-------------------|----------|
| com.fasterxml.jackson.core | jackson-databind  | provider | 
| ricciliao.x                | common-components | compile  | 

### Artifacts Output (org.apache.maven.plugins:maven-assembly-plugin)

* cache-common-component-`${version}`.jar
    * **assembly**: src/assembly/common.xml
    * **install**
        * **POM**: src/assembly/common-pom.xml
        * **Group Id**: ricciliao.x
        * **Artifact Id**: cache-common-component
* cache-consumer-component-`${version}`.jar
    * **assembly**: src/assembly/consumer.xml
    * **install**
        * **POM**: src/assembly/consumer-pom.xml
        * **Group Id**: ricciliao.x
        * **Artifact Id**: cache-consumer-component

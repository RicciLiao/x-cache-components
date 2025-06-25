package ricciliao.x.cache;

import jakarta.annotation.Nonnull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ricciliao.x.cache.pojo.CacheBatchQuery;
import ricciliao.x.cache.pojo.CacheDto;
import ricciliao.x.cache.pojo.ConsumerIdentifier;
import ricciliao.x.cache.pojo.ConsumerOp;
import ricciliao.x.cache.pojo.ProviderInfo;
import ricciliao.x.component.response.ResponseData;
import ricciliao.x.component.response.ResponseSimpleData;
import ricciliao.x.component.response.ResponseVo;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

public class ConsumerCacheRestService<T extends CacheDto> {

    protected final RestTemplate restTemplate;
    protected final ConsumerCacheProperties.OperationProperties props;
    protected final ConsumerIdentifier identifier;
    protected final Class<T> storeClassName;
    public ConsumerCacheRestService(ConsumerCacheProperties.OperationProperties props,
                                    ConsumerIdentifier identifier,
                                    RestTemplate restTemplate,
                                    Class<T> storeClassName) {
        this.props = props;
        this.identifier = identifier;
        this.restTemplate = restTemplate;
        this.storeClassName = storeClassName;
    }

    public ResponseSimpleData.Str create(ConsumerOp.Single<T> operation) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getCreate().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Str>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getCreate().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(operation),
                        new ResponseDataTypeReference<>(ResponseSimpleData.Str.class)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Str> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ResponseSimpleData.Bool update(ConsumerOp.Single<T> operation) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getUpdate().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Bool>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getUpdate().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(operation),
                        new ResponseDataTypeReference<>(ResponseSimpleData.Bool.class)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Bool> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ResponseSimpleData.Bool delete(String id) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getDelete().toBuilder();
        uriComponentsBuilder.uriVariables(Map.of("id", id));
        ResponseEntity<ResponseVo<ResponseSimpleData.Bool>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getDelete().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .build(),
                        new ResponseDataTypeReference<>(ResponseSimpleData.Bool.class)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Bool> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ConsumerOp.Single<T> get(String id) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getGet().toBuilder();
        uriComponentsBuilder.uriVariables(Map.of("id", id));
        ResponseEntity<ResponseVo<ConsumerOp.Single<T>>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getGet().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .build(),
                        new ResponseDataTypeReference<>(ConsumerOp.Single.class, storeClassName)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ConsumerOp.Single<T>> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ResponseSimpleData.Bool batchCreate(ConsumerOp.Batch<T> operation) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getBatchCreate().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Bool>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getBatchCreate().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(operation),
                        new ResponseDataTypeReference<>(ResponseSimpleData.Bool.class)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Bool> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ResponseSimpleData.Bool batchDelete(CacheBatchQuery query) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getBatchDelete().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Bool>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getBatchDelete().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(query),
                        new ResponseDataTypeReference<>(ResponseSimpleData.Bool.class)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Bool> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ConsumerOp.Batch<T> list(CacheBatchQuery query) {
        UriComponentsBuilder uriComponentsBuilder = props.getList().toBuilder();
        ResponseEntity<ResponseVo<ConsumerOp.Batch<T>>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getList().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(query),
                        new ResponseDataTypeReference<>(ConsumerOp.Batch.class, storeClassName)

                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ConsumerOp.Batch<T>> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ProviderInfo providerInfo() throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getProviderInfo().toBuilder();
        ResponseEntity<ResponseVo<ProviderInfo>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getProviderInfo().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .build(),
                        new ResponseDataTypeReference<>(ProviderInfo.class)
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ProviderInfo> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public static class ResponseDataTypeReference<T extends ResponseData> extends ParameterizedTypeReference<ResponseVo<T>> {

        private final Class<? extends ConsumerOp> opClass;
        private final Class<? extends CacheDto> cacheClass;
        private final Class<? extends ResponseData> responseClass;

        public ResponseDataTypeReference(Class<? extends ConsumerOp> opClass,
                                         Class<? extends CacheDto> cacheClass) {
            super();
            this.opClass = opClass;
            this.cacheClass = cacheClass;
            this.responseClass = null;
        }

        public ResponseDataTypeReference(Class<? extends ResponseData> responseClass) {
            super();
            this.opClass = null;
            this.cacheClass = null;
            this.responseClass = responseClass;
        }

        @Nonnull
        @Override
        public Type getType() {

            if (Objects.nonNull(opClass) && Objects.nonNull(cacheClass)) {

                return ResolvableType.forClassWithGenerics(
                                ResponseVo.class,
                                ResolvableType.forClassWithGenerics(opClass, cacheClass)
                        )
                        .getType();
            }

            return ResolvableType.forClassWithGenerics(
                            ResponseVo.class,
                            responseClass
                    )
                    .getType();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ConsumerCacheRestService.ResponseDataTypeReference<?> that)) return false;
            if (!super.equals(o)) return false;
            return Objects.equals(opClass, that.opClass) && Objects.equals(cacheClass, that.cacheClass);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), opClass, cacheClass);
        }
    }

}

package ricciliao.x.cache;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ricciliao.x.cache.pojo.CacheDto;
import ricciliao.x.cache.pojo.ConsumerIdentifierDto;
import ricciliao.x.cache.pojo.ConsumerOpDto;
import ricciliao.x.cache.pojo.ProviderInfoDto;
import ricciliao.x.component.response.ResponseSimpleData;
import ricciliao.x.component.response.ResponseVo;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

public class ConsumerCacheRestService<T extends CacheDto> {

    public ConsumerCacheRestService(ConsumerCacheProperties.OperationProperties props,
                                    ConsumerIdentifierDto identifier,
                                    RestTemplate restTemplate,
                                    Class<T> storeClassName) {
        this.props = props;
        this.identifier = identifier;
        this.restTemplate = restTemplate;
        this.typeReference = new ParameterizedTypeReference<>() {
            @NonNull
            @Override
            public Type getType() {

                return ResolvableType.forClassWithGenerics(
                                ResponseVo.class,
                                ResolvableType.forClassWithGenerics(ConsumerOpDto.Single.class, storeClassName)
                        )
                        .getType();
            }
        };
    }

    protected final RestTemplate restTemplate;
    protected final ConsumerCacheProperties.OperationProperties props;
    protected final ConsumerIdentifierDto identifier;
    protected final ParameterizedTypeReference<ResponseVo<ConsumerOpDto.Single<T>>> typeReference;

    public ResponseSimpleData.Str create(ConsumerOpDto.Single<T> operation) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getCreate().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Str>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getCreate().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(operation),
                        new ParameterizedTypeReference<>() {
                        }
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Str> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ResponseSimpleData.Bool update(ConsumerOpDto.Single<T> operation) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getUpdate().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Bool>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getUpdate().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(operation),
                        new ParameterizedTypeReference<>() {
                        }
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
                        new ParameterizedTypeReference<>() {
                        }
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Bool> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ConsumerOpDto.Single<T> get(String id) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getRetrieve().toBuilder();
        uriComponentsBuilder.uriVariables(Map.of("id", id));

        ResponseEntity<ResponseVo<ConsumerOpDto.Single<T>>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getRetrieve().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .build(),
                        typeReference
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ConsumerOpDto.Single<T>> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ResponseSimpleData.Bool batchCreate(ConsumerOpDto.Batch<T> operation) throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getBatchCreate().toBuilder();
        ResponseEntity<ResponseVo<ResponseSimpleData.Bool>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getCreate().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .body(operation),
                        new ParameterizedTypeReference<>() {
                        }
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ResponseSimpleData.Bool> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

    public ProviderInfoDto providerInfo() throws RestClientException {
        UriComponentsBuilder uriComponentsBuilder = props.getProviderInfo().toBuilder();
        ResponseEntity<ResponseVo<ProviderInfoDto>> response =
                restTemplate.exchange(
                        RequestEntity
                                .method(props.getProviderInfo().toHttpMethod(), uriComponentsBuilder.build().encode().toUri())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_STORE, identifier.getStore())
                                .header(XCacheConstants.HTTP_HEADER_FOR_CACHE_CUSTOMER, identifier.getConsumer())
                                .build(),
                        new ParameterizedTypeReference<>() {
                        }
                );
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            ResponseVo<ProviderInfoDto> body = response.getBody();
            if (Objects.nonNull(body)) {

                return body.getData();
            }
        }

        return null;
    }

}

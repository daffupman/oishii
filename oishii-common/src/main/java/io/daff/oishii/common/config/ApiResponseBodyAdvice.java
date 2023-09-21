package io.daff.oishii.common.config;

import io.daff.oishii.common.context.ApiBodyContext;
import io.daff.web.entity.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author daff
 * @since 2021/11/18
 */
@SuppressWarnings("rawtypes")
// @ControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<R> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public R beforeBodyWrite(R body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // ApiBodyContext.set(body);
        return body;
    }
}

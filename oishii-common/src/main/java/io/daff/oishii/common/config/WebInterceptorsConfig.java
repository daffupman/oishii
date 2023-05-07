package io.daff.oishii.common.config;

import io.daff.oishii.common.handler.ApiVersionHandlerMapping;
import io.daff.oishii.common.handler.SignatureInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;

/**
 * @author daff
 * @since 2023/5/7
 */
public class WebInterceptorsConfig implements WebMvcConfigurer, WebMvcRegistrations {

    @Resource
    private SignatureInterceptor signatureInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.signatureInterceptor).order(2).addPathPatterns("/**")
                .excludePathPatterns("/provider/**", "/error/**");
    }

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new ApiVersionHandlerMapping();
    }
}

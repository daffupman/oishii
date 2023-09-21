package io.daff.oishii.console.config;

import io.daff.oishii.console.interceptor.PassportInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * SpringMvc相关配置
 *
 * @author daffupman
 * @since 2020/7/14
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer, WebMvcRegistrations {

    @Resource
    private PassportInterceptor passportInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.passportInterceptor).order(2)
                .addPathPatterns("/**").excludePathPatterns("/passport/sign-in", "/provider/**");
    }
}

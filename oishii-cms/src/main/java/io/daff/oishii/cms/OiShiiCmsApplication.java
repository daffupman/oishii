package io.daff.oishii.cms;

import io.daff.oishii.common.config.ApiResponseBodyAdvice;
import io.daff.oishii.common.config.HibernateValidatorConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author daff
 * @since 2023/4/30
 */
@SpringBootApplication
@MapperScan(basePackages = {"io.daff.oishii.cms.mapper"})
@Import({HibernateValidatorConfig.class})
public class OiShiiCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OiShiiCmsApplication.class, args);
    }
}

package io.daff.oishii.product;

import io.daff.cache.BizDataLoader;
import io.daff.cache.PreCacheDataExecutor;
import io.daff.logging.DaffLogger;
import io.daff.logging.module.InnerModule;
import io.daff.oishii.common.config.HibernateValidatorConfig;
import io.daff.oishii.common.config.WebInterceptorsConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author daff
 * @since 2023/4/30
 */
@SpringBootApplication(scanBasePackages = {"io.daff.oishii.product", "io.daff.oishii.common"})
@MapperScan(basePackages = {"io.daff.oishii.member.mapper"})
@EnableFeignClients(basePackages = {"io.daff.oishii.product", "io.daff.oishii.common"})
@Import({HibernateValidatorConfig.class, WebInterceptorsConfig.class})
public class OiShiiProductApplication implements CommandLineRunner {

    private static final DaffLogger logger = DaffLogger.getLogger(OiShiiProductApplication.class);

    @Resource
    private List<BizDataLoader<?,?>> bizDataLoaders;

    public static void main(String[] args) {
        SpringApplication.run(OiShiiProductApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 数据加载
        if (!CollectionUtils.isEmpty(bizDataLoaders)) {
            new PreCacheDataExecutor(bizDataLoaders).exec();
            logger.info("uacs cache data load success!", InnerModule.CACHE);
        }
    }
}


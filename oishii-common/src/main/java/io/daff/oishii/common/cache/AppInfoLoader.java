package io.daff.oishii.common.cache;

import io.daff.cache.BizDataLoader;
import io.daff.logging.DaffLogger;
import io.daff.logging.module.InnerModule;
import io.daff.logging.module.Module;
import io.daff.oishii.common.enums.BaseModule;
import io.daff.oishii.common.thirdpart.cms.client.CmsClient;
import io.daff.oishii.common.thirdpart.cms.resp.AppInfoVO;
import io.daff.web.entity.Response;
import io.daff.web.enums.Hint;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author daff
 * @since 2023/5/3
 */
@Component
public class AppInfoLoader implements BizDataLoader {

    private static final DaffLogger logger = DaffLogger.getLogger(AppInfoLoader.class);
    private Map<String, AppInfoVO> appInfoMap = new ConcurrentHashMap<>();
    private boolean appInfoLoaded = false;

    /**
     * 注意这里注入feign client不能使用构造器注入，否则会发生循环依赖。
     */
    @Resource
    private CmsClient cmsClient;

    @Override
    public void load() {
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor(Executors.defaultThreadFactory());
        ses.scheduleAtFixedRate(() -> {
            Response<List<AppInfoVO>> listResponse = cmsClient.listAppInfoList();
            if (Objects.equals(Hint.SUCCESS.code(), listResponse.getCode())) {
                appInfoMap = listResponse.getData().stream().collect(Collectors.toConcurrentMap(AppInfoVO::getCode, appInfoVO -> appInfoVO));
                logger.info("local data => client load success!", InnerModule.CACHE);
                appInfoLoaded = true;
            } else {
                logger.error("listAppInfoList 失败, code: {}, msg: {}", BaseModule.MEMBER, listResponse.getCode(), listResponse.getMsg());
            }
        }, 0L, 10, TimeUnit.MINUTES);
    }

    @Override
    public boolean finish() {
        return appInfoLoaded;
    }

    public AppInfoVO getByCode(String code) {
        return CollectionUtils.isEmpty(appInfoMap) ? null : appInfoMap.get(code);
    }
}

package io.daff.oishii.common.cache;

import io.daff.cache.AbstractBizDataLoader;
import io.daff.logging.module.InnerModule;
import io.daff.oishii.common.enums.BaseModule;
import io.daff.oishii.common.thirdpart.cms.client.CmsClient;
import io.daff.oishii.common.thirdpart.cms.resp.AppInfoVO;
import io.daff.web.entity.Response;
import io.daff.web.enums.Hint;
import io.daff.web.exception.BaseException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author daff
 * @since 2023/5/3
 */
@Component
public class AppInfoLoader extends AbstractBizDataLoader<String, AppInfoVO> {

    /**
     * 注意这里注入feign client不能使用构造器注入，否则会发生循环依赖。
     */
    @Resource
    private CmsClient cmsClient;

    /**
     * 可在构造器中定制重新构建缓存的时间
     */
    public AppInfoLoader() {
        super(11L, TimeUnit.MINUTES);
    }

    /**
     * 加载业务数据的逻辑
     */
    @Override
    protected Map<String, AppInfoVO> doLoad() {
        Map<String, AppInfoVO> newMap = new HashMap<>();
        try {
            Response<List<AppInfoVO>> listResponse = cmsClient.listAppInfoList();
            if (!Objects.equals(Hint.SUCCESS.code(), listResponse.getCode())) {
                throw new BaseException(Hint.SYSTEM_ERROR, listResponse.getMsg());
            }
            newMap = listResponse.getData().stream().collect(Collectors.toConcurrentMap(AppInfoVO::getCode, appInfoVO -> appInfoVO));
            logger.info("local data => client load success!", InnerModule.CACHE);
            loaded();
        } catch (Exception e) {
            logger.error("listAppInfoList error", BaseModule.MEMBER, e);
        }
        return newMap;
    }
}

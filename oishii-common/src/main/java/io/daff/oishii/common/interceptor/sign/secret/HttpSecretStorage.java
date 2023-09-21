package io.daff.oishii.common.interceptor.sign.secret;

import io.daff.oishii.common.cache.AppInfoLoader;
import io.daff.oishii.common.thirdpart.cms.resp.AppInfoVO;
import io.daff.utils.common.StringUtil;
import io.daff.web.exception.BizLogicException;
import io.daff.web.exception.ServerException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

/**
 * 从数据库中获取密钥
 *
 * @author daff
 * @since 2023/1/6
 */
@Component
public class HttpSecretStorage implements SecretStorage {

    private final AppInfoLoader appInfoLoader;

    public HttpSecretStorage(AppInfoLoader appInfoLoader) {
        this.appInfoLoader = appInfoLoader;
    }

    @Override
    public String getSecretByAppCode(String appCode) {
        if (!appInfoLoader.finish()) {
            throw new ServerException("数据还未加载完成，请稍后重试");
        }
        if (!StringUtil.hasText(appCode)) {
            return Strings.EMPTY;
        }
        AppInfoVO targetAppInfo = appInfoLoader.get(appCode);
        return targetAppInfo == null ? Strings.EMPTY : targetAppInfo.getSecret();
    }
}

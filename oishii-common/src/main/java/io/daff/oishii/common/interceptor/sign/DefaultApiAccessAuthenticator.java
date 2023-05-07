package io.daff.oishii.common.interceptor.sign;

import io.daff.oishii.common.interceptor.sign.secret.SecretStorage;
import io.daff.web.exception.ParamValidateException;
import org.springframework.stereotype.Component;

/**
 * @author daff
 * @since 2023/1/6
 */
@Component
public class DefaultApiAccessAuthenticator implements ApiAccessAuthenticator {

    private final SecretStorage secretStorage;

    public DefaultApiAccessAuthenticator(SecretStorage secretStorage) {
        this.secretStorage = secretStorage;
    }

    @Override
    public void auth(Signature signature) {

        // 是否开启调试模式
        if (signature.isDebug()) {
            return;
        }

        // 重放攻击验证
        if (signature.replay()) {
            throw new ParamValidateException("接口调用已过期");
        }

        // 取密钥
        String secret = secretStorage.getSecretByAppCode(signature.getAppCode());
        if (secret == null) {
            throw new ParamValidateException("无效的appcode");
        }

        // 验签
        if (!signature.verify(secret)) {
            throw new ParamValidateException("签名不合法");
        }
    }
}

package io.daff.oishii.common.interceptor.sign.secret;

/**
 * 密钥存储器
 *
 * @author daff
 * @since 2023/1/6
 */
public interface SecretStorage {

    /**
     * 通过appId查询密钥
     */
    String getSecretByAppCode(String appCode);
}

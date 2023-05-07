package io.daff.oishii.common.interceptor.sign;

import io.daff.utils.common.StringUtil;
import io.daff.utils.crypto.Md5Util;
import io.daff.web.exception.ParamValidateException;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * 需要验签的请求模型
 *
 * @author daff
 * @since 2021/11/15
 */
public class Signature {

    /**
     * 通用参数
     */
    private final String appCode;
    private final Long timestamp;
    private final String rawSignature;
    private final Boolean debug;

    /**
     * 业务参数
     */
    private final Map<String, Object> bizParams;

    public static final String HEADER_APP_CODE = "appcode";
    public static final String HEADER_TIMESTAMP = "timestamp";
    public static final String HEADER_SIGNATURE = "signature";
    public static final String HEADER_DEBUG = "debug";
    public static final Integer DEFAULT_CALL_INTERVAL = 1000 * 60 * 500;

    private Signature(Builder builder) {
        this.appCode = builder.appCode;
        this.timestamp = builder.timestamp;
        this.rawSignature = builder.rawSignature;
        this.debug = builder.debug != null && builder.debug;
        this.bizParams = builder.bizParams;
    }

    /**
     * 验签
     */
    public boolean verify(String secret) {

        if (secret == null) {
            throw new ParamValidateException("密钥不合法");
        }

        TreeMap<String, Object> allParams = new TreeMap<>();
        if (!CollectionUtils.isEmpty(bizParams)) {
            allParams.putAll(bizParams);
        }
        allParams.put(HEADER_APP_CODE, this.appCode);
        allParams.put(HEADER_TIMESTAMP, this.timestamp);
        String signature = geneSign(allParams, secret);
        return Objects.equals(this.rawSignature, signature);
    }

    /**
     * 验证重放攻击
     */
    public boolean replay() {
        return System.currentTimeMillis() - timestamp > DEFAULT_CALL_INTERVAL;
    }

    public String getAppCode() {
        return appCode;
    }

    public Boolean isDebug() {
        return debug;
    }

    /**
     * 生成签名字符串。签名规则：Md5({k1=v1#k2=v2}secret)
     *
     * @param params 接口入参
     * @param secret 密钥
     * @return 签名串
     */
    private String geneSign(Map<String, Object> params, String secret) {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("#");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "}");
        sb.append(secret);
        return Md5Util.encode(sb.toString());
    }

    /**
     * 建造者
     */
    public static class Builder {

        private String appCode;
        private Long timestamp;
        private String rawSignature;
        private Boolean debug;
        private Map<String, Object> bizParams;

        public Builder appCode(String appCode) {
            if (!StringUtil.hasText(appCode)) {
                throw new ParamValidateException("app code is null");
            }
            this.appCode = appCode;
            return this;
        }

        public Builder timestamp(String timestampStr) {
            if (timestampStr == null || !StringUtil.isLong(timestampStr)) {
                throw new ParamValidateException("timestamp is null");
            }
            this.timestamp = Long.valueOf(timestampStr);
            return this;
        }

        public Builder rawSignature(String rawSignature) {
            if (!StringUtil.hasText(rawSignature)) {
                throw new ParamValidateException("signature is null");
            }
            this.rawSignature = rawSignature;
            return this;
        }

        public Builder debug(String debug) {
            if (StringUtil.hasText(debug)) {
                this.debug = Boolean.TRUE.equals(Boolean.valueOf(debug));
            }
            return this;
        }

        public Builder bizParams(Map<String, Object> bizParams) {
            if (!CollectionUtils.isEmpty(bizParams)) {
                this.bizParams = sort(bizParams);
            }
            return this;
        }

        public Signature build() {
            if (!StringUtil.hasText(appCode)) {
                throw new ParamValidateException("app_id is null");
            }
            if (timestamp == null) {
                throw new ParamValidateException("timestamp is null");
            }
            if (!StringUtil.hasText(rawSignature)) {
                throw new ParamValidateException("signature is null");
            }
            return new Signature(this);
        }

        /**
         * 参数排序
         */
        private Map<String, Object> sort(Map<String, Object> params) {
            TreeMap<String, Object> map = new TreeMap<>(Comparator.naturalOrder());
            map.putAll(params);
            return map;
        }
    }
}

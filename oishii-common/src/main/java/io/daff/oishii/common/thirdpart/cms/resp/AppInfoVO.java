package io.daff.oishii.common.thirdpart.cms.resp;

import lombok.Data;

/**
 * @author daff
 * @since 2023/5/2
 */
@Data
public class AppInfoVO {

    /**
     * 客户端名称
     */
    private String name;
    /**
     * 客户端编码
     */
    private String code;

    /**
     * 客户端密钥
     */
    private String secret;
}

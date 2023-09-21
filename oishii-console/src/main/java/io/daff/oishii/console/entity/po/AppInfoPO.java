package io.daff.oishii.console.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * app_info
 * @author 
 */
@Data
public class AppInfoPO {
    /**
     * PK
     */
    private Integer id;

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

    /**
     * 客户端状态。0-删除，1-正常。
     */
    private String status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 修改时间
     */
    private Date updateAt;

    private Date changeAt;
}
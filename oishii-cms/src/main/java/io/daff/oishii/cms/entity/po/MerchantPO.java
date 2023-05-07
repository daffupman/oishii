package io.daff.oishii.cms.entity.po;

import java.util.Date;
import lombok.Data;

/**
 * merchant
 * @author daff
 */
@Data
public class MerchantPO {
    /**
     * pk
     */
    private Integer id;

    /**
     * 商户名称
     */
    private String name;

    /**
     * 商户编码
     */
    private String code;

    /**
     * 商户描述
     */
    private String description;

    /**
     * 商户状态。1-新建，2-待修改，3-审核通过，4-禁用，5-注销
     */
    private String status;

    /**
     * 审核内容
     */
    private String auditMessage;

    /**
     * 创建人code
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 修改人code
     */
    private String updateBy;

    /**
     * 修改人code
     */
    private Date updateAt;

    /**
     * 记录变更时间
     */
    private Date changeAt;
}
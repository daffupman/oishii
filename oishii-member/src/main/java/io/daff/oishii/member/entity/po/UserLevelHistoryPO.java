package io.daff.oishii.member.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user_level_history
 * @author daff
 */
@Data
public class UserLevelHistoryPO {
    /**
     * PK
     */
    private Long id;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 等级编码
     */
    private String levelCode;

    /**
     * 结余积分
     */
    private Integer pointLeft;

    /**
     * 状态。0-过期，1-生效。
     */
    private String status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private Date updateAt;

    /**
     * 数据变更时间
     */
    private Date changeAt;

}
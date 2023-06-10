package io.daff.oishii.member.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * point_trans
 * @author daff
 */
@Data
public class PointTransPO {
    /**
     * PK
     */
    private Integer id;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 获得的积分
     */
    private Integer point;

    /**
     * 创建时间
     */
    private Date createTime;

}
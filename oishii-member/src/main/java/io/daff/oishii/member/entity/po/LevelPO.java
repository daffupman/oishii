package io.daff.oishii.member.entity.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * benefit
 * @author daff
 */
@Data
public class LevelPO implements Serializable {
    /**
     * PK
     */
    private Integer id;

    /**
     * 权益编码
     */
    private String code;

    /**
     * 权益名称
     */
    private String name;

    /**
     * 权益描述
     */
    private String description;

    /**
     * 等级顺序
     */
    private Integer sort;

    /**
     * 客户端状态。0-删除，1-正常。
     */
    private String status;

    /**
     * 等级编码
     */
    private String levelCode;

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

    private static final long serialVersionUID = 1L;
}
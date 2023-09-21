package io.daff.oishii.console.entity.po;

import java.util.Date;
import lombok.Data;

/**
 * staff
 * @author 
 */
@Data
public class StaffPO {
    /**
     * pk
     */
    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 员工编码
     */
    private String code;

    /**
     * 所属商户
     */
    private String merchantCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 员工描述
     */
    private String description;

    /**
     * 员工状态。0-删除，1-正常
     */
    private String status;

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
     * 修改时间
     */
    private Date updateAt;

    /**
     * 数据修改时间
     */
    private Date changeAt;
}
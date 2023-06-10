package io.daff.oishii.member.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author daff
 * @since 2023/5/10
 */
@Data
public class UserLevelInfoVO {

    private String userCode;
    private String levelCode;
    private Integer points;
    private Date upgradeTime;
}

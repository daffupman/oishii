package io.daff.oishii.member.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author daff
 * @since 2023/5/8
 */
@Data
public class LevelBenefitsVO {

    private String merchantCode;
    private String code;
    private String name;
    private Integer points;
    private Integer sort;
    private List<BenefitsVO> benefits;
}

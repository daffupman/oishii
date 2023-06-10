package io.daff.oishii.member.entity.vo;

import lombok.Data;

/**
 * @author daff
 * @since 2023/5/8
 */
@Data
public class BenefitsVO {

    private String code;
    private String name;
    private String description;
    private Integer sort;
}

package io.daff.oishii.member.thirdpart.vo;

import lombok.Data;

/**
 * @author daff
 * @since 2023/5/10
 */
@Data
public class OrderVO {

    private String userCode;
    private String orderNo;
    private String orderStatus;
    private Integer payAmount;
}

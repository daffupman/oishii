package io.daff.oishii.member.service;

import io.daff.oishii.member.entity.vo.LevelBenefitsVO;
import io.daff.oishii.member.entity.vo.UserLevelInfoVO;

import java.util.List;

/**
 * @author daff
 * @since 2023/5/8
 */
public interface LevelService {

    List<LevelBenefitsVO> listMerchantLevelBenefits(String merchantCode);

    UserLevelInfoVO getUserLevelInfo(String userCode);
}

package io.daff.oishii.member.mapper;

import io.daff.oishii.member.entity.po.LevelPO;
import io.daff.oishii.member.entity.vo.LevelBenefitsVO;

import java.util.List;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LevelPO record);

    int insertSelective(LevelPO record);

    LevelPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LevelPO record);

    int updateByPrimaryKey(LevelPO record);

    List<LevelBenefitsVO> selectByMerchantCode(String merchantCode);
}
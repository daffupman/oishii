package io.daff.oishii.member.mapper;

import io.daff.oishii.member.entity.po.UserLevelHistoryPO;
import io.daff.oishii.member.entity.vo.UserLevelInfoVO;

public interface UserLevelHistoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserLevelHistoryPO record);

    int insertSelective(UserLevelHistoryPO record);

    UserLevelHistoryPO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserLevelHistoryPO record);

    int updateByPrimaryKey(UserLevelHistoryPO record);

    UserLevelInfoVO selectLevelByUserCode(String userCode);
}
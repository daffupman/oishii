package io.daff.oishii.cms.mapper;

import io.daff.oishii.cms.entity.po.StaffPO;

public interface StaffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StaffPO record);

    int insertSelective(StaffPO record);

    StaffPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StaffPO record);

    int updateByPrimaryKey(StaffPO record);

    StaffPO selectByName(String username);

    StaffPO selectByCode(String userCode);
}
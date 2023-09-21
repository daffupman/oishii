package io.daff.oishii.console.mapper;

import io.daff.oishii.console.entity.po.StaffPO;

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
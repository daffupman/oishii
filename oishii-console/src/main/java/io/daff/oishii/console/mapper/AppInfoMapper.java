package io.daff.oishii.console.mapper;

import io.daff.oishii.console.entity.po.AppInfoPO;

import java.util.List;

public interface AppInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AppInfoPO record);

    int insertSelective(AppInfoPO record);

    AppInfoPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AppInfoPO record);

    int updateByPrimaryKey(AppInfoPO record);

    List<AppInfoPO> selectAll();
}
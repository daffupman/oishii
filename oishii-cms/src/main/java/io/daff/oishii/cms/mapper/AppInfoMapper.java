package io.daff.oishii.cms.mapper;

import io.daff.oishii.cms.entity.po.AppInfoPO;

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
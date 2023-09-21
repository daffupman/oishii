package io.daff.oishii.console.mapper;

import io.daff.oishii.console.entity.po.MerchantPO;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantPO record);

    int insertSelective(MerchantPO record);

    MerchantPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantPO record);

    int updateByPrimaryKey(MerchantPO record);
}
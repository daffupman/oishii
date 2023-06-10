package io.daff.oishii.member.mapper;

import io.daff.oishii.member.entity.po.PointTransPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PointTransMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PointTransPO record);

    int insertSelective(PointTransPO record);

    PointTransPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PointTransPO record);

    int updateByPrimaryKey(PointTransPO record);

    List<PointTransPO> selectPoints(@Param("userCode") String userCode,
                                    @Param("upgradeTime") Date upgradeTime);
}
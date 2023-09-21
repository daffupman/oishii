package io.daff.oishii.console.entity.convert;

import io.daff.oishii.console.entity.po.StaffPO;
import io.daff.oishii.console.entity.vo.StaffVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author daff
 * @since 2023/4/30
 */
@Mapper(componentModel = "spring")
public interface StaffConverter {

    StaffConverter INSTANCE = Mappers.getMapper(StaffConverter.class);
    StaffVO convert(StaffPO staffPO);
}

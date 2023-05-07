package io.daff.oishii.cms.entity.convert;

import io.daff.oishii.cms.entity.po.StaffPO;
import io.daff.oishii.cms.entity.vo.StaffVO;
import org.mapstruct.Mapper;

/**
 * @author daff
 * @since 2023/4/30
 */
@Mapper(componentModel = "spring")
public interface StaffConverter {

    StaffVO from(StaffPO staffPO);
}

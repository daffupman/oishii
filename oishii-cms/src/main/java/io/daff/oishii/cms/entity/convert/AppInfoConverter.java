package io.daff.oishii.cms.entity.convert;

import io.daff.oishii.cms.entity.po.AppInfoPO;
import io.daff.oishii.cms.entity.po.StaffPO;
import io.daff.oishii.cms.entity.vo.AppInfoVO;
import io.daff.oishii.cms.entity.vo.StaffVO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author daff
 * @since 2023/4/30
 */
@Mapper(componentModel = "spring")
public interface AppInfoConverter {

    List<AppInfoVO> from(List<AppInfoPO> appInfoList);
}

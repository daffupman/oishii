package io.daff.oishii.console.entity.convert;

import io.daff.oishii.console.entity.po.AppInfoPO;
import io.daff.oishii.console.entity.vo.AppInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author daff
 * @since 2023/4/30
 */
@Mapper(componentModel = "spring")
public interface AppInfoConverter {

    AppInfoConverter INSTANCE = Mappers.getMapper(AppInfoConverter.class);

    List<AppInfoVO> convert(List<AppInfoPO> appInfoList);
}

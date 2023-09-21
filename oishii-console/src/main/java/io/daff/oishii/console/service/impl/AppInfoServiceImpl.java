package io.daff.oishii.console.service.impl;

import io.daff.oishii.console.entity.convert.AppInfoConverter;
import io.daff.oishii.console.entity.po.AppInfoPO;
import io.daff.oishii.console.entity.vo.AppInfoVO;
import io.daff.oishii.console.mapper.AppInfoMapper;
import io.daff.oishii.console.service.AppInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author daff
 * @since 2023/5/2
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppInfoVO> list() {
        List<AppInfoPO> appInfoPOList = appInfoMapper.selectAll();
        return AppInfoConverter.INSTANCE.convert(appInfoPOList);
    }
}

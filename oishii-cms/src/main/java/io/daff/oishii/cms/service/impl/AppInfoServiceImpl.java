package io.daff.oishii.cms.service.impl;

import io.daff.oishii.cms.entity.convert.AppInfoConverter;
import io.daff.oishii.cms.entity.po.AppInfoPO;
import io.daff.oishii.cms.entity.vo.AppInfoVO;
import io.daff.oishii.cms.mapper.AppInfoMapper;
import io.daff.oishii.cms.service.AppInfoService;
import io.daff.web.entity.Response;
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
    @Resource
    private AppInfoConverter appInfoConverter;

    @Override
    public List<AppInfoVO> list() {
        List<AppInfoPO> appInfoPOList = appInfoMapper.selectAll();
        return appInfoConverter.from(appInfoPOList);
    }
}

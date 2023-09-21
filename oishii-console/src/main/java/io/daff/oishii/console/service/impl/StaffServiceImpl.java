package io.daff.oishii.console.service.impl;

import io.daff.oishii.console.entity.convert.StaffConverter;
import io.daff.oishii.console.entity.po.StaffPO;
import io.daff.oishii.console.entity.vo.StaffVO;
import io.daff.oishii.console.mapper.StaffMapper;
import io.daff.oishii.console.service.StaffService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author daff
 * @since 2023/4/30
 */
@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffMapper staffMapper;

    @Override
    public StaffVO getStaff(String userCode) {
        StaffPO staffPO = staffMapper.selectByCode(userCode);
        return StaffConverter.INSTANCE.convert(staffPO);
    }
}

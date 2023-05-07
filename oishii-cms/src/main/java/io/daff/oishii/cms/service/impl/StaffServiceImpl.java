package io.daff.oishii.cms.service.impl;

import io.daff.oishii.cms.entity.convert.StaffConverter;
import io.daff.oishii.cms.entity.po.StaffPO;
import io.daff.oishii.cms.entity.vo.StaffVO;
import io.daff.oishii.cms.mapper.StaffMapper;
import io.daff.oishii.cms.service.StaffService;
import io.daff.web.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private StaffConverter staffConverter;

    @Override
    public Response<StaffVO> getStaff(String userCode) {
        StaffPO staffPO = staffMapper.selectByCode(userCode);
        return Response.ok(staffConverter.from(staffPO));
    }
}

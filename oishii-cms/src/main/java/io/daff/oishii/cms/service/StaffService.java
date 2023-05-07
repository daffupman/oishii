package io.daff.oishii.cms.service;

import io.daff.oishii.cms.entity.vo.StaffVO;
import io.daff.web.entity.Response;

/**
 * @author daff
 * @since 2023/4/30
 */
public interface StaffService {
    Response<StaffVO> getStaff(String userCode);
}

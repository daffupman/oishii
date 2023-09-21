package io.daff.oishii.console.service;

import io.daff.oishii.console.entity.vo.StaffVO;

/**
 * @author daff
 * @since 2023/4/30
 */
public interface StaffService {
    StaffVO getStaff(String userCode);
}

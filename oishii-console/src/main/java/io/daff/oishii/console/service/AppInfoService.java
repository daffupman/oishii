package io.daff.oishii.console.service;

import io.daff.oishii.console.entity.vo.AppInfoVO;

import java.util.List;

/**
 * @author daff
 * @since 2023/5/2
 */
public interface AppInfoService {
    List<AppInfoVO> list();
}

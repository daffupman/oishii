package io.daff.oishii.console.service;

import io.daff.oishii.console.entity.param.SignInParam;
import io.daff.oishii.console.entity.vo.SignInVO;

/**
 * @author daff
 * @since 2023/4/30
 */
public interface PassportService {
    SignInVO signIn(SignInParam signInParam);
}

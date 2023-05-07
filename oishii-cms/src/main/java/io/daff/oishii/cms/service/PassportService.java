package io.daff.oishii.cms.service;

import io.daff.oishii.cms.entity.param.SignInParam;
import io.daff.oishii.cms.entity.vo.SignInVO;
import io.daff.web.entity.Response;

/**
 * @author daff
 * @since 2023/4/30
 */
public interface PassportService {
    Response<SignInVO> signIn(SignInParam signInParam);
}

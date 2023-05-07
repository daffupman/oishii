package io.daff.oishii.cms.service.impl;

import io.daff.logging.DaffLogger;
import io.daff.oishii.cms.entity.param.SignInParam;
import io.daff.oishii.cms.entity.po.StaffPO;
import io.daff.oishii.cms.entity.vo.SignInVO;
import io.daff.oishii.cms.mapper.StaffMapper;
import io.daff.oishii.cms.service.PassportService;
import io.daff.oishii.cms.util.SimpleRedisUtil;
import io.daff.utils.common.StringUtil;
import io.daff.web.entity.Response;
import io.daff.web.exception.BusinessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author daff
 * @since 2023/4/30
 */
@Service
public class PassportServiceImpl implements PassportService {

    private static DaffLogger logger = DaffLogger.getLogger(PassportServiceImpl.class);

    private static final String LOGIN_TOKENS = "login_tokens";

    @Resource
    private StaffMapper staffMapper;
    @Resource
    private SimpleRedisUtil simpleRedisUtil;

    @Override
    public Response<SignInVO> signIn(SignInParam signInParam) {
        StaffPO staffPO = staffMapper.selectByName(signInParam.getUsername());
        if (staffPO == null || !Objects.equals(staffPO.getPassword(), signInParam.getPassword())) {
            throw new BusinessException("登录名和密码不一致");
        }
        String token = StringUtil.uuid();
        simpleRedisUtil.hset(LOGIN_TOKENS, staffPO.getCode(), token, 3600 * 24);
        SignInVO signInVo = new SignInVO();
        signInVo.setToken(token);
        return Response.ok(signInVo);
    }
}

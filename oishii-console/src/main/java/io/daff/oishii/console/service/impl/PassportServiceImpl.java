package io.daff.oishii.console.service.impl;

import io.daff.logging.DaffLogger;
import io.daff.oishii.console.entity.param.SignInParam;
import io.daff.oishii.console.entity.po.StaffPO;
import io.daff.oishii.console.entity.vo.SignInVO;
import io.daff.oishii.console.mapper.StaffMapper;
import io.daff.oishii.console.service.PassportService;
import io.daff.oishii.console.util.SimpleRedisUtil;
import io.daff.utils.common.StringUtil;
import io.daff.web.exception.BizLogicException;
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
    public SignInVO signIn(SignInParam signInParam) {
        StaffPO staffPO = staffMapper.selectByName(signInParam.getUsername());
        if (staffPO == null || !Objects.equals(staffPO.getPassword(), signInParam.getPassword())) {
            throw new BizLogicException("登录名和密码不一致");
        }
        String token = StringUtil.uuid();
        simpleRedisUtil.hset(LOGIN_TOKENS, staffPO.getCode(), token, 3600 * 24);
        SignInVO signInVo = new SignInVO();
        signInVo.setToken(token);
        return signInVo;
    }
}

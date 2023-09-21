package io.daff.oishii.console.interceptor;

import io.daff.logging.DaffLogger;
import io.daff.oishii.console.util.SimpleRedisUtil;
import io.daff.utils.common.StringUtil;
import io.daff.web.exception.BusinessException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author daff
 * @since 2023/4/30
 */
@Component
public class PassportInterceptor extends HandlerInterceptorAdapter {

    private static final DaffLogger logger = DaffLogger.getLogger(PassportInterceptor.class);
    private static final String LOGIN_TOKENS = "login_tokens";

    @Resource
    private SimpleRedisUtil simpleRedisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userCode = request.getHeader("userCode");
        String token = request.getHeader("token");
        if (StringUtil.isEmpty(userCode) || StringUtil.isEmpty(token)) {
            throw new BusinessException("用户未登录");
        }
        if (!simpleRedisUtil.hexist(LOGIN_TOKENS, userCode)) {
            throw new BusinessException("请重新登录");
        }

        return true;
    }
}

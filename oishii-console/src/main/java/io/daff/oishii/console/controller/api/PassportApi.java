package io.daff.oishii.console.controller.api;

import io.daff.oishii.console.entity.param.SignInParam;
import io.daff.oishii.console.entity.vo.SignInVO;
import io.daff.oishii.console.service.PassportService;
import io.daff.web.entity.R;
import io.daff.web.entity.Response;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录模块
 *
 * @author daff
 * @since 2023/4/30
 */
@RestController
@RequestMapping("/passport")
public class PassportApi {

    @Resource
    private PassportService passportService;

    @PostMapping("/sign-in")
    public R<SignInVO> signIn(@RequestBody  @Validated SignInParam signInParam) {
        return R.ok(passportService.signIn(signInParam));
    }

}

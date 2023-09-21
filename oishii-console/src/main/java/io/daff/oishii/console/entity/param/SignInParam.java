package io.daff.oishii.console.entity.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录相关参数
 *
 * @author daff
 * @since 2023/4/30
 */
@Data
public class SignInParam {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}

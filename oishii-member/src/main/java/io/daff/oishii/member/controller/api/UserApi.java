package io.daff.oishii.member.controller.api;

import io.daff.web.entity.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author daff
 * @since 2023/5/2
 */
@RestController
@RequestMapping("/user")
public class UserApi {

    @RequestMapping("/hello")
    public R<String> hello() {
        return R.ok("hi");
    }
}

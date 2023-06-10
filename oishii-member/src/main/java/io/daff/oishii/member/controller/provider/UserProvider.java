package io.daff.oishii.member.controller.provider;

import io.daff.web.entity.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author daff
 * @since 2023/5/2
 */
@RestController
@RequestMapping("/provider/user")
public class UserProvider {

    @RequestMapping("/hello")
    public Response<String> hello() {
        return Response.ok("hi");
    }
}

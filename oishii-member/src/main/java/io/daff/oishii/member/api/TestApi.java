package io.daff.oishii.member.api;

import io.daff.web.entity.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author daff
 * @since 2023/5/2
 */
@RestController
@RequestMapping("/test")
public class TestApi {

    @RequestMapping("/hello")
    public Response<String> hello() {
        return Response.ok("hi");
    }
}

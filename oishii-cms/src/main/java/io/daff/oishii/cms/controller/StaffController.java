package io.daff.oishii.cms.controller;

import io.daff.oishii.cms.entity.vo.StaffVO;
import io.daff.oishii.cms.service.StaffService;
import io.daff.web.entity.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

/**
 * 商户
 *
 * @author daff
 * @since 2023/4/30
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Resource
    private StaffService staffService;

    @GetMapping("/{userCode}")
    public Response<StaffVO> getStaff(@PathVariable @NotBlank(message = "用户编码不能为空") String userCode) {
        return staffService.getStaff(userCode);
    }
}

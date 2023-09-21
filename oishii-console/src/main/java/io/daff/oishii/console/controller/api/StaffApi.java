package io.daff.oishii.console.controller.api;

import io.daff.oishii.console.entity.vo.StaffVO;
import io.daff.oishii.console.service.StaffService;
import io.daff.web.entity.R;
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
public class StaffApi {

    @Resource
    private StaffService staffService;

    @GetMapping("/{userCode}")
    public R<StaffVO> getStaff(@PathVariable @NotBlank(message = "用户编码不能为空") String userCode) {
        return R.ok(staffService.getStaff(userCode));
    }
}

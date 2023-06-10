package io.daff.oishii.member.controller.api;

import io.daff.oishii.member.entity.vo.LevelBenefitsVO;
import io.daff.oishii.member.entity.vo.UserLevelInfoVO;
import io.daff.oishii.member.service.LevelService;
import io.daff.web.entity.Response;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author daff
 * @since 2023/5/7
 */
@RestController
@RequestMapping("/level")
public class LevelApi {

    @Resource
    private LevelService levelService;

    @RequestMapping("/merchant/{merchantCode}")
    public Response<List<LevelBenefitsVO>> listMerchantLevelBenefits(@NotBlank(message = "商户编码不能为空")
                                                                     @PathVariable("merchantCode") String merchantCode) {
        List<LevelBenefitsVO> merchantLevelBenefits = levelService.listMerchantLevelBenefits(merchantCode);
        return Response.ok(merchantLevelBenefits);
    }

    @RequestMapping("/user/{userCode}")
    public Response<UserLevelInfoVO> queryUserLevelInfo(@NotBlank(message = "用户编码不能为空")
                                                              @PathVariable("userCode") String userCode) {
        return Response.ok(levelService.getUserLevelInfo(userCode));
    }
}
package io.daff.oishii.cms.provider;

import io.daff.oishii.cms.entity.vo.AppInfoVO;
import io.daff.oishii.cms.service.AppInfoService;
import io.daff.web.entity.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户端接口
 *
 * @author daff
 * @since 2023/5/2
 */
@RestController
@RequestMapping("/provider/app")
public class AppInfoProvider {

    @Resource
    private AppInfoService appInfoService;

    @RequestMapping("/list")
    public Response<List<AppInfoVO>> listAppInfos() {
        return Response.ok(appInfoService.list());
    }
}

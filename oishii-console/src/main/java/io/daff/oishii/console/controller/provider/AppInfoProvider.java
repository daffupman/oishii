package io.daff.oishii.console.controller.provider;

import io.daff.oishii.console.entity.vo.AppInfoVO;
import io.daff.oishii.console.service.AppInfoService;
import io.daff.web.entity.R;
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
    public R<List<AppInfoVO>> listAppInfos() {
        return R.ok(appInfoService.list());
    }
}

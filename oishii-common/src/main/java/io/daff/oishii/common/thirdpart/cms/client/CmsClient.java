package io.daff.oishii.common.thirdpart.cms.client;

import io.daff.oishii.common.thirdpart.cms.CmsBuilder;
import io.daff.oishii.common.thirdpart.cms.resp.AppInfoVO;
import io.daff.web.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author daff
 * @since 2023/5/2
 */
@Component
@FeignClient(url = "http://localhost:30010/oishii.cms/provider", name = "cms", configuration = CmsBuilder.class)
public interface CmsClient {

    @GetMapping("/app/list")
    Response<List<AppInfoVO>> listAppInfoList();
}

package com.hengyunsoft.platform.developer.api.screen.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.dto.platform.PlatformUseInfoDTO;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.AssignModuleApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/screen", fallback = AssignModuleApiHystrix.class)
public interface PlatformUseInfoScreenApi {

    /**
     * 查询平台共性实施使用情况
     * @return
     */
    @RequestMapping(value = "/platformUse/getUseInfo", method = RequestMethod.GET)
    Result<List<List<PlatformUseInfoDTO>>> getUseInfo();
}

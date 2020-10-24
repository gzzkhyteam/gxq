package com.hengyunsoft.platform.developer.api.screen.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.dto.platform.PlatformCommonDevDTO;
import com.hengyunsoft.platform.developer.api.service.api.hystrix.AssignModuleApiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer", fallback = AssignModuleApiHystrix.class)
public interface PlatformCommonDevScreenApi {

    /**
     * 查询平台共性实施发展情况
     * @return
     */
    @RequestMapping(value = "/platform/getPlatformDev", method = RequestMethod.GET)
    Result<List<List<PlatformCommonDevDTO>>> getPlatformDev();
}

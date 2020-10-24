package com.hengyunsoft.platform.developer.api.screen.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.hystrix.ModuleCountScreenApiHystrix;
import com.hengyunsoft.platform.developer.api.screen.dto.module.ModuleCountDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.module.ModuleUserInfosDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer", fallback = ModuleCountScreenApiHystrix.class)
public interface ModuleCountScreenApi {

    /**
     * 按类型查询功能数量
     * @param top
     * @return
     */
    @RequestMapping(value = "/module/getModuleCount", method = RequestMethod.GET)
    Result<List<ModuleCountDTO>> getModuleCount(@RequestParam(value = "appId",required = false)String appId);

    /**
     * 查询功能应用关系-力引导布局数据
     * @return
     */
    @RequestMapping(value = "/module/getModuleRelation", method = RequestMethod.GET)
    Result<Map> getModuleRelation(@RequestParam(value="appId",required = false)String appId);

    /**
     * 2018-5-12 大屏造数据
     * @return
     */
    @RequestMapping(value = "/module/getServiceModuleCount", method = RequestMethod.GET)
    Result<Map> getServiceModuleCount();

    /**
     * 2018-5-13 大屏造数据
     * @return
     */
    @RequestMapping(value = "/module/getRadarCount", method = RequestMethod.GET)
    Result<Map> getRadarCount();

    /**
     * 2018-5-13 应用集成大屏造数据
     * 获取单位对模块的使用信息
     * @return
     */
    @RequestMapping(value = "/module/getdeptUseModulesInfo", method = RequestMethod.GET)
    Result<List<ModuleUserInfosDTO>> getdeptUseModulesInfo();
}


package com.hengyunsoft.platform.developer.api.screen.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.ModuleCountScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.module.ModuleCountDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.module.ModuleUserInfosDTO;

import java.util.List;
import java.util.Map;

/**
 * 功能数量统计熔断
 */
public class ModuleCountScreenApiHystrix implements ModuleCountScreenApi {

    @Override
    public Result<List<ModuleCountDTO>> getModuleCount(String appId) {
        return Result.timeout();
    }

    @Override
    public Result<Map> getModuleRelation(String appId) {
        return Result.timeout();
    }

    @Override
    public Result<Map> getServiceModuleCount() {
        return Result.timeout();
    }

    @Override
    public Result<Map> getRadarCount() {
        return Result.timeout();
    }

    @Override
    public Result<List<ModuleUserInfosDTO>> getdeptUseModulesInfo() {
        return Result.timeout();
    }
}

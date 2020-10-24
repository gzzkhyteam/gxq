package com.hengyunsoft.platform.admin.api.base.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.ModuleTypeMaintenanceApi;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 功能类型维护
 * @author madb
 * @createTime 2018/4/10
 */
@Component
public class ModuleTypeMaintenanceApiHystrix implements ModuleTypeMaintenanceApi {
    @Override
    public Result<PageInfo<ModuleDictionaryDTO>> pageModuleType(OpenApiReq<ModuleDictionaryViewDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<String> addModuleType(ModuleTypeAddDTO moduleTypeAddDTO) {
        return Result.timeout();
    }

    @Override
    public Result<String> deleteModuleType(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<String> updateModuleType(@RequestParam ModuleDictionaryModifyDTO moduleDictionaryModifyDTO) {
        return Result.timeout();
    }

    @Override
    public Result<ModuleDictionaryDTO> getDetailModuleTypeById(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<List<AppAndModuleDTO>> getListByTypeCode(String typeCode) {
        return Result.timeout();
    }
}

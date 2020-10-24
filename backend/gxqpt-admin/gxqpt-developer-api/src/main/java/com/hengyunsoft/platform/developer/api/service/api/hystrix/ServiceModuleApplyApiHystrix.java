package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.ServiceModuleApplyApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceModuleApplyApiHystrix implements ServiceModuleApplyApi {
    @Override
    public Result<ServiceModuleApplyRetDTO> save(ServiceModuleApplySaveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<String> update(ServiceModuleUpdateDTO dto) {
         return Result.timeout();
    }

    @Override
    public Result<Boolean> audit(ServiceModuleApplyAuditDTO dto) {
         return Result.timeout();
    }

    @Override
    public Result<Boolean> delete(Long id) {
         return Result.timeout();
    }

    @Override
    public Result<Boolean> forbidUse(ServiceModuleForbidUseDTO dto) {
         return Result.timeout();
    }

    @Override
    public Result<String> updateModuleMixHandle(ServiceModuleMixHandleDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<ServiceModuleDTO> getById(Long id) {
         return Result.timeout();
    }

    @Override
    public Result<List<ServiceModuleDTO>> getByAppId(String appId) {
        return Result.timeout();
    }

    @Override
    public Result<List<ServiceModuleDTO>> findList() {
         return Result.timeout();
    }

    @Override
    public Result<PageInfo<ServiceModuleDTO>> page(OpenApiReq<ServiceModulePageDTO> openApiReq) {
        return Result.timeout();
    }
}

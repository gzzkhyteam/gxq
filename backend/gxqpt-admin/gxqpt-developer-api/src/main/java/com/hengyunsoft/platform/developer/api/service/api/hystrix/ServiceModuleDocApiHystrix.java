package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.ServiceModuleDocApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocQueryDTO;
import com.hengyunsoft.platform.developer.api.service.dto.module.helpdoc.ServiceModuleDocRetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceModuleDocApiHystrix implements ServiceModuleDocApi {
    @Override
    public Result<ServiceModuleDocDTO> save(ServiceModuleDocDTO serviceModuleDocDTO) {
        return Result.timeout();
    }

    @Override
    public Result<ServiceModuleDocRetDTO> getById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<String> deleteById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<ServiceModuleDocDTO> updateById(ServiceModuleDocDTO serviceModuleDocDTO) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<ServiceModuleDocRetDTO>> page(OpenApiReq<ServiceModuleDocQueryDTO> req) {
        return Result.timeout();
    }

    @Override
    public Result<List<ServiceModuleDocRetDTO>> findMoudleDoc(ServiceModuleDocQueryDTO req) {
        return Result.timeout();
    }
}

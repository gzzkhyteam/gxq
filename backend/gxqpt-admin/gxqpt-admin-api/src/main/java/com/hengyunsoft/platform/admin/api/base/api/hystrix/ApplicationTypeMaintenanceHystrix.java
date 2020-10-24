package com.hengyunsoft.platform.admin.api.base.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.base.api.ApplicationTypeMaintenanceApi;
import com.hengyunsoft.platform.admin.api.base.dto.*;
import org.springframework.stereotype.Component;

/**
 * feign 熔断机制的实现， 默认返回超时响应
 * @author zhangbiao
 * @createTime 2018-04-10
 */
@Component
public class ApplicationTypeMaintenanceHystrix implements ApplicationTypeMaintenanceApi {

    @Override
    public Result<PageInfo<DictionaryMaintainPageDTO>> findList(OpenApiReq openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<DictionaryMaintainDetailsDTO> get(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<String> update(DictionaryMaintainUpdateDTO maintainUpdateDTO) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> delete(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<String> save(DictionaryMaintainSaveDTO maintainSaveDTO) {
        return Result.timeout();
    }
}

package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.AssignModuleApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述:模块熔断
 * @author chb
 * @date 2018/4/3 13:31 
 */
@Component
public class AssignModuleApiHystrix implements AssignModuleApi {

    @Override
    public Result<AssignModuleRetDTO> save(AssignModuleSaveDTO assignModuleSaveDTO) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> deleteById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<AssignModuleRetDTO> updateById(AssignModuleUpdateDTO assignModuleUpdateDTO) {
        return Result.timeout();
    }

    @Override
    public Result<QueryConsumAssignModuleInfoDTO> getById(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AssignServiceModuleRetDTO>> pageMy(OpenApiReq<AssignModuleQueryMyDTO> req) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AssignServiceModuleRetDTO>> page(OpenApiReq<AssignModuleQueryMYAppDTO> req) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AssignServiceModuleRetDTO>> findAllMoudles(OpenApiReq<AssignModuleQueryMoudlesDTO> req) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AssignServiceModuleRetDTO>> findNoLoginMoudles(OpenApiReq<AssignModuleQueryMoudlesDTO> req) {
        return Result.timeout();
    }

    /**
     * 无分页列表数据查询
     * @param req
     * @return
     */
    @Override
    public Result<List<AssignModuleNopageRetDTO>> findNoPage(String moduleType, Boolean status) {
        return Result.timeout();
    }

    @Override
    public Result<List<AssignServiceModuleRetDTO>> findAllMoudlesNoPage(AssignModuleQueryMoudlesDTO req) {
        return Result.timeout();
    }

    /**
     * 查询热门功能
     * @param top
     * @return
     */
    @Override
    public Result<List<ServiceModuleDTO>> hotModule(Integer top) {
        return Result.timeout();
    }
}

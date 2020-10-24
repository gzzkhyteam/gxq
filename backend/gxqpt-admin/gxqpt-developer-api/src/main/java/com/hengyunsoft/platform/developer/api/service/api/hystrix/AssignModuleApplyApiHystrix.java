package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.service.api.AssignModuleApplyApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.apply.*;
import org.springframework.stereotype.Component;

/**
 * 描述:模块申请熔断
 * @author chb
 * @date 2018/4/3 13:31 
 */
@Component
public class AssignModuleApplyApiHystrix implements AssignModuleApplyApi {

    @Override
    public Result<AssignModuleApplyUpdateDTO> save(AssignModuleApplySaveDTO assignModuleApplySaveDTO) {
        return Result.timeout();
    }

    @Override
    public Result<AssignModuleApplyRetDTO> getById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<String> deleteById(String id) {
        return Result.timeout();
    }

    @Override
    public Result<AssignModuleApplyUpdateDTO> updateById(AssignModuleApplyUpdateDTO assignModuleApplyUpdateDTO) {
        return Result.timeout();
    }

   /* @Override
    public Result<PageInfo<AssignModuleApplyRetDTO>> pageMyApply(OpenApiReq<AssignModuleApplyQueryDTO> req) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AssignModuleApplyRetDTO>> pageMyAudit(OpenApiReq<AssignModuleApplyQueryDTO> req) {
        return Result.timeout();
    }

    @Override
    public Result<String> updateSubmitStatus(Long id, Long moduleId, String appId) {
        return Result.timeout();
    }

    @Override
    public Result<String> updateApproveStatus(AssignModuleApplyApprDTO applyApprDTO) {
        return Result.timeout();
    }*/

    @Override
    public Result<AssignModuleApplyRetDTO> getApprHistory(Long apprId) {
        return Result.timeout();
    }
}

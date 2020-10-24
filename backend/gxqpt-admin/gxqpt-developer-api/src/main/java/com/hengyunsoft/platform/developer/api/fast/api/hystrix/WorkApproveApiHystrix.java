package com.hengyunsoft.platform.developer.api.fast.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.WorkApproveApi;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import org.springframework.stereotype.Component;

@Component
public class WorkApproveApiHystrix implements WorkApproveApi {

    @Override
    public Result<PageInfo<ResponseWorkApproveDTO>> statisticFind(OpenApiReq<RequestWorkApproveDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> workApproveBusinessSave(RequestWorkApproveBusinessDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<Integer> workApproveBusinessUpdate(RequestWorkApproveBusinessDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<WorkApproveBusinessDTO> workApproveBusinessById(Long approveId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> workApproveExtraSave(RequestWorkApproveExtraDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<Integer> workApproveExtraUpdate(RequestWorkApproveExtraDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<WorkApproveExtraDTO> workApproveExtraById(Long approveId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> workApproveLeaveSave(RequestWorkApproveLeaveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<Integer> workApproveLeaveUpdate(RequestWorkApproveLeaveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<WorkApproveLeaveDTO> workApproveLeaveById(Long approveId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> workApproveSupplySave(RequestWorkApproveSupplyDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<Integer> workApproveSupplyUpdate(RequestWorkApproveSupplyDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<WorkApproveSupplyDTO> workApproveSupplyById(Long approveId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> workApproveRecordSave(RequestWorkApproveRecordDTO dto) {
        return Result.timeout();
    }
}

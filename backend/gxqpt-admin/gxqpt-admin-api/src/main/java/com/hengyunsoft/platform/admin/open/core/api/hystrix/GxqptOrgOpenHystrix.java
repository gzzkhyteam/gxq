package com.hengyunsoft.platform.admin.open.core.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.admin.api.core.dto.org.*;
import com.hengyunsoft.platform.admin.open.core.api.GxqptOrgOpenApi;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GxqptOrgOpenHystrix implements GxqptOrgOpenApi {
    @Override
    public Result<PageInfo<GxqptOrgResDTO>> pageByAppAndSys(OpenApiReq<String> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<List<GxqptOrgResDTO>> findByAdmAndSys(Long userId, String systemCode) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptOrgResDTO>> pageBySys(OpenApiReq<String> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<GxqptOrgPolyResDTO>> pagePoly(OpenApiReq openApiReq) { return Result.timeout(); }

    @Override
    public Result<PageInfo<GxqptOrgPolyResDTO>> pagePolyByApp(OpenApiReq openApiReq) { return Result.timeout(); }

    @Override
    public Result<List<GxqptOrgPolyResDTO>> pagePolyByUser(Long userId) {return Result.timeout();}

    @Override
    public Result<List<GxqptOrgPolyResDTO>> allOrg() {
        return Result.timeout();
    }

    @Override
    public Result<List<OrgAndEmpInfoDTO>> getOrgInfoByUserId(Long userId) {
        return Result.timeout();
    }

    @Override
    public Result<OrgDeptDutyInfoDTO> getOrgDeptDutyByUserId(Long userId) {
        return Result.timeout();
    }

    @Override
    public Result<List<OrgInfosDTO>> getOrgSimpleInfo(Long userId) {
            return Result.timeout();
    }

    @Override
    public Result<List<OrgDeptDutyInfoDTO>> getOrgDeptDutyinfo(Long userId, String orgId) {
        return Result.timeout();
    }
}

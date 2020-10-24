package com.hengyunsoft.platform.developer.api.apply.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.apply.ApplyManagerApi;
import com.hengyunsoft.platform.developer.api.apply.dto.*;
import org.springframework.stereotype.Component;

@Component
public class ApplyManagerApiHystrix implements ApplyManagerApi {

    @Override
    public Result<PageInfo<ApplyDTO>> pageListApply(OpenApiReq<ApplyQueryDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<ApplyQueryDetailDTO> getApplyDetail(ApplyDetailDTO applyDetailDTO) {
        return Result.timeout();
    }

    @Override
    public Result<String> updateByAudit(ApplyUpdateDTO applyUpdateDTO) {
        return Result.timeout();
    }

}

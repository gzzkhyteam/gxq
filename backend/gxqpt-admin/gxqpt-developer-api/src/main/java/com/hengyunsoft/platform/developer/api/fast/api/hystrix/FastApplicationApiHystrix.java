package com.hengyunsoft.platform.developer.api.fast.api.hystrix;


import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.FastApplicationApi;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import org.springframework.stereotype.Component;


@Component
public class FastApplicationApiHystrix implements FastApplicationApi {

    @Override
    public Result<PageInfo<FastApplicationPageRetDTO>> page( OpenApiReq<FastApplicationPageDTO> openApiReq) {return Result.timeout(); }

    @Override
    public Result<Boolean> startUse(FastApplicationStartUseDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> update(FastApplicationUpdateDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<ResponseApplicationDetailDTO> getById(Long id){
        return Result.timeout();
    }

    @Override
    public Result<ResponseApplicationDetailDTO> detailByAppId(String appId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> save(RequestApplicationSaveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<ResponseApplicationDetailDTO> findAllApplicaton() {
        return Result.timeout();
    }

    @Override
    public Result<ResponseApplicationDetailDTO> findApplicationRelation(String appId) {
        return Result.timeout();
    }

}

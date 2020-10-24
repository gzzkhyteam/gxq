package com.hengyunsoft.platform.developer.api.fast.api.hystrix;


import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.FastApplicationDocApi;
import com.hengyunsoft.platform.developer.api.fast.dto.docment.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FastApplicationDocApiHystrix implements FastApplicationDocApi {


    @Override
    public Result<PageInfo<FastAppDocTaskPageRetDTO>> page(OpenApiReq<FastAppDocTaskPageDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> approve(FastAppDocTaskApproveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> update(FastAppDocTaskUpdateDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<FastAppDocTaskRetDTO> getById(Long id) {
        return Result.timeout();
    }

    @Override
    public Result<List<FastAppDocExtraAdviceRetDTO>> getByTaskId(Long taskId) {
        return Result.timeout();
    }

    @Override
    public Result<FastAppDocTaskSaveRetDTO> saveDoc(FastAppDocTaskSaveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<FastAppDocExtraAdviceSaveRetDTO> saveExtraDoc(FastAppDocExtraAdviceSaveDTO dto){
        return Result.timeout();
    }
}

package com.hengyunsoft.platform.developer.api.fast.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.fast.api.FastMenuApi;
import com.hengyunsoft.platform.developer.api.fast.dto.FastBizConfigDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.FastMenuReqDTO;
import com.hengyunsoft.platform.developer.api.fast.dto.FastMenuUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FastMenuApiHystrix implements FastMenuApi {


    @Override
    public Result<List<FastBizConfigDTO>> getBizConfig(Long parentId) { return Result.timeout(); }

    @Override
    public Result<String> getMenu(FastMenuReqDTO dto) { return Result.timeout(); }

    @Override
    public Result<Boolean> update(FastMenuUpdateDTO dto) { return Result.timeout(); }
}

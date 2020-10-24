package com.hengyunsoft.platform.search.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.search.api.AdminApi;
import com.hengyunsoft.platform.search.dto.OptCollection2AppDTO;
import com.hengyunsoft.platform.search.dto.OptCollstionListDTO;
import org.springframework.stereotype.Component;

@Component
public class AdminApiHystrix implements AdminApi {
    @Override
    public Result<Boolean> appointCollection2App(OptCollection2AppDTO optCollection2AppDTO) {
        return Result.timeout();
    }

    @Override
    public Result<OptCollstionListDTO> showMyCollection() {
        return Result.timeout();
    }

    @Override
    public Result<Integer> getColleAppIpOpt(Long collectionId, String appId) {
        return Result.timeout();
    }

    @Override
    public Result<OptCollstionListDTO> showCollectionApp(Long collectionId) {
        return Result.timeout();
    }
}

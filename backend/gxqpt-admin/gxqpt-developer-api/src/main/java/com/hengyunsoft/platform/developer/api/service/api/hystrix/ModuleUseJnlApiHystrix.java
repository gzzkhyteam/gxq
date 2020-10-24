package com.hengyunsoft.platform.developer.api.service.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.service.api.ModuleUseJnlApi;
import com.hengyunsoft.platform.developer.api.service.dto.module.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModuleUseJnlApiHystrix implements ModuleUseJnlApi {

    @Override
    public Result<Boolean> save(ModuleUseJnlSaveDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<List<ModuleUseJnlMsgDTO>> getJnl(ModuleUseJnlDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<ModuleUseTotalDTO> getSumTotalNum() {
        return  Result.timeout();
    }

    @Override
    public Result<List<ModuleUseDayDataDTO>> findDayData() {
        return  Result.timeout();
    }

    @Override
    public Result<List<ModuleUseRankDTO>> getModuleUseRank() {
        return  Result.timeout();
    }
}

package com.hengyunsoft.platform.developer.api.screen.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.OrgScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.org.OrgMonthNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.org.OrgTitleDTO;

import java.util.List;

/**
 * @author wz
 * @create 2018-05-01 11:08
 * @desc 应用大屏熔断层
 **/
public class OrgScreenApiHystrix implements OrgScreenApi {
    @Override
    public Result<OrgTitleDTO> findTitle() {
        return Result.timeout();
    }

    @Override
    public Result<List<OrgMonthNumDTO>> findAppUseNum() {
        return Result.timeout();
    }
}
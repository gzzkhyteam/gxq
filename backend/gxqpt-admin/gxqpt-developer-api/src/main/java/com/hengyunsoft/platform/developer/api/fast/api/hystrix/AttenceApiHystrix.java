package com.hengyunsoft.platform.developer.api.fast.api.hystrix;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.PageRequest;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.developer.api.fast.api.AttenceApi;
import com.hengyunsoft.platform.developer.api.fast.api.FastMenuApi;
import com.hengyunsoft.platform.developer.api.fast.dto.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AttenceApiHystrix implements AttenceApi {


    @Override
    public Result<AttenceRuleDTO> queryAttenceRule(String appId) {
        return Result.timeout();
    }

    @Override
    public Result<Boolean> ruleSave(AttenceRuleDTO dto) {
        return Result.timeout();
    }

    @Override
    public Result<PageInfo<AttenceStatisticDTO>> statisticFind(OpenApiReq<RequestAttenceStatisticDTO> openApiReq) {
        return Result.timeout();
    }

    @Override
    public Result<Map<String, Object>> loadBusy(String startTime, String endTime) {
        return Result.timeout();
    }

    @Override
    public Result<Map<String, Object>> loadDetail(String startTime, String endTime) {
        return Result.timeout();
    }

    @Override
    public Result<Map<String, Object>> loadTotalView(String startTime, String endTime) {
        return Result.timeout();
    }

    @Override
    public Result<AttenceDTO> signInOrOut(AttenceDTO dto) {
        return Result.timeout();
    }


}

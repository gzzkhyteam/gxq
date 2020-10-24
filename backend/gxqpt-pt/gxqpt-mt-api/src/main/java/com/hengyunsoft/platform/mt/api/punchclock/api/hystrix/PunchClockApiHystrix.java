//package com.hengyunsoft.platform.mt.api.punchclock.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.punchclock.api.PunchClockApi;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.CreatePunchClockDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.PunchClockDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.PunchClockHisDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.QueryPunchclockParamDTO;
//
//public class PunchClockApiHystrix implements PunchClockApi {
//
//    @Override
//    public Result<Boolean> createPunchClock(CreatePunchClockDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PunchClockDTO> getTodayPunchClock() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<PunchClockHisDTO>> findPunchclockPage(OpenApiReq<QueryPunchclockParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//}

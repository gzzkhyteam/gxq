//package com.hengyunsoft.platform.mt.api.punchstatics.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.punchstatics.api.PunchAttendanceStaticsApi;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.PunchAttendanceStaticsDTO;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.StaticsDTO;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.WebQueryMyStaticsParamDTO;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.WebQueryStaticParamDTO;
//
//import java.util.List;
//
//public class PunchAttendanceStaticsApiHystrix implements PunchAttendanceStaticsApi {
//    @Override
//    public Result<PageInfo<PunchAttendanceStaticsDTO>> webQueryMyStatics(OpenApiReq<WebQueryMyStaticsParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<PunchAttendanceStaticsDTO>> webQueryStatics(OpenApiReq<WebQueryStaticParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PunchAttendanceStaticsDTO> h5GetMyStatics(String attMonth) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<StaticsDTO>> h5GetMyStaticsByType(String attMonth, String type) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Integer> getMonthWorkDays() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Double> getCurMonthLeveCount() {
//        return Result.timeout();
//    }
//}

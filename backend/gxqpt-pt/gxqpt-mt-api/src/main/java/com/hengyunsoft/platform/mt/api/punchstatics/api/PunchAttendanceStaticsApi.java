//package com.hengyunsoft.platform.mt.api.punchstatics.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.punchstatics.api.hystrix.PunchAttendanceStaticsApiHystrix;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.PunchAttendanceStaticsDTO;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.StaticsDTO;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.WebQueryMyStaticsParamDTO;
//import com.hengyunsoft.platform.mt.api.punchstatics.dto.WebQueryStaticParamDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 描述：
// *
// * @author gbl
// * @date 2018/7/24
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/", fallback = PunchAttendanceStaticsApiHystrix.class)
//public interface PunchAttendanceStaticsApi {
//
//    /**
//     * 描述：web端查询我的考勤
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/24
//     * 修改内容：
//     */
//    @RequestMapping(value = "webQueryMyStatics", method = RequestMethod.POST)
//    Result<PageInfo<PunchAttendanceStaticsDTO>> webQueryMyStatics(@RequestBody OpenApiReq<WebQueryMyStaticsParamDTO> openApiReq);
//
//    /**
//     * 描述：web端考勤统计接口
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/25
//     * 修改内容：
//     */
//    @RequestMapping(value = "webQueryStatics", method = RequestMethod.POST)
//    Result<PageInfo<PunchAttendanceStaticsDTO>> webQueryStatics(@RequestBody OpenApiReq<WebQueryStaticParamDTO> openApiReq);
//
//    /**
//     * 描述：h5查询我的考勤统计
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/25
//     * 修改内容：
//     */
//    @RequestMapping(value = "h5GetMyStatics", method = RequestMethod.GET)
//    Result<PunchAttendanceStaticsDTO> h5GetMyStatics(@RequestParam("attMonth") String attMonth);
//
//    /**
//     * 描述：h5查询统计查询具体的条目信息
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/26
//     * 修改内容：
//     */
//    @RequestMapping(value = "h5查询统计查询具体的条目信息", method = RequestMethod.GET)
//    Result<List<StaticsDTO>> h5GetMyStaticsByType(@RequestParam("attMonth") String attMonth, @RequestParam("type") String type);
//
//    /***
//     * 得到用户当前月已经出勤天数
//      * @return
//     */
//    @RequestMapping(value = "getMonthWorkDays", method = RequestMethod.GET)
//    Result<Integer> getMonthWorkDays();
//    /**
//     * 描述：查询本月共请假了多少小时
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/8/7
//     * 修改内容：
//     */
//    @RequestMapping(value = "getCurMonthLeveCount", method = RequestMethod.GET)
//    Result<Double> getCurMonthLeveCount();
//}

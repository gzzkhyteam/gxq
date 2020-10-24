//package com.hengyunsoft.platform.mt.api.punchclock.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.punchclock.api.hystrix.PunchClockApiHystrix;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.CreatePunchClockDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.PunchClockDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.PunchClockHisDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.clock.QueryPunchclockParamDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * 描述：打卡
// *
// * @author gbl
// * @date 2018/7/4
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/", fallback = PunchClockApiHystrix.class)
//public interface PunchClockApi {
//    /**
//     * 描述：创建打卡
//     * 参数： CreatePunchClockDTO
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/4
//     * 修改内容：
//     */
//    @RequestMapping(value = "createPunchClock", method = RequestMethod.POST)
//    Result<Boolean> createPunchClock(@RequestBody CreatePunchClockDTO dto);
//
//    /**
//     * 描述：得到今天的打卡记录
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/13
//     * 修改内容：
//     */
//    @RequestMapping(value = "getTodayPunchClock", method = RequestMethod.GET)
//    Result<PunchClockDTO> getTodayPunchClock();
//
//    /**
//     * 描述：分页查询打卡记录
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/9
//     * 修改内容：
//     */
//    @RequestMapping(value = "findPunchclockPage", method = RequestMethod.POST)
//    Result<PageInfo<PunchClockHisDTO>> findPunchclockPage(@RequestBody OpenApiReq<QueryPunchclockParamDTO> openApiReq);
//}

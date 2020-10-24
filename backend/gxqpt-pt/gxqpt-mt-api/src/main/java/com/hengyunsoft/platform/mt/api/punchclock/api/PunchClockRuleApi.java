//package com.hengyunsoft.platform.mt.api.punchclock.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.mt.api.punchclock.api.hystrix.PunchClockRuleApiHystrix;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.rule.CreatePunchClockRuleDTO;
//import com.hengyunsoft.platform.mt.api.punchclock.dto.rule.PunchClockRuleDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
///**
// * 描述：
// *
// * @author gbl
// * @date 2018/7/4
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/", fallback = PunchClockRuleApiHystrix.class)
//public interface PunchClockRuleApi {
//    /**
//     * 描述：创建考勤维护
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/4
//     * 修改内容：
//     */
//    @RequestMapping(value = "crateePunchClockRule", method = RequestMethod.POST)
//    Result<Boolean> crateePunchClockRule(@RequestBody CreatePunchClockRuleDTO dto);
//
//    /**
//     * 描述：获取用户单位的考勤配置
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/4
//     * 修改内容：
//     */
//    @RequestMapping(value = "getMyUnityPunchClockRule", method = RequestMethod.GET)
//    Result<PunchClockRuleDTO> getMyUnityPunchClockRule();
//}
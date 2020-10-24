//package com.hengyunsoft.platform.sms.api;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.sms.api.hystrix.AnalysisCountApiHystrix;
//import com.hengyunsoft.platform.sms.dto.AnalysisRespondsDTO;
//import com.hengyunsoft.platform.sms.dto.SmsAtlasCountDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTimeStampCountDTO;
//
///**
// * 短信分析统计接口
// * @author dxz
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/sms",
//fallback = AnalysisCountApiHystrix.class)
//public interface AnalysisCountApi {
//     
//    /**
//     * 各应用使用情况分析
//     * @return
//     */
//    @RequestMapping(value = "/analysis/applications", method = RequestMethod.GET)
//    Result<List<AnalysisRespondsDTO>> getApplicationsCount();  
//    /**
//     * 各服务使用情况分析
//     * @return
//     */
//    @RequestMapping(value = "/analysis/services", method = RequestMethod.GET)
//    Result<List<AnalysisRespondsDTO>> getServicesCount(); 
//    /**
//     * 短信时间分析
//     * @return
//     */
//    @RequestMapping(value = "/analysis/timestamp", method = RequestMethod.GET)
//    Result<List<SmsTimeStampCountDTO>> getTimeStampCount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime);
//    /**
//     * 发送、接收图谱
//     * @return
//     */
//    @RequestMapping(value = "/analysis/atlas", method = RequestMethod.GET)
//    Result<SmsAtlasCountDTO> getAtlasCount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime,@RequestParam(value = "mainMobile")String mainMobile);
//}

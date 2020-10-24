//package com.hengyunsoft.platform.sms.api;
//
//import java.util.List;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.sms.api.hystrix.SmsHistoryRecordApiHystrix;
//import com.hengyunsoft.platform.sms.dto.SmsAcountDTO;
//import com.hengyunsoft.platform.sms.dto.SmsMonthAcountDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTemplateTop10DTO;
//import com.hengyunsoft.platform.sms.dto.SmsYearAcountDTO;
//
///**
// * 短信首页Api
// * @author Administrator
// *
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/sms",
//fallback = SmsHistoryRecordApiHystrix.class)
//public interface SmsHistoryRecordApi {
//	/**
//     * 各短信量统计
//     * @return
//     */
//    @RequestMapping(value = "/home/smsacount", method = RequestMethod.GET)
//    Result<SmsAcountDTO> getSmsAcount();
//	/**
//     * 近一月短信使用情况
//     * @return
//     */
//    @RequestMapping(value = "/home/acount/month", method = RequestMethod.GET)
//    Result<List<SmsMonthAcountDTO>> getSmsMonthAcount();
//	/**
//     * 近一年短信使用情况
//     * @return
//     */
//    @RequestMapping(value = "/home/acount/year", method = RequestMethod.GET)
//    Result<List<SmsYearAcountDTO>> getSmsYearAcount();
//	/**
//     * 模板使用TOP10
//     * @return
//     */
//    @RequestMapping(value = "/home/template/top10", method = RequestMethod.GET)
//    Result<List<SmsTemplateTop10DTO>> getTemplateTop10();
//}

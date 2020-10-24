//package com.hengyunsoft.platform.sms.api.hystrix;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.sms.api.SmsTemplateApi;
//import com.hengyunsoft.platform.sms.dto.QuerySmsTemplateDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTemplateDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTemplateListDTO;
//
//@Component
//public class SmsTemplateApiHystrix implements SmsTemplateApi{
//
//	public Result<String> addSmsTemplate(SmsTemplateDTO smsTemplateDTO) {
//		return Result.timeout();
//	}
//
//	public Result<String> updateSmsTemplate(SmsTemplateDTO smsTemplateDTO) {
//		return Result.timeout();
//	}
//
//	public Result<String> deleteSmsTemplate(Long id) {
//		return Result.timeout();
//	}
//
//	public Result<String> getSmsTemplate(Long id) {
//		return Result.timeout();
//	}
//
//	public Result<SmsTemplateDTO> getSmsTemplateDetail(Long id) {
//		return Result.timeout();
//	}
//
//	public Result<List<Map<String,Object>>> getSmsTemplateChannelList(String channelid) {
//		return Result.timeout();
//	}
//
//	public Result<PageInfo<SmsTemplateListDTO>> pageSmsTemplate(
//			OpenApiReq<QuerySmsTemplateDTO> openApiReq) {
//		return Result.timeout();
//	}
//	public Result<PageInfo<SmsTemplateDTO>> getSmsTemplateCreate(@RequestParam(value = "channelId") String channelId){
//		return Result.timeout();
//	}
//}

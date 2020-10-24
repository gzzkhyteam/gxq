//package com.hengyunsoft.platform.sms.api.hystrix;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.sms.api.SmsHistoryRecordApi;
//import com.hengyunsoft.platform.sms.dto.SmsAcountDTO;
//import com.hengyunsoft.platform.sms.dto.SmsMonthAcountDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTemplateTop10DTO;
//import com.hengyunsoft.platform.sms.dto.SmsYearAcountDTO;
//
//@Component
//public class SmsHistoryRecordApiHystrix implements SmsHistoryRecordApi{
//
//	@Override
//	public Result<SmsAcountDTO> getSmsAcount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<SmsMonthAcountDTO>> getSmsMonthAcount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<SmsYearAcountDTO>> getSmsYearAcount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<SmsTemplateTop10DTO>> getTemplateTop10() {
//		return Result.timeout();
//	}
//
//}

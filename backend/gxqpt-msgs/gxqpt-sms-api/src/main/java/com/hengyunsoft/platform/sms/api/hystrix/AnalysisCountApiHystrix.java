//package com.hengyunsoft.platform.sms.api.hystrix;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.sms.api.AnalysisCountApi;
//import com.hengyunsoft.platform.sms.dto.AnalysisRespondsDTO;
//import com.hengyunsoft.platform.sms.dto.SmsAtlasCountDTO;
//import com.hengyunsoft.platform.sms.dto.SmsTimeStampCountDTO;
//@Component
//public class AnalysisCountApiHystrix implements AnalysisCountApi{
//
//	@Override
//	public Result<List<AnalysisRespondsDTO>> getApplicationsCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<AnalysisRespondsDTO>> getServicesCount() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<SmsTimeStampCountDTO>> getTimeStampCount(String startTime, String endTime) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<SmsAtlasCountDTO> getAtlasCount(String startTime, String endTime,String mainMobile) {
//		return Result.timeout();
//	}
//
//}

//package com.hengyunsoft.platform.sms.api.hystrix;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.sms.api.ServiceAccountApi;
//import com.hengyunsoft.platform.sms.dto.AppointAppDTO;
//import com.hengyunsoft.platform.sms.dto.ServiceAccountDTO;
//import com.hengyunsoft.platform.sms.dto.ServiceAccountMsgDTO;
//import com.hengyunsoft.platform.sms.dto.ServiceAccountPageDTO;
//
//@Component
//public class ServiceAccountApiHystrix implements ServiceAccountApi{
//
//	public Result<String> addAcount(ServiceAccountDTO serviceAccountDTO) {
//		return Result.timeout();
//	}
//
//	public Result<String> updateAcount(ServiceAccountDTO serviceAccountDTO) {
//		return Result.timeout();
//	}
//
//	public Result<String> deleteAcount(Long id) {
//		return Result.timeout();
//	}
//
//	public Result<List<Map<String, Object>>> getAcountList(Long createUserId) {
//		return Result.timeout();
//	}
//
//	public Result<ServiceAccountDTO> getAcountDetali(Long id) {
//		return Result.timeout();
//	}
//
//	public Result<String> saveAppoint(AppointAppDTO appointAppDTO) {
//		return Result.timeout();
//	}
//
//	public Result<PageInfo<ServiceAccountDTO>> pageAcountList(
//			OpenApiReq<ServiceAccountPageDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<ServiceAccountMsgDTO>> getAccountByServer(String server) {
//		return Result.timeout();
//	}
//}

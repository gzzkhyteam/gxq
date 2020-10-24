//package com.hengyunsoft.platform.sms.api.hystrix;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.sms.api.SmsPubliserApi;
//import com.hengyunsoft.platform.sms.dto.BlackListRequestDTO;
//import com.hengyunsoft.platform.sms.dto.BlackListResponseDTO;
//import com.hengyunsoft.platform.sms.dto.PublisherPullblackDTO;
//
//@Component
//public class SmsPubliserApiHystrix implements SmsPubliserApi{
//
//	@Override
//	public Result<Boolean> savePublisherPullblack(PublisherPullblackDTO publisherPullblackDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<BlackListResponseDTO>> getPublisherList(OpenApiReq<BlackListRequestDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//}

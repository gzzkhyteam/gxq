//package com.hengyunsoft.platform.msgs.api.msg.hystrix;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.api.msg.MsgsPublisherApi;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsBackListDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsBackListRequestDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessagePublisherDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.PublisherBlackListDTO;
//
//@Component
//public class MsgsPublisherApiHystrix implements MsgsPublisherApi{
//
//	@Override
//	public Result<Boolean> savePublisherPullblack(PublisherBlackListDTO publisherBlackListDTO) {		
//		return Result.timeout();
//	}
//	
//	@Override
//	public Result<PageInfo<MsgsListBackDTO>> getMsgPage(OpenApiReq<MsgsMessagePublisherDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<MsgsBackListDTO>> getPublisherList(OpenApiReq<MsgsBackListRequestDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//}

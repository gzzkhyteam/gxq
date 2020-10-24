//package com.hengyunsoft.platform.msgs.api.msg.hystrix;
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.api.msg.MsgsMessageApi;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageSendDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MobileMsgsListBackDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MobileNewReadDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgDetailDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageMobileDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageQueryDTO;
//@Component
//public class MsgsMessageApiHystrix implements MsgsMessageApi {
//
//	@Override
//	public Result<String> save(MessageSendDTO messageSendDTO) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<String> update(MessageSendDTO messageSendDTO) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<Boolean> delete(Long id) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<PageInfo<MsgsListBackDTO>> query(OpenApiReq<MsgsMessageQueryDTO> openApiReq) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<MsgDetailDTO> getMsgDetail(Long msgId) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<MsgDetailDTO> getDraftsDetail(Long msgId) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<PageInfo<MobileMsgsListBackDTO>> queryMobile(OpenApiReq<MsgsMessageMobileDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<MobileNewReadDTO> queryMobileIsRead(Long userId) {
//		return Result.timeout(); 
//	}
//
//	@Override
//	public Result<Boolean> saveMobileIsRead(Long userId, Long msgId) {
//		return Result.timeout(); 
//	}    
//}
//
//

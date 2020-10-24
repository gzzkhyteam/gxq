//package com.hengyunsoft.platform.msgs.open.msg.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.open.msg.MessageCenterApi;
////@Component
//public class MessageCenterApiHystrix implements MessageCenterApi{
//
//	@Override
//	public Result<PageInfo<MessageCenterDTO>> pageMoreMessageCenterList(OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<MessageCenterDTO> addMessageCenter(MessageCenterSaveDTO messageCenterSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> deleteMessageCenter(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateMessageCenter(MessageCenterUpdateDTO messageCenterUpdateDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateMessageCenterStatus(Long id) {
//		return Result.timeout();
//	}
//
//}

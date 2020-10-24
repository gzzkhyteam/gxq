//package com.hengyunsoft.platform.msgs.open.msg.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.open.msg.MailCenterApi;
//
////@Component
//public class MailCenterApiHystrix implements MailCenterApi{
//
//	@Override
//	public Result<PageInfo<MailCenterDTO>> pageMoreMailCenterList(OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<MailCenterDTO> addMailCenter(MailCenterSaveDTO mailCenterSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> deleteMailCenter(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateMailCenter(MailCenterUpdateDTO mailCenterUpdateDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateMailCenterStatus(Long id) {
//		return Result.timeout();
//	}
//}

//package com.hengyunsoft.platform.msgs.open.msg.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.open.msg.BacklogApi;
//
////@Component
//public class BacklogApiHystrix implements BacklogApi{
//
//	@Override
//	public Result<PageInfo<BacklogDTO>> pageMoreBacklogList(OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<BacklogDTO> addBacklog(BacklogSaveDTO backlogSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> deleteBacklog(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateBacklog(BacklogUpdateDTO backlogUpdateDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateBacklogStatus(Long id) {
//		return Result.timeout();
//	}
//}

//package com.hengyunsoft.platform.msgs.open.msg.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeUpdateDTO;
//import com.hengyunsoft.platform.msgs.open.msg.OfficeApi;
//
////@Component
//public class OfficeApiHystrix implements OfficeApi{
//
//	@Override
//	public Result<PageInfo<OfficeDTO>> pageMoreOfficeList(OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<OfficeDTO> addOffice(OfficeSaveDTO officeSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> deleteOffice(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateOffice(OfficeUpdateDTO officeUpdateDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateOfficeStatus(Long id) {
//		return Result.timeout();
//	}
//}

//package com.hengyunsoft.platform.msgs.open.msg.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.open.msg.BulletinCenterApi;
//
////@Component
//public class BulletinCenterApiHystrix implements BulletinCenterApi{
//
//	@Override
//	public Result<PageInfo<BulletinCenterDTO>> pageMoreBulletinCenterList(OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<BulletinCenterDTO> addBulletinCenter(BulletinCenterSaveDTO bulletinCenterSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> deleteBulletinCenter(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateBulletinCenter(BulletinCenterUpdateDTO bulletinCenterUpdateDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> updateBulletinCenterStatus(Long id) {
//		return Result.timeout();
//	}
//}

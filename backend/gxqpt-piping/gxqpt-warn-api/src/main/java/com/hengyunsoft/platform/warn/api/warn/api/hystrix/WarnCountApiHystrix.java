//package com.hengyunsoft.platform.warn.api.warn.api.hystrix;
//
//import java.util.List;
//
//import com.hengyunsoft.platform.warn.api.warn.dto.*;
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warn.api.WarnCountApi;
//
//@Component
//public class WarnCountApiHystrix implements WarnCountApi{
//
//	@Override
//	public Result<PageInfo<WarnPersonalCountDTO>> getPersonalByDepartment(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnDepartmentCountDTO>> getDepartmentByCompany(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnAppCountDTO>> getByApp(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnStatusCountDTO>> getStatusByPersonal(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnStatusCountDTO>> getStatusByCompany(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnStatusCountDTO>> getStatusByApp(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnPersonalCountDTO>> getHandleByPersonal(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnDepartmentCountDTO>> getHandleByCompany(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<PageInfo<WarnAppCountDTO>> getHandleByApp(OpenApiReq<WarnParamDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<FairWarnStatusCountDTO>> getNumberByAppId(String appid) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<FairWarnLevelCountDTO>> getLevelByAppId(String appid) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<FairWarnTypeReturnDTO> getTypeByAppId(String appid) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<FairWarnAppCountDTO> getAppsNumber() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<FairWarnTimeSlotCountDTO>> getTimeSlotByAppId(String appid) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<FairRelationshipDTO>> getRelationship() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<WarnMixStatusNumDTO> getWarnMixStatusNum(Long userId)  {
//		return Result.timeout();
//	}
//}

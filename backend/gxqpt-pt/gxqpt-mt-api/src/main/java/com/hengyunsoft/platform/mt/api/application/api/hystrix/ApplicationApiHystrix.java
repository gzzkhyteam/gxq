//package com.hengyunsoft.platform.mt.api.application.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.application.api.ApplicationApi;
//import com.hengyunsoft.platform.mt.api.application.dto.*;
//
//import java.util.List;
//
//public class ApplicationApiHystrix implements ApplicationApi {
//    @Override
//    public Result<Long> createAppFirst(CreateAppFirstReqDTO dto) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<PageInfo<ApplicationDTO>> find(OpenApiReq<QueryApplicationParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<AppIdAndNameDTO>> findAllApp() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ApplicationDTO> getAppBaseInfo(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> auditApp(AuditAppReqDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> createFunction(CreateFunctionReqDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FunctionDTO>> findFunctionListByAppId(Long appId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<FunctionDTO>> findAllFunctionList() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<FunctionDTO> getFunctionInfo(Long funcId) {
//        return Result.timeout();
//    }
//
//
//}

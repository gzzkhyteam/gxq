//package com.hengyunsoft.platform.mt.api.version.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.version.api.ClientVersionApi;
//import com.hengyunsoft.platform.mt.api.version.dto.ClientVersionDTO;
//import com.hengyunsoft.platform.mt.api.version.dto.CreateVersionParamDTO;
//import com.hengyunsoft.platform.mt.api.version.dto.QueryClientVersionParamDTO;
//
//public class ClientVersionApiHystrix implements ClientVersionApi {
//    @Override
//    public Result<Boolean> createVersion(CreateVersionParamDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ClientVersionDTO>> find(OpenApiReq<QueryClientVersionParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> publishVersion(Long id) throws Exception {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ClientVersionDTO>> findPubishVersion(OpenApiReq<QueryClientVersionParamDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ClientVersionDTO> getBaseInfo(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ClientVersionDTO> getLastVersionInfo() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> addUpdataOne(Long id) {
//        return Result.timeout();
//    }
//
//
//}

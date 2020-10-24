//package com.hengyunsoft.platform.exchange.api.overview.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.dataapi.dto.dataapi.ApiReturnDataDTO;
//import com.hengyunsoft.platform.exchange.api.overview.api.DataOverviewApi;
//import com.hengyunsoft.platform.exchange.api.overview.dto.*;
//import com.hengyunsoft.platform.exchange.api.screen.dto.ScreenDataCountDTO;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @todo 数据概览熔断器
// * feign 熔断机制的实现， 默认返回超时响应
// * @author wgj
// * @creatiem 2018-4-21 14:42
// */
//@Component
//public class DataOverviewApiHystrix implements DataOverviewApi{
//    @Override
//    public Result<ScreenDataCountDTO> getShareDataCount() {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<DirOrgDTO>> getBusDataList(OpenApiReq<DirOrgDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<DirViewDTO>> getBottomDirList(OpenApiReq<DirOrgDTO> openApiReq) {
//
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DirViewDTO> getDirView(String id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ApiViewDTO>> getApiList(OpenApiReq<DirViewDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<List<ApiReturnDataDTO>> getHostApi() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<OrgDTO>> getOrgList() {
//
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateSeeCount(String id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Map<String, Integer>> getApiSetCount(String busCode, String unitId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<DirViewDTO>> getBottomDirListByType(OpenApiReq<DirOrgDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Map<String, Integer>> getApiCountByType(String busCode,String busKey) {
//        return Result.timeout();
//    }
//
//
//}

//package com.hengyunsoft.platform.exchange.api.screen.api.hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.exchange.api.screen.api.ShareDataScreenApi;
//import com.hengyunsoft.platform.exchange.api.screen.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author wgj
// * @todo 数博会数据共享交换屏熔断器
// * feign 熔断机制的实现， 默认返回超时响应
// * @creatiem 2018-4-21 14:42
// */
//@Component
//public class ShareDataScreenApiHystrix implements ShareDataScreenApi {
//
//
//    @Override
//    public Result<ScreenDataCountDTO> getShareDataCount() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<ScreenDataViewDTO> getShareDataView() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<OrgApiViewDTO> getOrgUseView() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<OrgApiViewDTO> getApiCallTopList() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataTrendDTO> getDataTrend() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<ScreenApiRealDTO>> getApiRealTimeCall() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<RelationshipDTO>> getCallRelationship() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DirDataCount> getDirDataCount(String unitId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<OrgDataDTO> getOrgDataCount() {
//        return Result.timeout();
//    }
//
//
//}

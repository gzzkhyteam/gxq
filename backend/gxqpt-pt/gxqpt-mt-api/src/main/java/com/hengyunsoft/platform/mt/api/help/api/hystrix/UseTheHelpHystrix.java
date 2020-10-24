//package com.hengyunsoft.platform.mt.api.help.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.help.api.UseTheHelpApi;
//import com.hengyunsoft.platform.mt.api.help.dto.*;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// * @author tianai
// * @createTime 2018-05-27
// */
//public class UseTheHelpHystrix implements UseTheHelpApi{
//    @Override
//    public Result<PageInfo<UseTheHelpDTO>> page(OpenApiReq<UseTheHelpPageReqDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<UseTheHelpSaveDTO> save(UseTheHelpSaveDTO useTheHelpSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<UseTheHelpUpdateDTO> update(UseTheHelpUpdateDTO useTheHelpUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<UseTheHelpUpdateDTO> audit(UseTheHelpUpdateDTO useTheHelpUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<UseTheHelpUpdateDTO> discardAudit(UseTheHelpUpdateDTO useTheHelpUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<UseTheHelpDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//}

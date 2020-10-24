//package com.hengyunsoft.platform.logs.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.LogStructApi;
//import com.hengyunsoft.platform.logs.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class LogStructApiHystrix implements LogStructApi{
//
//
//    @Override
//    public Result<PageInfo<LogStructAppDTO>> pageQueryApp(OpenApiReq<LogStructAppQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogStructAppDTO> getApp(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteApp(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructApacheDTO>> pageQueryApache(OpenApiReq<LogStructApacheQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogStructApacheDTO> getApache(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteApache(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructNginxDTO>> pageQueryNginx(OpenApiReq<LogStructNginxQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogStructNginxDTO> getNginx(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteNginx(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcat(OpenApiReq<LogStructTomcatQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogStructTomcatDTO> getTomcat(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteTomcat(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructTogetherDTO>> pageQueryTogether(OpenApiReq<LogStructTogetherQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//}

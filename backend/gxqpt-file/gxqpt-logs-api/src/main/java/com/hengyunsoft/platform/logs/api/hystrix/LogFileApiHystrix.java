//package com.hengyunsoft.platform.logs.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.LogFileApi;
//import com.hengyunsoft.platform.logs.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class LogFileApiHystrix implements LogFileApi {
//    @Override
//    public Result<PageInfo<LogFileDTO>> pageQueryUpload(OpenApiReq<LogFileQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructAppDTO>> pageQueryAppList(OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructApacheDTO>> pageQueryApacheList(OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructNginxDTO>> pageQueryNginxList(OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcatList(OpenApiReq<LogFileQueryStructByIdDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<LogFileDTO> save(LogFileSaveDTO logFilesSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogFileDTO>> pageQuery(OpenApiReq<LogFileQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogFileDTO> saveFileInterface(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateFileInterface(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteBatch(String ids)  {
//        return Result.timeout();
//    }
//}

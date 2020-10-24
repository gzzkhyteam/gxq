//package com.hengyunsoft.platform.logs.open.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.dto.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//@Component
//public class LogOpenApiHystrix implements com.hengyunsoft.platform.logs.open.LogOpenApi{
//
//    @Override
//    public Result<LogStructAppOpenDTO> write(LogStructAppOpenDTO logStructAppOpenDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> upload(MultipartFile file, String logType) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogFileDTO>> pageQuery(OpenApiReq<LogFileOpenQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructAppDTO>> pageQueryApp(OpenApiReq<LogStructAppOpenQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructApacheDTO>> pageQueryApache(OpenApiReq<LogStructApacheOpenQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructNginxDTO>> pageQueryNginx(OpenApiReq<LogStructNginxOpenQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcat(OpenApiReq<LogStructTomcatOpenQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//    @Override
//    public Result<Boolean> delAllLog(LogDelDTO logDelDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delAppLog(LogDelDTO logDelDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delApacheLog(LogDelDTO logDelDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delNginxLog(LogDelDTO logDelDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delTomcatLog(LogDelDTO logDelDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delLogFileByIds(String ids) {
//        return Result.timeout();
//    }
//}

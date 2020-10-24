//package com.hengyunsoft.platform.logs.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.LogWarnApi;
//import com.hengyunsoft.platform.logs.dto.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@Component
//public class LogWarnApiHystrix implements LogWarnApi{
//    @Override
//    public Result<PageInfo<LogWarningDTO>> pageQueryWarning(OpenApiReq<LogWarningQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructAppDTO>> pageQueryWarningApp(OpenApiReq<LogWarningQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructApacheDTO>> pageQueryWarningApache(OpenApiReq<LogWarningQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructTomcatDTO>> pageQueryWarningTomcat(OpenApiReq<LogWarningQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogStructNginxDTO>> pageQueryWarningNginx(OpenApiReq<LogWarningQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateWarningDeal(LogWarningUpdateDTO logWarningUpdateDTO) {
//       return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateWarningDealBatch(LogWarningUpdateBatchDTO logWarningUpdateBatchDTO) {
//       return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<LogWarnRuleDTO>> pageQueryWarnRule(OpenApiReq<LogWarnRuleQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogWarnRuleDTO> saveWarnRule(LogWarnRuleSaveDTO logWarnRuleSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> deleteBatch(String ids) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogWarnRuleDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateWarnRule(@RequestBody LogWarnRuleUpdateDTO logWarnRuleUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> warnRuleIsAbled(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogWarnSetDTO> getSetDay() {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogWarnSetDTO> updateSetDay(@RequestBody LogWarnSetDTO logWarnSetDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<LogWarnSetDTO> recover() {
//        return Result.timeout();
//    }
//}

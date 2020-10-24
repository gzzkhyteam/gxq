//package com.hengyunsoft.platform.logs.api.hystrix;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.logs.api.LogCountApi;
//import com.hengyunsoft.platform.logs.dto.LogNumberAnalysisBaseDTO;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.List;
//
//@Component
//public class LogCountApiHystrix implements LogCountApi {
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getLoginQuantity(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getBusinessClassAccount(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getLogLevelAccount(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getLevelNumberAccount(String startTime, String endTime, String parentId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getNumberAccount(String startTime, String endTime, String parentId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getNumberAnalysis(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getResponseTime(String startTime, String endTime, String applyId, String logType) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getWarnLevelNumber(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getWarnLevelAccount(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getWarnTypeNumber(String startTime, String endTime, String applyId, String logType) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getWarnTypeAccount(String startTime, String endTime, String applyId) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getPageAccess(String startTime, String endTime, String applyId,String logType) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getHttpStatus(String startTime, String endTime, String applyId,String logType) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getBrowserType(String startTime, String endTime, String applyId,String logType) throws ParseException {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<LogNumberAnalysisBaseDTO>> getPvToUvCount(String startTime, String endTime, String applyId,String logType) throws ParseException {
//        return Result.timeout();
//    }
//}

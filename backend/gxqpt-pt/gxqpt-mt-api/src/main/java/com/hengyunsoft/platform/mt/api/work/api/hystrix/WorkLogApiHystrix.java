//package com.hengyunsoft.platform.mt.api.work.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.work.api.WorkLogApi;
//import com.hengyunsoft.platform.mt.api.work.dto.*;
//
//import java.util.List;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// *
// * @author tianai
// * @createTime 2018-05-27
// */
//public class WorkLogApiHystrix implements WorkLogApi {
//    @Override
//    public Result<PageInfo<WorkLogPageDTO>> page(OpenApiReq<WorkLogPageReqDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<WorkLogDTO>> pageApp(OpenApiReq<WorkLogAppPageReqDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<WorkLogCountDTO>> getList(String unitId, String deptId, String name) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<WorkLogSaveDTO> save(WorkLogSaveDTO workLogSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<WorkLogDTO>> findByUserId(String unitId, Long userId, String startTime, String endTime) {
//        return Result.timeout();
//    }
//
//
//    @Override
//    public Result<WorkLogDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<WorkLogAnswerSaveDTO> saveAnswer(WorkLogAnswerSaveDTO workLogAnswerSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<WorkLogDTO>> lookPage(OpenApiReq<WorkLogAppPageReqDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<WorkLogAnswerDTO>> getAnswerList(Long workLogId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<WorkLogLookDTO>> getAuthorityList(String unitId, Long userId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<WorkLogLookSaveDTO> workLogLook(WorkLogLookSaveDTO workLogLookSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<WorkLogDetailDTO> getDetail(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<WorkLogDetailDTO> updateDetail(WorkLogDetailDTO workLogDetailDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<WorkLogLookDTO>> getLookUser(Long logId, Integer status) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Integer> getMonthCount() {
//        return Result.timeout();
//    }
//
//
//}

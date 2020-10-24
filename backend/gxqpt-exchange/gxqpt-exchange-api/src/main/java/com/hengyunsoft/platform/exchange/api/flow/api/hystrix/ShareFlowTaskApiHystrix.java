//package com.hengyunsoft.platform.exchange.api.flow.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryAuditDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryPageReqAuditDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryPageReqDTO;
//import com.hengyunsoft.platform.exchange.api.flow.api.ShareFlowTaskApi;
//import com.hengyunsoft.platform.exchange.api.flow.dto.*;
//import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetParamReqDTO;
//import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetResEleDTO;
//import org.springframework.stereotype.Component;
//
///**
// * @author wgj
// * @todo 待办任务熔断器
// * feign 熔断机制的实现， 默认返回超时响应
// * @creatiem 2018-4-21 14:42
// */
//@Component
//public class ShareFlowTaskApiHystrix implements ShareFlowTaskApi {
//
//
//    @Override
//    public Result<ShareFlowAuditDTO> getTaskHdDetail(String applyCode) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<DataDirectoryAuditDTO>> getDirectoryTask(OpenApiReq<DataDirectoryPageReqAuditDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<QueryDataSetResEleDTO>> getDataSetTask(OpenApiReq<QueryDataSetParamReqDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<ShareFLowApiListDTO>> findApiTask(OpenApiReq<ShareFLowApiConditionDTO> openApiReq) {
//        return null;
//    }
//
//    @Override
//    public Result<PageInfo<ShareFLowDemandListDTO>> findDemandTask(OpenApiReq<ShareFLowDemandConditionDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 描述：api需求处理
//     * 参数：ShareDataHandleDemandDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @Override
//    public Result<Boolean> saveHandleDemand(ShareDataHandleDemandDTO dto) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> dateSetHandleDemand(HandleDTO handleDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> saveHandleApi(ShareDataHandleApiDTO handleDTO) {
//        return  Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> updateDirectory(HandleDirectoryDTO dto) {
//        return Result.timeout();
//    }
//
//   /* @Override
//    public Result<Boolean> updatePtDir(HandleDirectoryPtDTO dto) {
//        return Result.timeout();
//    }*/
//}

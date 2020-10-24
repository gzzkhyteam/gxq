//package com.hengyunsoft.platform.exchange.api.flow.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryAuditDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryPageReqAuditDTO;
//import com.hengyunsoft.platform.exchange.api.directory.dto.directory.DataDirectoryPageReqDTO;
//import com.hengyunsoft.platform.exchange.api.flow.api.hystrix.ShareFlowTaskApiHystrix;
//import com.hengyunsoft.platform.exchange.api.flow.dto.*;
//import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetParamReqDTO;
//import com.hengyunsoft.platform.exchange.api.set.dto.QueryDataSetResEleDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.sql.SQLException;
//
///**
// * @author wgj
// * @TODO: 待办接口
// * 查询我审批的各待办任务
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// * @createTime 2018-04-21 14:42
// */
//@FeignClient(name = "${gxqpt.feign.exchange-server:gxqpt-exchange-server}",
//        fallback = ShareFlowTaskApiHystrix.class)
//public interface ShareFlowTaskApi {
//    /**
//     * 描述：获取任务处理详情
//     * 参数：taskId 任务Id
//     * 返回值：ShareFlowAuditDTO
//     * 修改人：zhaopengfei
//     * 修改时间：2018/5/6
//     * 修改内容：
//     */
//    @RequestMapping(value = "/gettaskhddetail", method = RequestMethod.POST)
//    public Result<ShareFlowAuditDTO> getTaskHdDetail(@RequestParam("applyCode") String applyCode );
//    /**
//     * @param unitId 流程状态 1,通过；2，驳回
//     * @param userId 申请用户id
//     * @return ShareFlowTaskDTO
//     * @todo 查询目录审批任务
//     * @Param 其他筛选条件
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/task/getDirectoryTask", method = RequestMethod.POST)
//    Result<PageInfo<DataDirectoryAuditDTO>> getDirectoryTask(@RequestBody OpenApiReq<DataDirectoryPageReqAuditDTO> openApiReq);
//
//    /**
//     * @param unitId 流程状态 1,通过；2，驳回
//     * @param userId 申请用户id
//     * @return ShareFlowTaskDTO
//     * @todo 查询数据集审批任务
//     * @Param 其他筛选条件
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/task/getDataSetTask", method = RequestMethod.POST)
//    Result<PageInfo<QueryDataSetResEleDTO>> getDataSetTask(@RequestBody OpenApiReq<QueryDataSetParamReqDTO> openApiReq);
//
//    /**
//     * @param unitId 流程状态 1,通过；2，驳回
//     * @param userId 申请用户id
//     * @return ShareFlowTaskDTO
//     * @todo 查询共享审批任务
//     * @Param 其他筛选条件
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/task/getApiTask", method = RequestMethod.POST)
//    public Result<PageInfo<ShareFLowApiListDTO>> findApiTask(@RequestBody OpenApiReq<ShareFLowApiConditionDTO> openApiReq);
//
//    /**
//     * @return ShareFLowDemandListDTO
//     * @todo 查询需求审批任务
//     * @Param openApiReq
//     * @Author wgj
//     * @createtime 2018-4-22
//     */
//    @RequestMapping(value = "/task/finddemandtask", method = RequestMethod.POST)
//    public Result<PageInfo<ShareFLowDemandListDTO>> findDemandTask(OpenApiReq<ShareFLowDemandConditionDTO> openApiReq);
//
//    /**
//     * 描述：api需求处理
//     * 参数：ShareDataHandleDemandDTO API元数据
//     * 返回值：Boolean 状态（成功、失败）
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/21
//     * 修改内容：
//     */
//    @RequestMapping(value = "/task/handledemand", method = RequestMethod.POST)
//    Result<Boolean> saveHandleDemand(@RequestBody ShareDataHandleDemandDTO dto);
//
//
//
//    /**
//     * 描述：数据集审批处理
//     * 参数：handleDTO
//     * 返回值：com.hengyunsoft.base.Result<java.lang.Boolean>
//     * 修改人：gbl
//     * 修改时间：2018/4/26
//     * 修改内容：
//     */
//    @RequestMapping(value = "/set/dateSetHandleDemand", method = RequestMethod.POST)
//    Result<Boolean> dateSetHandleDemand(@RequestBody HandleDTO handleDTO);
//
//     /**
//     * 描述：共享审核审批
//     * 参数：
//     * 返回值：
//     * 修改人：zhaopengfei
//     * 修改时间：2018/4/27
//     * 修改内容：
//     */
//    @RequestMapping(value = "/task/handleapi", method = RequestMethod.POST)
//    Result<Boolean> saveHandleApi(@RequestBody ShareDataHandleApiDTO handleDTO);
//
//    /**
//     *  目录发布审核
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/task/updateDirectory", method = RequestMethod.POST)
//    Result<Boolean> updateDirectory(@RequestBody HandleDirectoryDTO dto) throws SQLException;
//
// /*   *//**
//     *  平台管理员目录直接发布审核
//     * @param
//     * @return
//     *//*
//    @RequestMapping(value = "/task/updatePtDir", method = RequestMethod.POST)
//    Result<Boolean> updatePtDir(@RequestBody HandleDirectoryPtDTO handleDirectoryPtDTO);*/
//}

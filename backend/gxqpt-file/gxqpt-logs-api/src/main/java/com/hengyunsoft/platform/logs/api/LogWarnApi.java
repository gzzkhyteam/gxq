//package com.hengyunsoft.platform.logs.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.hystrix.LogWarnApiHystrix;
//import com.hengyunsoft.platform.logs.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * 日志告警信息查询和管理
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/logs", fallback = LogWarnApiHystrix.class)
//public interface LogWarnApi {
//    /**
//     * 分页查询日志告警的记录
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/pageQueryWarning", method = RequestMethod.POST)
//    Result<PageInfo<LogWarningDTO>> pageQueryWarning(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq);
//
//    /**
//     * 分页查询告警的应用系统结构化日志列表（app）
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/pageQueryWarningApp", method = RequestMethod.POST)
//    Result<PageInfo<LogStructAppDTO>> pageQueryWarningApp(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq);
//    /**
//     * 分页查询告警的apache结构化日志列表（apahce）
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/pageQueryWarningApache", method = RequestMethod.POST)
//    Result<PageInfo<LogStructApacheDTO>> pageQueryWarningApache(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq);
//    /**
//     * 分页查询告警的tomcat结构化日志列表（tomcat）
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/pageQueryWarningTomcat", method = RequestMethod.POST)
//    Result<PageInfo<LogStructTomcatDTO>> pageQueryWarningTomcat(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq);
//    /**
//     * 分页查询告警的nginx结构化日志列表（nginx）
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/pageQueryWarningNginx", method = RequestMethod.POST)
//    Result<PageInfo<LogStructNginxDTO>> pageQueryWarningNginx(@RequestBody OpenApiReq<LogWarningQueryDTO> openApiReq);
//
//    /**
//     * 单个处理告警日志信息
//     *
//     * @param logWarningUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/warn/updateWarningDeal", method = RequestMethod.POST)
//    Result<Boolean> updateWarningDeal(@RequestBody LogWarningUpdateDTO logWarningUpdateDTO);
//    /**
//     * 批量处理告警日志信息
//     *
//     * @param logWarningUpdateBatchDTO
//     * @return
//     */
//    @RequestMapping(value = "/warn/updateWarningDealBatch", method = RequestMethod.POST)
//    Result<Boolean> updateWarningDealBatch(@RequestBody LogWarningUpdateBatchDTO logWarningUpdateBatchDTO);
//
//
//    //===========================告警规则设置======================
//    /**
//     * 分页查询告警规则
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/pageQueryWarnRule", method = RequestMethod.POST)
//    Result<PageInfo<LogWarnRuleDTO>> pageQueryWarnRule(@RequestBody OpenApiReq<LogWarnRuleQueryDTO> openApiReq);
//    /**
//     * 新增告警规则
//     * @param logWarnRuleSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/warn/saveWarnRule", method = RequestMethod.POST)
//    Result<LogWarnRuleDTO> saveWarnRule(@RequestBody LogWarnRuleSaveDTO logWarnRuleSaveDTO);
//    /**
//     * 根据id告警规则
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warn/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//    /**
//     * 根据ids 批量删除文件，ids以","做为分隔符
//     *
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value = "/warn/deleteBatch", method = RequestMethod.GET)
//    Result<Boolean> deleteBatch(@RequestParam(value = "ids") String ids);
//    /**
//     * 查看详情
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warn/get", method = RequestMethod.GET)
//     Result<LogWarnRuleDTO> get(@RequestParam(value = "id") Long id);
//    /**
//     * 修改告警规则
//     * @param logWarnRuleUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/warn/updateWarnRule", method = RequestMethod.POST)
//    Result<Boolean> updateWarnRule(@RequestBody LogWarnRuleUpdateDTO logWarnRuleUpdateDTO);
//
//    /**
//     * 将告警规则设置为启用或禁用
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warn/warnRuleIsAbled", method = RequestMethod.GET)
//    Result<Boolean> warnRuleIsAbled(@RequestParam(value = "id") Long id);
//
//    //========================文件保留设置=================
//    /**
//     * 查看保留设置天数
//     * @return
//     */
//    @RequestMapping(value = "/warn/getSetDay", method = RequestMethod.GET)
//    Result<LogWarnSetDTO> getSetDay();
//    /**
//     * 更新保留设置天数
//     * @return
//     */
//    @RequestMapping(value = "/warn/updateSetDay", method = RequestMethod.POST)
//    Result<LogWarnSetDTO> updateSetDay(@RequestBody LogWarnSetDTO logWarnSetDTO);
//    /**
//     * 恢复默认设置
//     * @return
//     */
//    @RequestMapping(value = "/warn/recover", method = RequestMethod.GET)
//    Result<LogWarnSetDTO> recover();
//
//}

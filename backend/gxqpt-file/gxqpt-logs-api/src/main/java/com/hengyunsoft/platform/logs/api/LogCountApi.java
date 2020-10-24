//package com.hengyunsoft.platform.logs.api;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.logs.api.hystrix.LogCountApiHystrix;
//import com.hengyunsoft.platform.logs.dto.LogNumberAnalysisBaseDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.text.ParseException;
//import java.util.List;
//
///**
// * 日志数据统计API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/logs", fallback = LogCountApiHystrix.class)
//public interface LogCountApi {
//    /**
//     * 用户登录数量统计
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/userLoginQuantity", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getLoginQuantity(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 业务类型分类统计
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/businessClassAccount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getBusinessClassAccount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 日志级别分类统计
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/logLevelAccount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getLogLevelAccount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 获取日志级别数量
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/levelNumberAccount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getLevelNumberAccount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "parentId") String parentId) throws ParseException;
//    /**
//     * 获取日志类型数量占比
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/numberAccount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getNumberAccount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 获取日志类型数量分析
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/numberAnalysis", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getNumberAnalysis(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 获取日志类型响应时间
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/logResponseTime", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getResponseTime(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId, @RequestParam(value = "logType") String logType) throws ParseException;
//    /**
//     * 获取不同等级告警数量
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/warnLevelNumber", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getWarnLevelNumber(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 获取告警数量占比
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/warnLevelAccount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getWarnLevelAccount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 告警类型数量统计
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/warnTypeNumber", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getWarnTypeNumber(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId, @RequestParam(value = "logType") String logType) throws ParseException;
//    /**
//     * 告警类型数量占比
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/warnTypeAccount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getWarnTypeAccount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId) throws ParseException;
//    /**
//     * 热门页面访问次数
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/PageAccess", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getPageAccess(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId, @RequestParam(value = "logType") String logType) throws ParseException;
//    /**
//     * HTTP状态数量
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/HttpStatus", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getHttpStatus(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId, @RequestParam(value = "logType") String logType) throws ParseException;
//    /**
//     * 浏览器类型占比
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/BrowserType", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getBrowserType(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId, @RequestParam(value = "logType") String logType) throws ParseException;
//    /**
//     * 访问PV/UV统计
//     *
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/count/PvToUvCount", method = RequestMethod.POST)
//    Result<List<LogNumberAnalysisBaseDTO>> getPvToUvCount(@RequestParam(value = "startTime") String startTime,@RequestParam(value = "endTime") String endTime, @RequestParam(value = "applyId") String applyId, @RequestParam(value = "logType") String logType) throws ParseException;
//}

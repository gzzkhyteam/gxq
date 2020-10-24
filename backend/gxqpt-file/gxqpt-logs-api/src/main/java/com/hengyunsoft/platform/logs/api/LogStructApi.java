//package com.hengyunsoft.platform.logs.api;
//
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.hystrix.LogStructApiHystrix;
//import com.hengyunsoft.platform.logs.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * 日志文件API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/logs", fallback = LogStructApiHystrix.class)
//public interface LogStructApi {
//    //===============================app===================================
//    /**
//     * 分页查询应用系统结构化日志列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/log/pageQueryApp", method = RequestMethod.POST)
//    Result<PageInfo<LogStructAppDTO>> pageQueryApp(@RequestBody OpenApiReq<LogStructAppQueryDTO> openApiReq);
//    /**
//     * 根据id 查看应用系统详情
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/getApp", method = RequestMethod.GET)
//    Result<LogStructAppDTO> getApp(@RequestParam(value = "id") Long id);
//    /**
//     * 根据id 删除结构化应用系统日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/deleteApp", method = RequestMethod.GET)
//    Result<Boolean> deleteApp(@RequestParam(value = "id") Long id);
//
//
//    //===============================apache===================================
//    /**
//     * 分页查询apache结构化日志列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/log/pageQueryApache", method = RequestMethod.POST)
//    Result<PageInfo<LogStructApacheDTO>> pageQueryApache(@RequestBody OpenApiReq<LogStructApacheQueryDTO> openApiReq);
//    /**
//     * 根据id 查看apache结构化数据详情
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/getApache", method = RequestMethod.GET)
//    Result<LogStructApacheDTO> getApache(@RequestParam(value = "id") Long id);
//    /**
//     * 根据id 删除apache结构化日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/deleteApache", method = RequestMethod.GET)
//    Result<Boolean> deleteApache(@RequestParam(value = "id") Long id);
//
//    //===============================nginx===================================
//    /**
//     * 分页查询nginx结构化日志列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/log/pageQueryNginx", method = RequestMethod.POST)
//    Result<PageInfo<LogStructNginxDTO>> pageQueryNginx(@RequestBody OpenApiReq<LogStructNginxQueryDTO> openApiReq);
//    /**
//     * 根据id 查看nginx结构化数据详情
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/getNginx", method = RequestMethod.GET)
//    Result<LogStructNginxDTO> getNginx(@RequestParam(value = "id") Long id);
//    /**
//     * 根据id 删除nginx结构化日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/deleteNginx", method = RequestMethod.GET)
//    Result<Boolean> deleteNginx(@RequestParam(value = "id") Long id);
//
//    //===============================tomcat===================================
//    /**
//     * 分页查询tomcat结构化日志
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/log/pageQueryTomcat", method = RequestMethod.POST)
//    Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcat(@RequestBody OpenApiReq<LogStructTomcatQueryDTO> openApiReq);
//    /**
//     * 根据id 查看Tomcat结构化数据详情
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/getTomcat", method = RequestMethod.GET)
//    Result<LogStructTomcatDTO> getTomcat(@RequestParam(value = "id") Long id);
//    /**
//     * 根据id 删除nginx结构化日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/log/deleteTomcat", method = RequestMethod.GET)
//    Result<Boolean> deleteTomcat(@RequestParam(value = "id") Long id);
//
//    //===============================together 日志聚合===================================
//    /**
//     * 分页查询app、apache、tomcat、Nginx结构化日志列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/log/pageQueryTogether", method = RequestMethod.POST)
//    Result<PageInfo<LogStructTogetherDTO>> pageQueryTogether(@RequestBody OpenApiReq<LogStructTogetherQueryDTO> openApiReq);
//
//}

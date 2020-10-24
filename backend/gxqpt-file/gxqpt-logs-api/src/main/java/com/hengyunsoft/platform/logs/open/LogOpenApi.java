//package com.hengyunsoft.platform.logs.open;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.dto.*;
//import com.hengyunsoft.platform.logs.open.hystrix.LogOpenApiHystrix;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/logs", fallback = LogOpenApiHystrix.class)
//public interface LogOpenApi {
//    /**
//     * 实时写入应用系统日志
//     */
//    @RequestMapping(value = "/p/log/write", method = RequestMethod.POST)
//    Result<LogStructAppOpenDTO> write(@RequestBody LogStructAppOpenDTO logStructAppOpenDTO);
//    /**
//     * 日志文件上传
//     */
//    @RequestMapping(value = "/p/log/upload", method = RequestMethod.POST)
//    Result<Boolean> upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "logType") String logType);
//    /**
//     * 日志文档查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/p/log/pageQuery", method = RequestMethod.POST)
//    Result<PageInfo<LogFileDTO>> pageQuery(@RequestBody OpenApiReq<LogFileOpenQueryDTO> openApiReq);
//    /**
//     * 应用系统日志查询
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/p/log/log/pageQueryApp", method = RequestMethod.POST)
//    Result<PageInfo<LogStructAppDTO>> pageQueryApp(@RequestBody OpenApiReq<LogStructAppOpenQueryDTO> openApiReq);
//    /**
//     * Apache日志查询
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/p/log/pageQueryApache", method = RequestMethod.POST)
//    Result<PageInfo<LogStructApacheDTO>> pageQueryApache(@RequestBody OpenApiReq<LogStructApacheOpenQueryDTO> openApiReq);
//    /**
//     * Nginx日志查询
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/p/log/pageQueryNginx", method = RequestMethod.POST)
//    Result<PageInfo<LogStructNginxDTO>> pageQueryNginx(@RequestBody OpenApiReq<LogStructNginxOpenQueryDTO> openApiReq);
//    /**
//     * tomcat日志查询
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/p/log/pageQueryTomcat", method = RequestMethod.POST)
//    Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcat(@RequestBody OpenApiReq<LogStructTomcatOpenQueryDTO> openApiReq);
//
//    /**
//     * 删除全部日志
//     * @param logDelDTO
//     * @return
//     */
//    @RequestMapping(value = "/p/log/delAllLog", method = RequestMethod.POST)
//    Result<Boolean> delAllLog(@RequestBody LogDelDTO logDelDTO);
//
//    /**
//     * 删除指定应用系统指定时间的应用系统日志
//     * @param logDelDTO
//     * @return
//     */
//    @RequestMapping(value = "/p/log/delAppLog", method = RequestMethod.POST)
//    Result<Boolean> delAppLog(@RequestBody LogDelDTO logDelDTO);
//    /**
//     * 删除指定应用系统指定时间的apache日志
//     * @param logDelDTO
//     * @return
//     */
//    @RequestMapping(value = "/p/log/delApacheLog", method = RequestMethod.POST)
//    Result<Boolean> delApacheLog(@RequestBody LogDelDTO logDelDTO);
//    /**
//     * 删除指定应用系统指定时间的nginx日志
//     * @param logDelDTO
//     * @return
//     */
//    @RequestMapping(value = "/p/log/delNginxLog", method = RequestMethod.POST)
//    Result<Boolean> delNginxLog(@RequestBody LogDelDTO logDelDTO);
//    /**
//     * 删除指定应用系统指定时间的tomcat日志
//     * @param logDelDTO
//     * @return
//     */
//    @RequestMapping(value = "/p/log/delTomcatLog", method = RequestMethod.POST)
//    Result<Boolean> delTomcatLog(@RequestBody LogDelDTO logDelDTO);
//    /**
//     * 按文件id删除，多个id用“,”隔开
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value = "/p/log/delLogFileByIds", method = RequestMethod.POST)
//    Result<Boolean> delLogFileByIds(@RequestParam(value = "ids") String ids);
//
//}

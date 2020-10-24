//package com.hengyunsoft.platform.logs.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.hystrix.LogFileApiHystrix;
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
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/logs", fallback = LogFileApiHystrix.class)
//public interface LogFileApi {
//    /**
//     * 日志采集模块：导入日志文档分页查询
//     * 查询默认值data_channel=‘UPLOAD’
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/file/pageQueryUpload", method = RequestMethod.POST)
//    Result<PageInfo<LogFileDTO>> pageQueryUpload(@RequestBody OpenApiReq<LogFileQueryDTO> openApiReq);
//    /**
//     * 预览应用系统日志
//     */
//    @RequestMapping(value = "/file/pageQueryAppList", method = RequestMethod.POST)
//    Result<PageInfo< LogStructAppDTO>> pageQueryAppList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq);
//
//    /**
//     * 预览Apache日志
//     */
//     @RequestMapping(value = "/file/pageQueryApacheList", method = RequestMethod.POST)
//     Result<PageInfo< LogStructApacheDTO>> pageQueryApacheList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq);
//
//    /**
//     * 预览Nginx日志
//     */
//     @RequestMapping(value = "/file/pageQueryNginxList", method = RequestMethod.POST)
//     Result<PageInfo< LogStructNginxDTO>> pageQueryNginxList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq);
//
//     /**
//      * 预览Tomcat日志
//      */
//     @RequestMapping(value = "/file/pageQueryTomcatList", method = RequestMethod.POST)
//     Result<PageInfo<LogStructTomcatDTO>> pageQueryTomcatList(@RequestBody OpenApiReq<LogFileQueryStructByIdDTO> openApiReq);
//    /**
//     * 保存日志文件
//     *
//     * @param
//     */
//    @RequestMapping(value = "/file/save", method = RequestMethod.POST)
//    Result<LogFileDTO> save(@RequestBody LogFileSaveDTO logFilesSaveDTO);
//
//    /**
//     * 日志文档分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/file/pageQuery", method = RequestMethod.POST)
//    Result<PageInfo<LogFileDTO>> pageQuery(@RequestBody OpenApiReq<LogFileQueryDTO> openApiReq);
//
//    /**
//     * 日志文件解析（执行该方法场景：当文件状态是未解析时
//     * 如果某种操作可能出问题了，只在表LOG_FILE中插入了一条数据，而没有往LOG_FILE_INTERFACE表中插入数据，这时候
//     * 将需要往log_file_interface表中插入一条数据）
//     *
//     * @param
//     */
//    @RequestMapping(value = "/file/parse", method = RequestMethod.GET)
//    Result<LogFileDTO> saveFileInterface(@RequestParam(value = "id") Long id);
//    /**
//     * 当文件状态是已失效时
//     * 日志文件重新解析（执行该方法场景：当设定结构化的日志保留时间之前的数据被删除了，但是日志文件还存在，如果想看被删除的结构化日志，需要操作重新解析
//     * 删除结构化日志后，将对应的log_file_interface表中的 is_delete_struct 状态设为1。说明该记录对应的文件已被解析过，但是结构化的数据已被删除
//     * 本方法执行的方法是重新解析：将需要重新解析的文析修改log_file_interface表的is_delete_struct 状态设为0）
//     *
//     * @param
//     */
//    @RequestMapping(value = "/file/reParse", method = RequestMethod.GET)
//    Result<Boolean> updateFileInterface(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据id 删除文件
//     * 根据log_file表中的id 删除log_file 和表 log_file_interface中的记录
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/file/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据ids 批量删除文件，ids以","做为分隔符
//     * 根据log_file表中的id 删除log_file 和表 log_file_interface中的记录
//     *
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value = "/file/deleteBatch", method = RequestMethod.GET)
//    Result<Boolean> deleteBatch(@RequestParam(value = "ids") String ids);
//
//}

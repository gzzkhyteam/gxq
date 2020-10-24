//package com.hengyunsoft.platform.logs.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.logs.api.hystrix.LogFileApiHystrix;
//import com.hengyunsoft.platform.logs.api.hystrix.LogSetApiHystrix;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetDTO;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetQueryDTO;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetSaveDTO;
//import com.hengyunsoft.platform.logs.dto.LogPatternSetUpdateDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * 日志文件配置
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/logs", fallback = LogSetApiHystrix.class)
//public interface LogSetApi {
//    /**
//     * 日志格式查询
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/set/pageQueryPattern", method = RequestMethod.POST)
//    Result<PageInfo<LogPatternSetDTO>> pageQueryPattern(@RequestBody OpenApiReq<LogPatternSetQueryDTO> openApiReq);
//    /**
//     * 保存日志格式
//     *
//     * @param
//     */
//    @RequestMapping(value = "/set/save", method = RequestMethod.POST)
//    Result<LogPatternSetDTO> save(@RequestBody LogPatternSetSaveDTO logPatternSetSaveDTO);
//    /**
//     * 更新日志格式
//     * @return
//     */
//    @RequestMapping(value = "/set/updatePattern", method = RequestMethod.POST)
//    Result<Boolean> updateSetDay(@RequestBody LogPatternSetUpdateDTO logPatternSetUpdateDTO);
//    /**
//     * 根据id 删除文件设置
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/set/delete", method = RequestMethod.GET)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据ids 批量删除文件格式设置，ids以","做为分隔符
//     *
//     * @param ids
//     * @return
//     */
//    @RequestMapping(value = "/set/deleteBatch", method = RequestMethod.GET)
//    Result<Boolean> deleteBatch(@RequestParam(value = "ids") String ids);
//
//    /**
//     * 根据ID查询记录
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/set/get", method = RequestMethod.GET)
//    Result<LogPatternSetDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 根据appId和logType查询日志格式是否存在
//     *
//     * @param logPatternSetSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/set/isExist", method = RequestMethod.POST)
//    Result<Integer> isExist(@RequestBody LogPatternSetSaveDTO logPatternSetSaveDTO);
//
//}

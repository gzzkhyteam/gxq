//package com.hengyunsoft.platform.mt.api.work.api;
//
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.work.api.hystrix.WorkLogApiHystrix;
//import com.hengyunsoft.platform.mt.api.work.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * @author tianai
// * @createTime 2018-05-27
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/mt", fallback = WorkLogApiHystrix.class)
//public interface WorkLogApi {
//    /**
//     * 查询工作日志分页信息
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/work/page", method = RequestMethod.POST)
//    Result<PageInfo<WorkLogPageDTO>> page(@RequestBody OpenApiReq<WorkLogPageReqDTO> openApiReq);
//
//    /**
//     * 根据用户id,查询工作日志分页信息（AAP端）
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/work/pageApp", method = RequestMethod.POST)
//    Result<PageInfo<WorkLogDTO>> pageApp(@RequestBody OpenApiReq<WorkLogAppPageReqDTO> openApiReq);
//
//    /**
//     * 查询工作日志信息(List)
//     *
//     * @param
//     * @return List<WorkLogCountDTO>
//     */
//    @RequestMapping(value = "/work/getList", method = RequestMethod.GET)
//    Result<List<WorkLogCountDTO>> getList(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "deptId") String deptId, @RequestParam(value = "name") String name);
//
//
//    /**
//     * 保存工作日志信息
//     *
//     * @param workLogSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/work/save", method = RequestMethod.POST)
//    Result<WorkLogSaveDTO> save(@RequestBody WorkLogSaveDTO workLogSaveDTO);
//
//
//    /**
//     * 根据用户id查询工作日志信息(List)
//     *
//     * @param userId
//     * @return List<WorkLogDTO>
//     */
//    @RequestMapping(value = "/work/findByUserId", method = RequestMethod.GET)
//    Result<List<WorkLogDTO>> findByUserId(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "userId") Long userId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime") String endTime);
//
//    /**
//     * 根据id查询工作日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/work/get", method = RequestMethod.GET)
//    Result<WorkLogDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 删除工作日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/work/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//
//
//    /**
//     * 保存工作日志回复信息
//     *
//     * @param workLogAnswerSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/work/saveAnswer", method = RequestMethod.POST)
//    Result<WorkLogAnswerSaveDTO> saveAnswer(@RequestBody WorkLogAnswerSaveDTO workLogAnswerSaveDTO);
//
//
//    /**
//     * 根据用户id查询可以查看的工作日志信息(APP端)
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/work/lookPage", method = RequestMethod.GET)
//    Result<PageInfo<WorkLogDTO>> lookPage(@RequestBody OpenApiReq<WorkLogAppPageReqDTO> openApiReq);
//
//    /**
//     * 根据日志id查询相应的回复信息
//     *
//     * @param workLogId
//     * @return
//     */
//    @RequestMapping(value = "/work/getAnswerList", method = RequestMethod.GET)
//    Result<List<WorkLogAnswerDTO>> getAnswerList(@RequestParam(value = "workLogId") Long workLogId);
//
//    /**
//     * 根据日志的用户id查询相应的可查看人信息
//     *
//     * @param userId
//     * @return
//     */
//    @RequestMapping(value = "/work/getAuthorityList", method = RequestMethod.GET)
//    Result<List<WorkLogLookDTO>> getAuthorityList(@RequestParam(value = "unitId") String unitId, @RequestParam(value = "userId") Long userId);
//
//
//    /**
//     * 保存已查看工作日志信息
//     *
//     * @param workLogLookSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/work/workLogLook", method = RequestMethod.POST)
//    Result<WorkLogLookSaveDTO> workLogLook(@RequestBody WorkLogLookSaveDTO workLogLookSaveDTO);
//
//    /**
//     * 根据id查询工作日志信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/work/getDetail", method = RequestMethod.GET)
//    Result<WorkLogDetailDTO> getDetail(@RequestParam(value = "id") Long id);
//
//    /**
//     * 修改工作日志详情信息
//     *
//     * @param workLogDetailDTO
//     * @return
//     */
//    @RequestMapping(value = "/work/updateDetail", method = RequestMethod.POST)
//    Result<WorkLogDetailDTO> updateDetail(@RequestBody WorkLogDetailDTO workLogDetailDTO);
//
//
//    /**
//     * 根据工作日志logId查询已查看或未查看人信息
//     *
//     * @param logId
//     * @return
//     */
//    @RequestMapping(value = "/work/getLookUser", method = RequestMethod.GET)
//    Result<List<WorkLogLookDTO>> getLookUser(@RequestParam(value = "logId") Long logId, @RequestParam(value = "status") Integer status);
//
//    /***
//     *查询用户当前月写了多少日志
//     * @return
//     */
//    @RequestMapping(value = "/getMonthCount", method = RequestMethod.GET)
//    Result<Integer> getMonthCount();
//}

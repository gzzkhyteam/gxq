//package com.hengyunsoft.platform.warn.api.warn.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warn.dto.*;
//import com.hengyunsoft.platform.warn.api.warn.api.hystrix.GxqptWarnApiHystrix;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author zjr
// * @date 2018/03/28
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", fallback = GxqptWarnApiHystrix.class,
//path = "/api/warn")
//public interface GxqptWarnApi {
//    /**
//     * 根据id获取预警信息
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warn/getById", method = RequestMethod.GET)
//    Result<Map<String,Object>> getById(@RequestParam(value="id")Long id);
//
//    /**
//     * 根据id获取确认人信息
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warn/getConById", method = RequestMethod.GET)
//    Result<List<GxqptSendeeDTO>> getConById(@RequestParam(value="id")Long id);
//    /**
//     * 根据id获取责任人信息
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/warn/getHanById", method = RequestMethod.GET)
//    Result<List<GxqptSendeeDTO>> getHanById(@RequestParam(value="id")Long id);
//    /**
//     * 获取分页列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warn/findWarnList", method = RequestMethod.POST)
//    Result<PageInfo<GxqptWarnPagingDTO>> findWarnList(@RequestBody OpenApiReq<QueryWarnDTO> openApiReq);
//
//    /**
//     * 根据预警id查询预警责任人人
//     * @return
//     */
//    @RequestMapping(value = "/warn/getDutyer", method = RequestMethod.GET)
//    Result<DutyerDTO> getDutyer(@RequestParam(value = "warnId") Long warnId);
//
//    /**
//     * 根据ID确认预警信息
//     * @param UpdateModeGxqptWarnDTO
//     * @return
//     */
//    @RequestMapping(value = "/warn/updateModeById", method = RequestMethod.POST)
//    Result<Boolean> updateModeById(@RequestBody ConfirmGxqptWarnDTO updateModeGxqptWarnDto);
//
//    /**
//     * 根据id处理预警信息
//     * @param updateModeGxqptWarnDto
//     * @return
//     */
//    @RequestMapping(value = "/warn/updateHandleById", method = RequestMethod.POST)
//    Result<Boolean> updateHandleById(@RequestBody HandleGxqptWarnDTO handleGxqptWarnDto);
//
//
//}

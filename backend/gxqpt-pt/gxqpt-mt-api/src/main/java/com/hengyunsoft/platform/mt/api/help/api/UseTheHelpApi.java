//package com.hengyunsoft.platform.mt.api.help.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.help.api.hystrix.UseTheHelpHystrix;
//import com.hengyunsoft.platform.mt.api.help.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * @author tianai
// * @createTime 2018-05-27
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/mt", fallback = UseTheHelpHystrix.class)
//public interface UseTheHelpApi {
//    /**
//     * 查询使用帮助分页信息
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/help/page", method = RequestMethod.POST)
//    Result<PageInfo<UseTheHelpDTO>> page(@RequestBody OpenApiReq<UseTheHelpPageReqDTO> openApiReq);
//
//
//    /**
//     * 保存帮助文档信息
//     *
//     * @param useTheHelpSaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/help/save", method = RequestMethod.POST)
//    Result<UseTheHelpSaveDTO> save(@RequestBody UseTheHelpSaveDTO useTheHelpSaveDTO);
//
//    /**
//     * 修改帮助文档信息
//     *
//     * @param useTheHelpUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/help/update", method = RequestMethod.POST)
//    Result<UseTheHelpUpdateDTO> update(@RequestBody UseTheHelpUpdateDTO useTheHelpUpdateDTO);
//
//    /**
//     * 审核帮助文档信息
//     *
//     * @param useTheHelpUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/help/audit", method = RequestMethod.POST)
//    Result<UseTheHelpUpdateDTO> audit(@RequestBody UseTheHelpUpdateDTO useTheHelpUpdateDTO);
//
//
//    /**
//     * 弃审帮助文档信息
//     *
//     * @param useTheHelpUpdateDTO
//     * @return
//     */
//    @RequestMapping(value = "/help/ discardAudit", method = RequestMethod.POST)
//    Result<UseTheHelpUpdateDTO> discardAudit(@RequestBody UseTheHelpUpdateDTO useTheHelpUpdateDTO);
//
//
//    /**
//     * 根据id查询帮助文档信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/help/get", method = RequestMethod.GET)
//    Result<UseTheHelpDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 删除帮助文档信息
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/help/delete", method = RequestMethod.POST)
//    Result<Boolean> delete(@RequestParam(value = "id") Long id);
//}

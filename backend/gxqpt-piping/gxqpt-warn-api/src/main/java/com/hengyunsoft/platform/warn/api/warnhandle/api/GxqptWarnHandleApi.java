//package com.hengyunsoft.platform.warn.api.warnhandle.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warnhandle.api.hystrix.GxqptWarnHandleApiHystrix;
//import com.hengyunsoft.platform.warn.api.warnhandle.dto.GxqptWarnHandlePagingDTO;
//import com.hengyunsoft.platform.warn.api.warnhandle.dto.QueryWarnHandleDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
///**
// * 预警处理台账接口
// * @author zjr
// * @date 2018/06/29
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", fallback = GxqptWarnHandleApiHystrix.class,
//path = "/api/warn")
//public interface GxqptWarnHandleApi {
//
//    /**
//     * 获取分页列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warnhandle/findWarnHandleList", method = RequestMethod.POST)
//    Result<PageInfo<GxqptWarnHandlePagingDTO>> findWarnHandleList(@RequestBody OpenApiReq<QueryWarnHandleDTO> openApiReq);
//
//}

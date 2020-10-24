//package com.hengyunsoft.platform.warn.api.warnresult.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warnresult.api.hystrix.GxqptWarnResultApiHystrix;
//import com.hengyunsoft.platform.warn.api.warnresult.dto.GxqptWarnResultPagingDTO;
//import com.hengyunsoft.platform.warn.api.warnresult.dto.QueryWarnResultDTO;
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
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", fallback = GxqptWarnResultApiHystrix.class,
//path = "/api/warn")
//public interface GxqptWarnResultApi {
//
//    /**
//     * 获取分页列表
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/warnresult/findWarnResultList", method = RequestMethod.POST)
//    Result<PageInfo<GxqptWarnResultPagingDTO>> findWarnResultList(@RequestBody OpenApiReq<QueryWarnResultDTO> openApiReq);
//
//}

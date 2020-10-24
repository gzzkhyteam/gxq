//package com.hengyunsoft.platform.warn.api.warnresult.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warnresult.api.GxqptWarnResultApi;
//import com.hengyunsoft.platform.warn.api.warnresult.dto.GxqptWarnResultPagingDTO;
//import com.hengyunsoft.platform.warn.api.warnresult.dto.QueryWarnResultDTO;
//import org.springframework.stereotype.Component;
//
///**
// * 描述:熔断实现默认响应超时
// * @author zjr
// * @date 2018/06/29
// * @return
// */
//@Component
//public class GxqptWarnResultApiHystrix implements GxqptWarnResultApi {
//
//    /**
//     * 获取分页列表
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<GxqptWarnResultPagingDTO>> findWarnResultList(OpenApiReq<QueryWarnResultDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//}

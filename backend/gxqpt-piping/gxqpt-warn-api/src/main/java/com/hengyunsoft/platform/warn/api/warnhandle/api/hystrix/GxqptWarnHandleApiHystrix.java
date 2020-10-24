//package com.hengyunsoft.platform.warn.api.warnhandle.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.warn.api.warnhandle.api.GxqptWarnHandleApi;
//import com.hengyunsoft.platform.warn.api.warnhandle.dto.GxqptWarnHandlePagingDTO;
//import com.hengyunsoft.platform.warn.api.warnhandle.dto.QueryWarnHandleDTO;
//import org.springframework.stereotype.Component;
//
///**
// * 描述:熔断实现默认响应超时
// * @author zjr
// * @date 2018/06/29
// * @return
// */
//@Component
//public class GxqptWarnHandleApiHystrix implements GxqptWarnHandleApi {
//
//    /**
//     * 获取分页列表
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<GxqptWarnHandlePagingDTO>> findWarnHandleList(OpenApiReq<QueryWarnHandleDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//}

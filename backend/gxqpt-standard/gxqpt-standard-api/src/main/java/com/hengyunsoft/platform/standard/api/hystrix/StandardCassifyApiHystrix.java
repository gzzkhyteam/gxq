//package com.hengyunsoft.platform.standard.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.standard.api.StandardClassifyApi;
//import com.hengyunsoft.platform.standard.dto.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// */
//
//@Component
//public class StandardCassifyApiHystrix implements StandardClassifyApi {
//
//    @Override
//    public Result<StandardClassifyDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<StandardClassifyDTO> save(StandardClassifySaveDTO standardClassifySaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> update(StandardClassifyUpdateDTO standardClassifyUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<StandardClassifyTreeDTO>> getTree(@RequestParam(value = "id") Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<StandardClassifyTreeDTO>> getYunWeiTree() {
//        return Result.timeout();
//    }
//}

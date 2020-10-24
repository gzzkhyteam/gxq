//package com.hengyunsoft.platform.exchange.api.directory.api.Hystrix;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.exchange.api.directory.api.ShareDataElementApi;
//import com.hengyunsoft.platform.exchange.api.directory.dto.element.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
///**
// * feign 熔断机制的实现， 默认返回超时响应
// * @author tianai
// * @createTime 2018-04-21
// */
//@Component
//public class ShareDataElementApiHystrix implements ShareDataElementApi {
//    @Override
//    public Result<List<DataElementListDTO>> getList(Long dirId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataElementDTO> save(DataElementSaveDTO dataElementSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> update(DataElementUpdateDTO dataElementUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataElementDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<DataElementDTO> getElementWare(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataElementCopyDTO>> getElementChangeList(String applyCode) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<List<DataElementCopyDTO>> getElementChangeListApply(String unitId, Integer status) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> disable(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> enable(Long id) {
//        return Result.timeout();
//    }
//}

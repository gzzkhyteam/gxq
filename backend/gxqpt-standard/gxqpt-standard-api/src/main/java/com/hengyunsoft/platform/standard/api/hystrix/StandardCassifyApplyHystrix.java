//package com.hengyunsoft.platform.standard.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.standard.api.StandardClassifyApi;
//import com.hengyunsoft.platform.standard.api.StandardClassifyApplyApi;
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
//public class StandardCassifyApplyHystrix implements StandardClassifyApplyApi {
//
//
//    /**
//     * 根据id 查看分类申请详情
//     *
//     * @param id
//     * @return
//     */
//    @Override
//    public Result<StandardClassifyApplyDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    /**
//     * 保存标准分类申请信息
//     *
//     * @param standardClassifyApplySaveDTO
//     * @return
//     */
//    @Override
//    public Result<StandardClassifyApplyDTO> save(StandardClassifyApplySaveDTO standardClassifyApplySaveDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 通过标准分类申请信息
//     *
//     * @param standardClassifyApplyDealDTO
//     */
//    @Override
//    public Result<Boolean> pass(StandardClassifyApplyDealDTO standardClassifyApplyDealDTO) {
//        return null;
//    }
//
//    /**
//     * 驳回标准分类申请信息
//     *
//     * @param standardClassifyApplyDealDTO
//     */
//    @Override
//    public Result<Boolean> reject(StandardClassifyApplyDealDTO standardClassifyApplyDealDTO) {
//        return null;
//    }
//
//    /**
//     * 标准分类申请信息分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<StandardClassifyApplyDTO>> pageMyApply(OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 标准分类申请已办事项分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<StandardClassifyApplyDTO>> pageDone(OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 标准分类申请待办事项分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @Override
//    public Result<PageInfo<StandardClassifyApplyDTO>> pageToDo(OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//}
//

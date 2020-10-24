//package com.hengyunsoft.platform.modular.api.hystrix;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.modular.api.ModularCategoryAndTagApi;
//import com.hengyunsoft.platform.modular.dto.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author wangs
// * @createTime 2018-4-5
// */
//@Component
//public class ModularCategoryAndTagApiHystrix implements ModularCategoryAndTagApi {
//
//    /**
//     * 保存模块申请信息
//     * @param modularCategoryAndTagApplySaveDTO
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<ModularCategoryAndTagApplyDTO> save(ModularCategoryAndTagApplySaveDTO modularCategoryAndTagApplySaveDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 通过模块申请信息
//     * @param modularCategoryAndTagApplyDealDTO
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<Boolean> pass(ModularCategoryAndTagApplyDealDTO modularCategoryAndTagApplyDealDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 驳回模块申请信息
//     * @param modularCategoryAndTagApplyDealDTO
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<Boolean> reject(ModularCategoryAndTagApplyDealDTO modularCategoryAndTagApplyDealDTO) {
//        return Result.timeout();
//    }
//
//    /**
//     * 模块申请信息分页查询
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageApply(OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 模块申请已办事项分页查询
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageDone(OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 模块申请待办事项分页查询
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageToDo(OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    /**
//     * 分类列表查询
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<List<MdCategoryDefDTO>> findCategoryDef() {
//        return Result.timeout();
//    }
//
//    /**
//     * 标签列表查询
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @Override
//    public Result<List<MdTagDefDTO>> findTagDef() {
//        return Result.timeout();
//    }
//}

//package com.hengyunsoft.platform.modular.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.commons.config.FeignConfiguration;
//import com.hengyunsoft.platform.modular.api.hystrix.ModularCategoryAndTagApiHystrix;
//import com.hengyunsoft.platform.modular.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import java.util.List;
//
///**
// * @author wangs
// * @createTime 2018-4-5
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}",configuration = FeignConfiguration.class, path = "/api/modular", fallback = ModularCategoryAndTagApiHystrix.class)
//public interface ModularCategoryAndTagApi {
//
//    /**
//     * 保存模块申请信息
//     * @param modularCategoryAndTagApplySaveDTO
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/mdapply/save", method = RequestMethod.POST)
//    Result<ModularCategoryAndTagApplyDTO> save(@RequestBody ModularCategoryAndTagApplySaveDTO modularCategoryAndTagApplySaveDTO);
//
//    /**
//     * 通过模块申请信息
//     * @param modularCategoryAndTagApplyDealDTO
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/mdapply/pass", method = RequestMethod.POST)
//    Result<Boolean> pass(@RequestBody ModularCategoryAndTagApplyDealDTO modularCategoryAndTagApplyDealDTO);
//
//    /**
//     * 驳回模块申请信息
//     * @param modularCategoryAndTagApplyDealDTO
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/mdapply/reject", method = RequestMethod.POST)
//    Result<Boolean> reject(@RequestBody ModularCategoryAndTagApplyDealDTO modularCategoryAndTagApplyDealDTO);
//
//    /**
//     * 模块申请信息分页查询
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/mdapply/pageApply", method = RequestMethod.POST)
//    Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageApply(@RequestBody OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq);
//
//    /**
//     * 模块申请已办事项分页查询
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/mdapply/pageDone", method = RequestMethod.POST)
//    Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageDone(@RequestBody OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq);
//
//    /**
//     * 模块申请待办事项分页查询
//     * @param openApiReq
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/mdapply/pageToDo", method = RequestMethod.POST)
//    Result<PageInfo<ModularCategoryAndTagApplyDTO>> pageToDo(@RequestBody OpenApiReq<ModularCategoryAndTagApplyQueryDTO> openApiReq);
//
//    /**
//     * 分类列表查询
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/category/findCategoryDef", method = RequestMethod.POST)
//    Result<List<MdCategoryDefDTO>> findCategoryDef();
//
//    /**
//     * 标签列表查询
//     * @createTime 2018-4-5
//     * @author wangs
//     */
//    @RequestMapping(value = "/tag/findTagDef", method = RequestMethod.POST)
//    Result<List<MdTagDefDTO>> findTagDef();
//
//}

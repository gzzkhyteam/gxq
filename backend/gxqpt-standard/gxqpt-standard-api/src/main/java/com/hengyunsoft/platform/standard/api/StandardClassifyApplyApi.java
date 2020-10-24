//package com.hengyunsoft.platform.standard.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//
//
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.standard.api.hystrix.StandardCassifyApiHystrix;
//import com.hengyunsoft.platform.standard.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * 标准分类申请API接口
// * fallback: 实现服务降级处理逻辑。
// * 调用过程中，出现错误、超时、线程池拒绝、断路器熔断等情况时，执行fallback中的方法
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gaxq-gate-server}", path = "/api/standard", fallback = StandardCassifyApiHystrix.class)
//public interface StandardClassifyApplyApi {
//
//    /**
//     * 根据id 查看分类申请详情
//     *
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/apply/get", method = RequestMethod.GET)
//    Result<StandardClassifyApplyDTO> get(@RequestParam(value = "id") Long id);
//
//    /**
//     * 保存标准分类申请信息
//     *
//     * @param standardClassifyApplySaveDTO
//     * @return
//     */
//    @RequestMapping(value = "/apply/save", method = RequestMethod.POST)
//    Result<StandardClassifyApplyDTO> save(@RequestBody StandardClassifyApplySaveDTO standardClassifyApplySaveDTO);
//
//    /**
//     * 通过标准分类申请信息
//     *
//     * @param
//     */
//    @RequestMapping(value = "/apply/pass", method = RequestMethod.POST)
//    Result<Boolean> pass(@RequestBody StandardClassifyApplyDealDTO standardClassifyApplyDealDTO);
//
//    /**
//     * 驳回标准分类申请信息
//     *
//     * @param
//     */
//    @RequestMapping(value = "/apply/reject", method = RequestMethod.POST)
//    Result<Boolean> reject(@RequestBody StandardClassifyApplyDealDTO standardClassifyApplyDealDTO);
//
//    /**
//     * 标准分类申请信息分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/apply/pageMyApply", method = RequestMethod.POST)
//    Result<PageInfo<StandardClassifyApplyDTO>> pageMyApply(@RequestBody OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq);
//
//    /**
//     * 标准分类申请已办事项分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/apply/pageDone", method = RequestMethod.POST)
//    Result<PageInfo<StandardClassifyApplyDTO>> pageDone(@RequestBody OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq);
//
//    /**
//     * 标准分类申请待办事项分页查询
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/apply/pageToDo", method = RequestMethod.POST)
//    Result<PageInfo<StandardClassifyApplyDTO>> pageToDo(@RequestBody OpenApiReq<StandardClassifyApplyQueryDTO> openApiReq);
//
//}

//package com.hengyunsoft.platform.mt.api.appr.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.appr.api.hystrix.ApprApplyApiHystrix;
//import com.hengyunsoft.platform.mt.api.appr.dto.*;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * 描述：考勤流程
// *
// * @author gbl
// * @date 2018/7/9
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/", fallback = ApprApplyApiHystrix.class)
//public interface ApprApplyApi {
//    /**
//     * 描述：web端分页查询申请列表
//     * 参数：[openApiReq]
//     * 返回值：com.hengyunsoft.base.Result<com.github.pagehelper.PageInfo<com.hengyunsoft.platform.mt.api.appr.dto.ApprApplyDTO>>
//     * 修改人：gbl
//     * 修改时间：2018/7/10
//     * 修改内容：
//     */
//    @RequestMapping(value = "findApprApplyPage", method = RequestMethod.POST)
//    Result<PageInfo<ApprApplyDTO>> findApprApplyPage(OpenApiReq<QueryApprApplyParamDTO> openApiReq);
//
//
//    /**
//     * 描述：查询当前待我审批或者查询我审批过的的列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/10
//     * 修改内容：
//     */
//    @RequestMapping(value = "findPageCurSendMeApplyList", method = RequestMethod.POST)
//    Result<PageInfo<ApprApplyDTO>> findPageCurSendMeApplyList(OpenApiReq<QueryApprApplyParamDTO> openApiReq);
//
//    /**
//     * 描述：处理审批请求
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/10
//     * 修改内容：
//     */
//    @RequestMapping(value = "dealApprApply", method = RequestMethod.GET)
//    Result<Boolean> dealApprApply(@RequestParam("applyId") Long applyId, @RequestParam("agree") Integer agree, @RequestParam("apprOpinion") String apprOpinion);
//
//    /**
//     * 描述：撤销申请
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/13
//     * 修改内容：
//     */
//    @RequestMapping(value = "cancellApprApply", method = RequestMethod.POST)
//    Result<Boolean> cancellApprApply(@RequestBody CancellApprAppDTO dto);
//
//    /**
//     * 描述：提交考勤审批
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/11
//     * 修改内容：
//     */
//    @RequestMapping(value = "createApprApply", method = RequestMethod.POST)
//    Result<Boolean> createApprApply(@RequestBody CreateApprApplyDTO dto);
//
//    /**
//     * 描述：查看审批详情
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/11
//     * 修改内容：
//     */
//    @RequestMapping(value = "getApprApplyInfo", method = RequestMethod.GET)
//    Result<ApprApplyInfoDTO> getApprApplyInfo(@RequestParam("id") Long id);
//
//    /**
//     * 描述：查询默认审批人
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/7/12
//     * 修改内容：
//     */
//    @RequestMapping(value = "getDefaultPerson", method = RequestMethod.GET)
//    Result<DefaultPersonDTO> getDefaultPerson(@RequestParam("aprType") String aprType);
//
//    /**
//     * 描述：查询当前待我审批的数量
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/8/7
//     * 修改内容：
//     */
//    @RequestMapping(value = "geCurSendMeCount", method = RequestMethod.GET)
//    Result<Integer> geCurSendMeCount();
//}

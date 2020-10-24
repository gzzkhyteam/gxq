//package com.hengyunsoft.platform.mt.api.feedback.api;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.mt.api.feedback.api.hystrix.FeedBackApiHystrix;
//import com.hengyunsoft.platform.mt.api.feedback.dto.CreateFeedBackDTO;
//import com.hengyunsoft.platform.mt.api.feedback.dto.FeedBackBaseDTO;
//import com.hengyunsoft.platform.mt.api.feedback.dto.FeedBackInfoDTO;
//import com.hengyunsoft.platform.mt.api.feedback.dto.QueryFeedBackParamDTO;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
///**
// * 描述：
// *
// * @author gbl
// * @date 2018/6/22
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}", path = "/api/feedback", fallback = FeedBackApiHystrix.class)
//public interface FeedBackApi {
//    /**
//     * 描述：创建意见反馈
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "createFeedBack", method = RequestMethod.POST)
//    Result<Boolean> createFeedBack(@RequestBody CreateFeedBackDTO dto);
//
//    /**
//     * 描述：分页查询意见反馈列表
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "findList", method = RequestMethod.POST)
//    Result<PageInfo<FeedBackBaseDTO>> findList(@RequestBody OpenApiReq<QueryFeedBackParamDTO> openApiReq);
//
//
//    /**
//     * 描述：查询自己提交的意见反馈
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/23
//     * 修改内容：
//     */
//    @RequestMapping(value = "findMyList", method = RequestMethod.POST)
//    Result<PageInfo<FeedBackBaseDTO>> findMyList(@RequestBody OpenApiReq<QueryFeedBackParamDTO> openApiReq);
//
//    /**
//     * 描述：查询意见详情
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "getFeedBackInfo", method = RequestMethod.POST)
//    Result<FeedBackInfoDTO> getFeedBackInfo(@RequestParam("id") Long id, @RequestParam("isWeb") Boolean isWeb);
//
//    /**
//     * 描述：回复意见反馈
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "replyFeedback", method = RequestMethod.POST)
//    Result<Boolean> replyFeedback(@RequestParam("id") Long id, @RequestParam("isWeb") Boolean isWeb, @RequestParam("context") String context);
//
//    /**
//     * 描述：关闭意见反馈
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/6/22
//     * 修改内容：
//     */
//    @RequestMapping(value = "closeFeedBack", method = RequestMethod.POST)
//    Result<Boolean> closeFeedBack(@RequestParam("id") Long id);
//    /**
//     * 描述：查询未读消息的数量
//     * 参数：
//     * 返回值：
//     * 修改人：gbl
//     * 修改时间：2018/8/7
//     * 修改内容：
//     */
//    @RequestMapping(value = "getMyMsgNotReadCount", method = RequestMethod.GET)
//    Result<Integer> getMyMsgNotReadCount();
//}

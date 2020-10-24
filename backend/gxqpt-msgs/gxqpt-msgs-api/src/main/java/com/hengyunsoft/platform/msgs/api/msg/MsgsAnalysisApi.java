//package com.hengyunsoft.platform.msgs.api.msg;
//
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.msgs.api.msg.hystrix.MsgsAnalysisApiHystrix;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgActiveSendDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAllChannelUsedDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisChannelTypeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisChannelUsedDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisHandleDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisSendErrorDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgAnalysisSendExceptionDTO;
//
///**
// * 统计分析API接口
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/msgs",
//        fallback = MsgsAnalysisApiHystrix.class)
//public interface MsgsAnalysisApi {
//
//    /**
//     * 消息各操作数量统计
//     * @return
//     */
//    @RequestMapping(value = "/analysis/handle", method = RequestMethod.GET)
//    Result<MsgAnalysisHandleDTO> getMsgHandleCount();
//    /**
//     * 个人渠道使用情况
//     * @return
//     */
//    @RequestMapping(value = "/analysis/channel/used", method = RequestMethod.GET)
//    Result<List<MsgAnalysisChannelUsedDTO>> getMsgChannelUsedCount();
//    /**
//     * 个人渠道类型使用占比分析
//     * @return
//     */
//    @RequestMapping(value = "/analysis/personal/channeltype", method = RequestMethod.GET)
//    Result<MsgAnalysisChannelTypeDTO> getMsgPersonalChannelTypeCount();
//    /**
//     * 高新区渠道类型使用占比分析
//     * @return
//     */
//    @RequestMapping(value = "/analysis/all/channeltype", method = RequestMethod.GET)
//    Result<MsgAnalysisChannelTypeDTO> getMsgAllChannelTypeCount();
//    /**
//     * 各类型渠道发送问题TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/senderror/top10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getMsgSendErrorTop10(@RequestParam(value="type") String type);
//    /**
//     * 各渠道类型异常情况分析(近六个月数据)
//     * @return
//     */
//    @RequestMapping(value = "/analysis/send/exception", method = RequestMethod.GET)
//    Result<Map<String,List<MsgAnalysisSendExceptionDTO>>> getMsgSendExceptionCount();
//    /**
//     * 近一年高新区各类型渠道使用发展情况(近12个月)
//     * @return
//     */
//    @RequestMapping(value = "/analysis/allchannel/used", method = RequestMethod.GET)
//    Result<Map<String,List<MsgAllChannelUsedDTO>>> getMsgAllChannelUsedCount();
//    /**
//     * 微信发送问题TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/wechat/top10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getWechatExceptionTop10();
//    /**
//     * 微博发送问题TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/blog/top10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getBlogExceptionTop10();
//    /**
//     * 移动终端发送问题TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/mobile/top10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getMobileExceptionTop10();
//    /**
//     * 公示平台发送问题TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/public/top10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getPublicExceptionTop10();
//    /**
//     * 个人渠道发布商次数TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/publisher/sendtop10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getPublisherSendTop10();
//    /**
//     * 高新区发布商使用次数TOP10
//     * @return
//     */
//    @RequestMapping(value = "/analysis/gxqpt/sendtop10", method = RequestMethod.GET)
//    Result<List<MsgAnalysisSendErrorDTO>> getGxqptSendTop10();
//    /**
//     * 近期发布商活跃情况分析
//     * @return
//     */
//    @RequestMapping(value = "/analysis/active/sendtop10", method = RequestMethod.GET)
//    Result<List<MsgActiveSendDTO>> getActivePublisherSendCount(@RequestParam(value="appId") String appId);
// }
//

//package com.hengyunsoft.platform.msgs.api.msg;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.api.msg.hystrix.MsgsPublisherApiHystrix;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsBackListDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsBackListRequestDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessagePublisherDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.PublisherBlackListDTO;
///**
// * 发布商管理
// * @author dxz
// */
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/msgs",
//fallback = MsgsPublisherApiHystrix.class)
//public interface MsgsPublisherApi {
//
//	/**
//	 * 发布人拉黑/取消拉黑
//	 * @param publisherBlackListDTO
//	 * @return
//	 */
//    @RequestMapping(value = "/publisher/msg/pullblack", method = RequestMethod.POST)
//    Result<Boolean> savePublisherPullblack(@RequestBody PublisherBlackListDTO publisherBlackListDTO);
//	/**
//	 * 根据channelId获取拉黑列表
//	 * @return
//	 */
//    @RequestMapping(value = "/publisher/msg/list", method = RequestMethod.POST)
//    Result<PageInfo<MsgsBackListDTO>> getPublisherList(@RequestBody OpenApiReq<MsgsBackListRequestDTO> openApiReq);
//    /**
//     * 发布商消息记录分页列表
//     *
//     * @param openApiReq
//     * @return
//     */
//    @RequestMapping(value = "/publisher/msg/page", method = RequestMethod.POST)
//    Result<PageInfo<MsgsListBackDTO>> getMsgPage(@RequestBody OpenApiReq<MsgsMessagePublisherDTO> openApiReq);  
//}

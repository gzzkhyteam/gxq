//package com.hengyunsoft.platform.sms.api;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.sms.api.hystrix.SmsPubliserApiHystrix;
//import com.hengyunsoft.platform.sms.dto.BlackListRequestDTO;
//import com.hengyunsoft.platform.sms.dto.BlackListResponseDTO;
//import com.hengyunsoft.platform.sms.dto.PublisherPullblackDTO;
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",path = "/api/sms",
//fallback = SmsPubliserApiHystrix.class)
//public interface SmsPubliserApi {	
//	/**
//	 * 发布人拉黑/取消拉黑
//	 * @param serviceAccountDTO
//	 * @return
//	 */
//    @RequestMapping(value = "/publisher/pullblack", method = RequestMethod.POST)
//    Result<Boolean> savePublisherPullblack(@RequestBody PublisherPullblackDTO publisherPullblackDTO);
//	/**
//	 * 根据Appid获取拉黑列表
//	 * @param serviceAccountDTO
//	 * @return
//	 */
//    @RequestMapping(value = "/publisher/list", method = RequestMethod.POST)
//    Result<PageInfo<BlackListResponseDTO>> getPublisherList(@RequestBody OpenApiReq<BlackListRequestDTO> openApiReq);
//}

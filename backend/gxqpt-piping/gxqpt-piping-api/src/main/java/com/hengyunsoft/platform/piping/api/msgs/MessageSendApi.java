//package com.hengyunsoft.platform.piping.api.msgs;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.piping.api.msgs.dto.MessageDTO;
//import com.hengyunsoft.platform.piping.api.msgs.hystrix.MessageApiHystrix;
//
//@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
//path = "/api/piping",
//fallback = MessageApiHystrix.class)
//public interface MessageSendApi {
//	/**
//	 * 发送信息到rabbitMq
//	 * @param msgSendDTO
//	 * @return
//	 */
//	@RequestMapping(value = "/send", method = RequestMethod.POST)
//    Result<String> send(@RequestBody MessageDTO messageDTO);
//}

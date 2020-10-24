package com.hengyunsoft.platform.piping.open;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.WeChatSendDTO;
import com.hengyunsoft.platform.piping.open.hystrix.WeChatSendApiHystrix;

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
fallback = WeChatSendApiHystrix.class)
public interface WeChatSendApi {
	/**
	 * 发送信息到rabbitMq
	 * @param msgSendDTO
	 * @return
	 */
	@RequestMapping(value = "/p/wechat/send", method = RequestMethod.POST)
    Result<String> send(@RequestBody WeChatSendDTO weChatSendDTO);
}

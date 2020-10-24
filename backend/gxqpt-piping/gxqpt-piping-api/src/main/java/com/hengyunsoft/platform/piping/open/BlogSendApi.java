package com.hengyunsoft.platform.piping.open;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.BlogSendDTO;
import com.hengyunsoft.platform.piping.open.hystrix.BlogSendApiHystrix;

@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
fallback = BlogSendApiHystrix.class)
public interface BlogSendApi {
	/**
	 * 发送信息到rabbitMq
	 * @param msgSendDTO
	 * @return
	 */
	@RequestMapping(value = "/p/blog/send", method = RequestMethod.POST)
    Result<String> send(@RequestBody BlogSendDTO blogSendDTO);
}

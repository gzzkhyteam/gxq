package com.hengyunsoft.platform.piping.open.hystrix;

import org.springframework.stereotype.Component;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.WeChatSendDTO;
import com.hengyunsoft.platform.piping.open.WeChatSendApi;
@Component
public class WeChatSendApiHystrix implements WeChatSendApi{

	public Result<String> send(WeChatSendDTO weChatSendDTO) {
		return Result.timeout();
	}

}

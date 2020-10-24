package com.hengyunsoft.platform.piping.open.hystrix;

import org.springframework.stereotype.Component;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.piping.api.msgs.dto.SmsSendDTO;
import com.hengyunsoft.platform.piping.open.SmsSendApi;
@Component
public class SmsSendApiHystrix implements SmsSendApi{

	public Result<String> send(SmsSendDTO smsSendDTO) {
		return Result.timeout();
	}

}

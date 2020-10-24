package com.hengyunsoft.platform.sms.open.hystrix;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.sms.open.SmsTemplateOpenApi;

@Component
public class SmsTemplateOpenApiHystrix implements SmsTemplateOpenApi{

	@Override
	public Result<List<Map<String, Object>>> getSmsTemplateChannelList(String channelid) {
		return Result.timeout();
	}

}

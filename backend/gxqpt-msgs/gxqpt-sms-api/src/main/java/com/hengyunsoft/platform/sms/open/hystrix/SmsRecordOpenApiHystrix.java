package com.hengyunsoft.platform.sms.open.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.sms.dto.QuerySmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsChannelDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDTO;
import com.hengyunsoft.platform.sms.dto.SmsRecordDetailDTO;
import com.hengyunsoft.platform.sms.open.SmsRecordOpenApi;

@Component
public class SmsRecordOpenApiHystrix implements SmsRecordOpenApi{

	@Override
	public Result<PageInfo<SmsRecordDTO>> pageSmsRecordList(OpenApiReq<QuerySmsRecordDTO> querySmsRecordDTO) {
		return Result.timeout();
	}

	@Override
	public Result<SmsRecordDetailDTO> getSmsRecordDetail(String msgId) {
		return Result.timeout();
	}

	@Override
	public Result<List<SmsChannelDTO>> getSmsChannelList(String appId) {
		return Result.timeout();
	}

	@Override
	public Result<String> deleteSmsDraftById(Long recordId) {
		return Result.timeout();
	}
}

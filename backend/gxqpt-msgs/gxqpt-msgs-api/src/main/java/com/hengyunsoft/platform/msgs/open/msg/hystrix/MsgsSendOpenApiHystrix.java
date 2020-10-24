package com.hengyunsoft.platform.msgs.open.msg.hystrix;

import java.util.List;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.msg.MsgDetailDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageOpenReqDTO;
import com.hengyunsoft.platform.msgs.dto.msg.OpenChannelDTO;
import com.hengyunsoft.platform.msgs.open.msg.MsgsSendOpenApi;
@Component
public class MsgsSendOpenApiHystrix implements MsgsSendOpenApi{

	@Override
	public Result<List<OpenChannelDTO>> getChannelList(Long userId) {
		return Result.timeout();
	}

	@Override
	public Result<PageInfo<MsgsListBackDTO>> getMsgsPage(OpenApiReq<MsgsMessageOpenReqDTO> openApiReq) {
		return Result.timeout();
	}

	@Override
	public Result<MsgDetailDTO> getMsgDetail(Long id) {
		return Result.timeout();
	}

}

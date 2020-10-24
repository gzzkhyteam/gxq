package com.hengyunsoft.platform.msgs.open.msg;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.msgs.dto.msg.MsgDetailDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsListBackDTO;
import com.hengyunsoft.platform.msgs.dto.msg.MsgsMessageOpenReqDTO;
import com.hengyunsoft.platform.msgs.dto.msg.OpenChannelDTO;
import com.hengyunsoft.platform.msgs.open.msg.hystrix.MsgsSendOpenApiHystrix;

/**
 * 发布管道服务接口
 * @author dxz
 */
@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
fallback = MsgsSendOpenApiHystrix.class)
public interface MsgsSendOpenApi {
	/**
	 * 查询渠道接口
	 * @return
	 */	
	@RequestMapping(value = "/p/channels/get", method = RequestMethod.GET)
	Result<List<OpenChannelDTO>> getChannelList(@RequestParam(value = "userId") Long userId);
	/**
	 * 查询已发送信息分页列表
	 * @return
	 */	
	@RequestMapping(value = "/p/msgs/page", method = RequestMethod.POST)
	public Result<PageInfo<MsgsListBackDTO>> getMsgsPage(@RequestBody OpenApiReq<MsgsMessageOpenReqDTO> openApiReq);
    /**
     * 获取信息详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/p/msg/detail", method = RequestMethod.GET)
    Result<MsgDetailDTO> getMsgDetail(@RequestParam(value = "id") Long id);
}

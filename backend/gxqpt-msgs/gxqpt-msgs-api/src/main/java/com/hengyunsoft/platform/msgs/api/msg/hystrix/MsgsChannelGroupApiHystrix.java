//package com.hengyunsoft.platform.msgs.api.msg.hystrix;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.api.msg.MsgsChannelGroupApi;
//import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupDetailBackDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.ChannelGroupSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelChildTreeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelGroupQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelGroupSelectDTO;
//@Component
//public class MsgsChannelGroupApiHystrix implements MsgsChannelGroupApi {
//
//	@Override
//	public Result<PageInfo<ChannelGroupDTO>> pageQuery(OpenApiReq<MsgsChannelGroupQueryDTO> openApiReq) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgsChannelGroupSelectDTO>> allQuery(String name) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<Boolean> delete(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<String> save(ChannelGroupSaveDTO channelGroupSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<String> update(ChannelGroupSaveDTO channelGroupSaveDTO) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgChannelChildTreeDTO>> getGroupDetail(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<ChannelGroupDetailBackDTO> selectGroupDetail(Long id) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<Long>> queryGroupRelation(Long id) {
//		return Result.timeout();
//	}
//}

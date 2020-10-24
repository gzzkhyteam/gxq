//package com.hengyunsoft.platform.msgs.api.msg.hystrix;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.api.msg.MsgsChannelApi;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgChannelTreeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelByTypeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeSelectDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelUpdateDTO;
//@Component
//public class MsgsChannelApiHystrix implements MsgsChannelApi {
//    @Override
//    public Result<PageInfo<MsgsChannelDTO>> query(OpenApiReq<MsgsChannelQueryDTO> openApiReq) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<PageInfo<MsgsChannelByTypeDTO>> getChannelByType(Integer typeId) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<MsgsChannelDTO> get(Long id) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<String> save(MsgsChannelSaveDTO msgsChannelSaveDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<String> update(MsgsChannelUpdateDTO msgsChannelUpdateDTO) {
//        return Result.timeout();
//    }
//
//    @Override
//    public Result<Boolean> delete(Long id) {
//        return Result.timeout();
//    }
//
//	@Override
//	public Result<List<MsgChannelTreeDTO>> getTree() {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgChannelTreeDTO>> getTreeByNameLike(String name) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgsChannelByTypeDTO>> getByType(Integer type) {
//		return Result.timeout();
//	}
//
//	@Override
//	public Result<List<MsgsChannelTypeSelectDTO>> querySelect() {
//		return Result.timeout();
//	}
//}

//package com.hengyunsoft.platform.msgs.api.msg.hystrix;
//
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.msgs.api.msg.MsgsChannelTypeApi;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgsChannelTypeSelectDTO;
//@Component
//public class MsgsChannelTypeApiHystrix implements MsgsChannelTypeApi {
//    @Override
//    public Result<PageInfo<MsgsChannelTypeSelectDTO>> querySelect() {
//    	 return Result.timeout();
//    }
//
//	@Override
//	public Result<List<MsgsChannelTypeDTO>> query() {
//		 return Result.timeout();
//	}
//
//}

//package com.hengyunsoft.platform.msgs.open.msg;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.msgs.dto.msg.CommonCountDTO;
//
///*@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
//fallback = CommonCountApiHystrix.class)*/
//public interface CommonCountApi {
//
//	/**
//	 * 获取首页消息数量
//	 * @return
//	 */
//	@RequestMapping(value = "/p/common/list", method = RequestMethod.GET)
//	Result<List<CommonCountDTO>> getAllServiceCount(@RequestParam(value="reciverId",required=false)Long reciverId);
//}

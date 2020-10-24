//package com.hengyunsoft.platform.msgs.open.msg;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.WarnCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.WarnCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.WarnCenterUpdateDTO;
//
///*@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
//fallback = WarnCenterApiHystrix.class)*/
//public interface WarnCenterApi {
//	/**
//	 * 获取更多预警中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/warncenter/page", method = RequestMethod.POST)
// 	Result<PageInfo<WarnCenterDTO>> pageMoreWarnCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq);
//	/**
//	 * 新增预警中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/warncenter/add", method = RequestMethod.POST)
// 	Result<WarnCenterDTO> addWarnCenter(@RequestBody WarnCenterSaveDTO warnCenterSaveDTO);
//	/**
//	 * 删除预警中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/warncenter/delete", method = RequestMethod.POST)
// 	Result<Boolean> deleteWarnCenter(@RequestParam(value="id") Long id);
//	/**
//	 * 修改预警中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/warncenter/update", method = RequestMethod.POST)
// 	Result<Boolean> updateWarnCenter(@RequestBody WarnCenterUpdateDTO warnCenterUpdateDTO);
//	/**
//	 * 修改预警中心未读状态
//	 * @return
//	 */
//	@RequestMapping(value = "/p/warncenter/status", method = RequestMethod.POST)
// 	Result<Boolean> updateWarnCenterStatus(@RequestParam(value="id") Long id);
//}

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
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//
///*@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
//fallback = BulletinCenterApiHystrix.class)*/
//public interface BulletinCenterApi {
//	/**
//	 * 获取更多公告中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/bulletinCenter/page", method = RequestMethod.POST)
// 	Result<PageInfo<BulletinCenterDTO>> pageMoreBulletinCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq);
//	/**
//	 * 新增公告中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/bulletinCenter/add", method = RequestMethod.POST)
// 	Result<BulletinCenterDTO> addBulletinCenter(@RequestBody BulletinCenterSaveDTO bulletinCenterSaveDTO);
//	/**
//	 * 删除公告中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/bulletinCenter/delete", method = RequestMethod.POST)
// 	Result<Boolean> deleteBulletinCenter(@RequestParam(value="id") Long id);
//	/**
//	 * 修改公告中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/bulletinCenter/update", method = RequestMethod.POST)
// 	Result<Boolean> updateBulletinCenter(@RequestBody BulletinCenterUpdateDTO bulletinCenterUpdateDTO);
//	/**
//	 * 修改公告中心未读状态
//	 * @return
//	 */
//	@RequestMapping(value = "/p/bulletinCenter/status", method = RequestMethod.POST)
// 	Result<Boolean> updateBulletinCenterStatus(@RequestParam(value="id") Long id);
//}

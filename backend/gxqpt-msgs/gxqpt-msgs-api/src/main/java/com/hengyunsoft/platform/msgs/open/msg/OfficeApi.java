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
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeUpdateDTO;
//
///*@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
//fallback = OfficeApiHystrix.class)*/
//public interface OfficeApi {
//	/**
//	 * 获取更多待办公文数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/office/page", method = RequestMethod.POST)
// 	Result<PageInfo<OfficeDTO>> pageMoreOfficeList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq);
//	/**
//	 * 新增待办公文数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/office/add", method = RequestMethod.POST)
// 	Result<OfficeDTO> addOffice(@RequestBody OfficeSaveDTO officeSaveDTO);
//	/**
//	 * 删除待办公文数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/office/delete", method = RequestMethod.POST)
// 	Result<Boolean> deleteOffice(@RequestParam(value="id") Long id);
//	/**
//	 * 修改待办公文数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/office/update", method = RequestMethod.POST)
// 	Result<Boolean> updateOffice(@RequestBody OfficeUpdateDTO officeUpdateDTO);
//	/**
//	 * 修改待办公文未读状态
//	 * @return
//	 */
//	@RequestMapping(value = "/p/office/status", method = RequestMethod.POST)
// 	Result<Boolean> updateOfficeStatus(@RequestParam(value="id") Long id);
//}

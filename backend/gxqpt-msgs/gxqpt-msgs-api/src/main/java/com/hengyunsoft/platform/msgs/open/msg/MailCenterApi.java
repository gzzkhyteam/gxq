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
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//
///*@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
//fallback = MailCenterApiHystrix.class)*/
//public interface MailCenterApi {
//	/**
//	 * 获取更多邮件中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/mailCenter/page", method = RequestMethod.POST)
// 	Result<PageInfo<MailCenterDTO>> pageMoreMailCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq);
//	/**
//	 * 新增邮件中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/mailCenter/add", method = RequestMethod.POST)
// 	Result<MailCenterDTO> addMailCenter(@RequestBody MailCenterSaveDTO mailCenterSaveDTO);
//	/**
//	 * 删除邮件中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/mailCenter/delete", method = RequestMethod.POST)
// 	Result<Boolean> deleteMailCenter(@RequestParam(value="id") Long id);
//	/**
//	 * 修改邮件中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/mailCenter/update", method = RequestMethod.POST)
// 	Result<Boolean> updateMailCenter(@RequestBody MailCenterUpdateDTO mailCenterUpdateDTO);
//	/**
//	 * 修改邮件中心未读状态
//	 * @return
//	 */
//	@RequestMapping(value = "/p/mailCenter/status", method = RequestMethod.POST)
// 	Result<Boolean> updateMailCenterStatus(@RequestParam(value="id") Long id);
//}

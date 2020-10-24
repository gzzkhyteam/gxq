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
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//
///*@FeignClient(name = "${gxqpt.feign.msgs-server:gxqpt-gate-server}",
//fallback = MessageCenterApiHystrix.class)*/
//public interface MessageCenterApi {
//	/**
//	 * 获取更多消息中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/messageCenter/page", method = RequestMethod.POST)
// 	Result<PageInfo<MessageCenterDTO>> pageMoreMessageCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq);
//	/**
//	 * 新增消息中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/messageCenter/add", method = RequestMethod.POST)
// 	Result<MessageCenterDTO> addMessageCenter(@RequestBody MessageCenterSaveDTO messageCenterSaveDTO);
//	/**
//	 * 删除消息中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/messageCenter/delete", method = RequestMethod.POST)
// 	Result<Boolean> deleteMessageCenter(@RequestParam(value="id") Long id);
//	/**
//	 * 修改消息中心数据
//	 * @return
//	 */
//	@RequestMapping(value = "/p/messageCenter/update", method = RequestMethod.POST)
// 	Result<Boolean> updateMessageCenter(@RequestBody MessageCenterUpdateDTO messageCenterUpdateDTO);
//	/**
//	 * 修改消息中心未读状态
//	 * @return
//	 */
//	@RequestMapping(value = "/p/messageCenter/status", method = RequestMethod.POST)
// 	Result<Boolean> updateMessageCenterStatus(@RequestParam(value="id") Long id);
//}

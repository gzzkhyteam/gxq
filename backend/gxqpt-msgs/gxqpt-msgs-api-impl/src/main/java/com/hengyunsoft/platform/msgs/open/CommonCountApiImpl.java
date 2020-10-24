//package com.hengyunsoft.platform.msgs.open;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.platform.msgs.dto.msg.CommonCountDTO;
//import com.hengyunsoft.platform.msgs.open.msg.CommonCountApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BacklogService;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BulletinCenterService;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MailCenterService;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MessageCenterService;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.OfficeService;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WarnCenterService;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
////@RestController
//@Slf4j
////@Api(value = "查询所有服务消息数量", description = "查询所有服务消息数量")
//public class CommonCountApiImpl implements CommonCountApi{
//    @Autowired
//	private BacklogService backlogService;
//    @Autowired
//	private MailCenterService mailCenterService;
//    @Autowired
//	private MessageCenterService messageCenterService;
//    @Autowired
//	private OfficeService officeService;
//    @Autowired
//	private WarnCenterService warnCenterService;
//	@Autowired
//	private BulletinCenterService bulletinCenterService;
//	/**
//	 * 获取首页消息数量
//	 * @return
//	 */
//	@Override
//	@ApiOperation(value = "获取首页消息数量", notes = "获取首页消息数量")
//	public Result<List<CommonCountDTO>> getAllServiceCount(@RequestParam(value="reciverId",required=false)Long reciverId) {
//		try {
//			List<CommonCountDTO> list = new ArrayList<CommonCountDTO>();
//			Integer backlog =  backlogService.getAllCount(reciverId);
//			Integer mail =  mailCenterService.getAllCount(reciverId);
//			Integer message =  messageCenterService.getAllCount(reciverId);
//			Integer office =  officeService.getAllCount(reciverId);
//			Integer warn =  warnCenterService.getAllCount(reciverId);
//			Integer bulletin =  bulletinCenterService.getAllCount(reciverId);
//			CommonCountDTO commonCountDTO = new CommonCountDTO();
//			commonCountDTO.setName("公告中心");
//			commonCountDTO.setCount(bulletin);
//			list.add(commonCountDTO);
//			commonCountDTO = new CommonCountDTO();
//			commonCountDTO.setName("待办事项");
//			commonCountDTO.setCount(backlog);
//			list.add(commonCountDTO);
//			commonCountDTO = new CommonCountDTO();
//			commonCountDTO.setName("邮件中心");
//			commonCountDTO.setCount(mail);
//			list.add(commonCountDTO);
//			commonCountDTO = new CommonCountDTO();
//			commonCountDTO.setName("消息中心");
//			commonCountDTO.setCount(message);
//			list.add(commonCountDTO);
//			commonCountDTO = new CommonCountDTO();
//			commonCountDTO.setName("待办公文");
//			commonCountDTO.setCount(office);
//			list.add(commonCountDTO);
//			commonCountDTO = new CommonCountDTO();
//			commonCountDTO.setName("预警中心");
//			commonCountDTO.setCount(warn);
//			list.add(commonCountDTO);
//			return Result.success(list);
//		} catch (Exception e) {
//			log.error("获取首页消息数量出错"+e);
//			return Result.fail("获取首页消息数量出错");
//		}
//	}
//}

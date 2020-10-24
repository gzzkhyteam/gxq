//package com.hengyunsoft.platform.msgs.open;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.hengyunsoft.base.Result;
//import com.hengyunsoft.commons.exception.core.SmsExceptionCode;
//import com.hengyunsoft.commons.utils.context.DozerUtils;
//import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MessageCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MessageCenter;
//import com.hengyunsoft.platform.msgs.open.msg.MessageCenterApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MessageCenterExample;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MessageCenterService;
//import com.hengyunsoft.utils.BizAssert;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
///**
// * 消息中心管理
// * @author dxz
// */
////@RestController
//@Slf4j
////@Api(value = "消息中心管理", description = "消息中心管理")
//public class MessageCenterApiImpl implements MessageCenterApi{
//    @Autowired
//    private DozerUtils dozerUtils;
//	@Autowired
//	private MessageCenterService messageCenterService;
//	/**
//	 * 获取更多消息中心数据
//	 */
//	@Override
//	@ApiOperation(value = "获取更多消息中心数据", notes = "获取更多消息中心数据")
//	public Result<PageInfo<MessageCenterDTO>> pageMoreMessageCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		MsgCenterQueryDTO messageCenterQueryDTO = openApiReq.getData();
//		try {
//			//获取半年前的时间
//			Calendar c = Calendar.getInstance();
//			c.setTime(new Date());
//	        c.add(Calendar.MONTH, -6);
//	        Date date = c.getTime();
//	        //获取未读信息总条数
//			MessageCenterExample messageCenterExample = new MessageCenterExample();
//			if(messageCenterQueryDTO.getMore()==1){
//				messageCenterExample.createCriteria().andReceiverIdEqualTo(messageCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date);
//			}else{
//				messageCenterExample.createCriteria().andReceiverIdEqualTo(messageCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date).andReadedEqualTo(0);
//			}
//			messageCenterExample.setOrderByClause("create_time desc");
//			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//			List<MessageCenter> resultList = messageCenterService.find(messageCenterExample);
//			List<MessageCenterDTO> pageDate = dozerUtils.mapPage(resultList, MessageCenterDTO.class);
//			return Result.success(new PageInfo<>(pageDate));
//		} catch (Exception e) {
//			log.error("获取更多消息中心数据出错"+e);
//			return Result.fail("获取更多消息中心数据出错");
//		}
//	}
//	/**
//	 * 新增消息中心数据
//	 */
//	@Override
//	@ApiOperation(value = "新增消息中心数据", notes = "新增消息中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<MessageCenterDTO> addMessageCenter(@RequestBody MessageCenterSaveDTO messageCenterSaveDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,messageCenterSaveDTO);
//		try {
//			MessageCenter messageCenter = dozerUtils.map(messageCenterSaveDTO, MessageCenter.class);
//			messageCenter.setReaded(0);
//			messageCenter.setCreateTime(new Date());
//			messageCenter = messageCenterService.save(messageCenter);
//			MessageCenterDTO dto = dozerUtils.map(messageCenter, MessageCenterDTO.class);
//			return Result.success(dto);
//		} catch (Exception e) {
//			log.error("新增消息中心数据出错"+e);
//			return Result.fail("新增消息中心数据出错");
//		}
//	}
//	/**
//	 * 删除消息中心数据
//	 */
//	@Override
//	@ApiOperation(value = "删除消息中心数据", notes = "删除消息中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> deleteMessageCenter(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			int result = messageCenterService.deleteById(id);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("删除消息中心数据出错"+e);
//			return Result.fail("删除消息中心数据出错");
//		}
//	}
//	/**
//	 * 修改消息中心数据
//	 */
//	@Override
//	@ApiOperation(value = "修改消息中心数据", notes = "修改消息中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateMessageCenter(@RequestBody MessageCenterUpdateDTO messageCenterUpdateDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,messageCenterUpdateDTO);
//		try {
//			MessageCenter messageCenter = new MessageCenter();
//			messageCenter.setId(messageCenterUpdateDTO.getId());
//			messageCenter.setTopic(messageCenterUpdateDTO.getTopic());
//			messageCenter.setSender(messageCenterUpdateDTO.getSender());
//			messageCenter.setUrl(messageCenterUpdateDTO.getUrl());
//			messageCenter.setUpdateTime(new Date());
//			int result = messageCenterService.updateByIdSelective(messageCenter);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改消息中心数据出错"+e);
//			return Result.fail("修改消息中心数据出错");
//		}
//	}
//	/**
//	 * 修改消息中心未读状态
//	 */
//	@Override
//	@ApiOperation(value = "修改消息中心未读状态", notes = "修改消息中心未读状态")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateMessageCenterStatus(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			MessageCenter messageCenter = new MessageCenter();
//			messageCenter.setReaded(1);
//			messageCenter.setId(id);
//			int result = messageCenterService.updateByIdSelective(messageCenter);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改消息中心未读状态出错"+e);
//			return Result.fail("修改消息中心未读状态出错");
//		}
//	}
//}

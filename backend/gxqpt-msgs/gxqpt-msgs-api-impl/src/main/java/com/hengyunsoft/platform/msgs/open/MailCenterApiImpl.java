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
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MailCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.MailCenter;
//import com.hengyunsoft.platform.msgs.open.msg.MailCenterApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.MailCenterExample;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.MailCenterService;
//import com.hengyunsoft.utils.BizAssert;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
///**
// * 邮件中心
// * @author dxz
// */
////@RestController
//@Slf4j
////@Api(value = "邮件中心管理", description = "邮件中心管理")
//public class MailCenterApiImpl implements MailCenterApi{
//    @Autowired
//    private DozerUtils dozerUtils;
//	@Autowired
//	private MailCenterService mailCenterService;
//	/**
//	 * 获取更多邮件中心数据
//	 */
//	@Override
//	@ApiOperation(value = "获取更多邮件中心数据", notes = "获取更多邮件中心数据")
//	public Result<PageInfo<MailCenterDTO>> pageMoreMailCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		MsgCenterQueryDTO mailCenterQueryDTO = openApiReq.getData();
//		try {
//			//获取半年前的时间
//			Calendar c = Calendar.getInstance();
//			c.setTime(new Date());
//	        c.add(Calendar.MONTH, -6);
//	        Date date = c.getTime();
//	        //获取未读信息总条数
//			MailCenterExample mailCenterExample = new MailCenterExample();
//			if(mailCenterQueryDTO.getMore()==1){
//				mailCenterExample.createCriteria().andReceiverIdEqualTo(mailCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date);
//			}else{
//				mailCenterExample.createCriteria().andReceiverIdEqualTo(mailCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date).andReadedEqualTo(0);
//			}
//			mailCenterExample.setOrderByClause("create_time desc");
//			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//			List<MailCenter> resultList = mailCenterService.find(mailCenterExample);
//			List<MailCenterDTO> pageDate = dozerUtils.mapPage(resultList, MailCenterDTO.class);
//			return Result.success(new PageInfo<>(pageDate));
//		} catch (Exception e) {
//			log.error("获取更多邮件中心数据出错"+e);
//			return Result.fail("获取更多邮件中心数据出错");
//		}
//	}
//	/**
//	 * 新增邮件中心数据
//	 */
//	@Override
//	@ApiOperation(value = "新增邮件中心数据", notes = "新增邮件中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<MailCenterDTO> addMailCenter(@RequestBody MailCenterSaveDTO mailCenterSaveDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,mailCenterSaveDTO);
//		try {
//			MailCenter mailCenter = dozerUtils.map(mailCenterSaveDTO, MailCenter.class);
//			mailCenter.setReaded(0);
//			mailCenter.setCreateTime(new Date());
//			mailCenter = mailCenterService.save(mailCenter);
//			MailCenterDTO dto = dozerUtils.map(mailCenter, MailCenterDTO.class);
//			return Result.success(dto);
//		} catch (Exception e) {
//			log.error("新增邮件中心数据出错"+e);
//			return Result.fail("新增邮件中心数据出错");
//		}
//	}
//	/**
//	 * 删除邮件中心数据
//	 */
//	@Override
//	@ApiOperation(value = "删除邮件中心数据", notes = "删除邮件中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> deleteMailCenter(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			int result = mailCenterService.deleteById(id);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("删除邮件中心数据出错"+e);
//			return Result.fail("删除邮件中心数据出错");
//		}
//	}
//	/**
//	 * 修改邮件中心数据
//	 */
//	@Override
//	@ApiOperation(value = "修改邮件中心数据", notes = "修改邮件中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateMailCenter(@RequestBody MailCenterUpdateDTO mailCenterUpdateDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,mailCenterUpdateDTO);
//		try {
//			MailCenter mailCenter = new MailCenter();
//			mailCenter.setId(mailCenterUpdateDTO.getId());
//			mailCenter.setTopic(mailCenterUpdateDTO.getTopic());
//			mailCenter.setSender(mailCenterUpdateDTO.getSender());
//			mailCenter.setUrl(mailCenterUpdateDTO.getUrl());
//			mailCenter.setUpdateTime(new Date());
//			int result = mailCenterService.updateByIdSelective(mailCenter);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改邮件中心数据出错"+e);
//			return Result.fail("修改邮件中心数据出错");
//		}
//	}
//	/**
//	 * 修改邮件中心未读状态
//	 */
//	@Override
//	@ApiOperation(value = "修改邮件中心未读状态", notes = "修改邮件中心未读状态")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateMailCenterStatus(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			MailCenter mailCenter = new MailCenter();
//			mailCenter.setReaded(1);
//			mailCenter.setId(id);
//			int result = mailCenterService.updateByIdSelective(mailCenter);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改邮件中心未读状态出错"+e);
//			return Result.fail("修改邮件中心未读状态出错");
//		}
//	}
//}

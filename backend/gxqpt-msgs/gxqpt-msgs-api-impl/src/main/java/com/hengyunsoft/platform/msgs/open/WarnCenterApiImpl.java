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
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.WarnCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.WarnCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.WarnCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.WarnCenter;
//import com.hengyunsoft.platform.msgs.open.msg.WarnCenterApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.WarnCenterExample;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.WarnCenterService;
//import com.hengyunsoft.utils.BizAssert;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
///**
// * 预警中心管理
// * @author dxz
// */
////@RestController
//@Slf4j
////@Api(value = "预警中心管理", description = "预警中心管理")
//public class WarnCenterApiImpl implements WarnCenterApi{
//    @Autowired
//    private DozerUtils dozerUtils;
//	@Autowired
//	private WarnCenterService warnCenterService;
//	/**
//	 * 获取更多邮件中心数据
//	 */
//	@Override
//	@ApiOperation(value = "获取更多邮件中心数据", notes = "获取更多邮件中心数据")
//	public Result<PageInfo<WarnCenterDTO>> pageMoreWarnCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		MsgCenterQueryDTO warnCenterQueryDTO = openApiReq.getData();
//		try {
//			//获取半年前的时间
//			Calendar c = Calendar.getInstance();
//			c.setTime(new Date());
//	        c.add(Calendar.MONTH, -6);
//	        Date date = c.getTime();
//	        //获取未读信息总条数
//			WarnCenterExample warnCenterExample = new WarnCenterExample();
//			if(warnCenterQueryDTO.getMore()==1){
//				warnCenterExample.createCriteria().andReceiverIdEqualTo(warnCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date);
//			}else{
//				warnCenterExample.createCriteria().andReceiverIdEqualTo(warnCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date).andReadedEqualTo(0);
//			}
//			warnCenterExample.setOrderByClause("create_time desc");
//			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//			List<WarnCenter> resultList = warnCenterService.find(warnCenterExample);
//			List<WarnCenterDTO> pageDate = dozerUtils.mapPage(resultList, WarnCenterDTO.class);
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
//	public Result<WarnCenterDTO> addWarnCenter(@RequestBody WarnCenterSaveDTO warnCenterSaveDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,warnCenterSaveDTO);
//		try {
//			WarnCenter warnCenter = dozerUtils.map(warnCenterSaveDTO, WarnCenter.class);
//			warnCenter.setReaded(0);
//			warnCenter.setCreateTime(new Date());
//			warnCenter = warnCenterService.save(warnCenter);
//			WarnCenterDTO dto = dozerUtils.map(warnCenter, WarnCenterDTO.class);
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
//	public Result<Boolean> deleteWarnCenter(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			int result = warnCenterService.deleteById(id);
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
//	public Result<Boolean> updateWarnCenter(@RequestBody WarnCenterUpdateDTO warnCenterUpdateDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,warnCenterUpdateDTO);
//		try {
//			WarnCenter warnCenter = new WarnCenter();
//			warnCenter.setId(warnCenterUpdateDTO.getId());
//			warnCenter.setTopic(warnCenterUpdateDTO.getTopic());
//			warnCenter.setSender(warnCenterUpdateDTO.getSender());
//			warnCenter.setUrl(warnCenterUpdateDTO.getUrl());
//			warnCenter.setUpdateTime(new Date());
//			int result = warnCenterService.updateByIdSelective(warnCenter);
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
//	public Result<Boolean> updateWarnCenterStatus(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			WarnCenter warnCenter = new WarnCenter();
//			warnCenter.setReaded(1);
//			warnCenter.setId(id);
//			int result = warnCenterService.updateByIdSelective(warnCenter);
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

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
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BacklogUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Backlog;
//import com.hengyunsoft.platform.msgs.open.msg.BacklogApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BacklogExample;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BacklogService;
//import com.hengyunsoft.utils.BizAssert;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
///**
// * 待办事项管理
// * @author dxz
// */
////@RestController
//@Slf4j
////@Api(value = "待办事项管理", description = "待办事项管理")
//public class BacklogApiImpl implements BacklogApi{
//    @Autowired
//    private DozerUtils dozerUtils;
//	@Autowired
//	private BacklogService backlogService;
//	/**
//	 * 获取更多待办事项数据
//	 */
//	@Override
//	@ApiOperation(value = "获取更多待办事项数据", notes = "获取更多待办事项数据")
//	public Result<PageInfo<BacklogDTO>> pageMoreBacklogList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		MsgCenterQueryDTO backlogQueryDTO = openApiReq.getData();
//		try {
//			//获取半年前的时间
//			Calendar c = Calendar.getInstance();
//			c.setTime(new Date());
//	        c.add(Calendar.MONTH, -6);
//	        Date date = c.getTime();
//	        //获取未读信息总条数
//			BacklogExample backlogExample = new BacklogExample();
//			if(backlogQueryDTO.getMore()==1){
//				backlogExample.createCriteria().andReceiverIdEqualTo(backlogQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date);
//			}else{
//				backlogExample.createCriteria().andReceiverIdEqualTo(backlogQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date).andReadedEqualTo(0);
//			}
//			backlogExample.setOrderByClause("create_time desc");
//			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//			List<Backlog> resultList = backlogService.find(backlogExample);
//			List<BacklogDTO> pageDate = dozerUtils.mapPage(resultList, BacklogDTO.class);
//			return Result.success(new PageInfo<>(pageDate));
//		} catch (Exception e) {
//			log.error("获取更多待办事项数据出错"+e);
//			return Result.fail("获取更多待办事项数据出错");
//		}
//	}
//	/**
//	 * 新增待办事项数据
//	 */
//	@Override
//	@ApiOperation(value = "新增待办事项数据", notes = "新增待办事项数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<BacklogDTO> addBacklog(@RequestBody BacklogSaveDTO backlogSaveDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,backlogSaveDTO);
//		try {
//			Backlog backlog = dozerUtils.map(backlogSaveDTO, Backlog.class);
//			backlog.setReaded(0);
//			backlog.setCreateTime(new Date());
//			backlog = backlogService.save(backlog);
//			BacklogDTO dto = dozerUtils.map(backlog, BacklogDTO.class);
//			return Result.success(dto);
//		} catch (Exception e) {
//			log.error("新增待办事项数据出错"+e);
//			return Result.fail("新增待办事项数据出错");
//		}
//	}
//	/**
//	 * 删除待办事项数据
//	 */
//	@Override
//	@ApiOperation(value = "删除待办事项数据", notes = "删除待办事项数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> deleteBacklog(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			int result = backlogService.deleteById(id);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("删除待办事项数据出错"+e);
//			return Result.fail("删除待办事项数据出错");
//		}
//	}
//	/**
//	 * 修改待办事项数据
//	 */
//	@Override
//	@ApiOperation(value = "修改待办事项数据", notes = "修改待办事项数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateBacklog(@RequestBody BacklogUpdateDTO backlogUpdateDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,backlogUpdateDTO);
//		try {
//			Backlog backlog = new Backlog();
//			backlog.setId(backlogUpdateDTO.getId());
//			backlog.setTask(backlogUpdateDTO.getTask());
//			backlog.setTaskLink(backlogUpdateDTO.getTaskLink());
//			backlog.setTaskNum(backlogUpdateDTO.getTaskNum());
//			backlog.setTaskSource(backlogUpdateDTO.getTaskSource());
//			backlog.setTaskUrl(backlogUpdateDTO.getTaskUrl());
//			backlog.setUpdateTime(new Date());
//			int result = backlogService.updateByIdSelective(backlog);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改待办事项数据出错"+e);
//			return Result.fail("修改待办事项数据出错");
//		}
//	}
//	/**
//	 * 修改待办事项未读状态
//	 */
//	@Override
//	@ApiOperation(value = "修改待办事项未读状态", notes = "修改待办事项未读状态")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateBacklogStatus(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			Backlog backlog = new Backlog();
//			backlog.setReaded(1);
//			backlog.setId(id);
//			int result = backlogService.updateByIdSelective(backlog);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改待办事项未读状态出错"+e);
//			return Result.fail("修改待办事项未读状态出错");
//		}
//	}
//}

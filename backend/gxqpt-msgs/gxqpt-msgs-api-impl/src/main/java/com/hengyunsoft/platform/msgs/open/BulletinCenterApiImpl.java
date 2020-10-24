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
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.BulletinCenterUpdateDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.MsgCenterQueryDTO;
//import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.BulletinCenter;
//import com.hengyunsoft.platform.msgs.open.msg.BulletinCenterApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.BulletinCenterExample;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.BulletinCenterService;
//import com.hengyunsoft.utils.BizAssert;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
///**
// * 公告中心管理
// * @author dxz
// */
////@RestController
//@Slf4j
////@Api(value = "公告中心管理", description = "公告中心管理")
//public class BulletinCenterApiImpl implements BulletinCenterApi{
//    @Autowired
//    private DozerUtils dozerUtils;
//	@Autowired
//	private BulletinCenterService bulletinCenterService;
//	/**
//	 * 获取更多公告中心数据
//	 */
//	@Override
//	@ApiOperation(value = "获取更多公告中心数据", notes = "获取更多公告中心数据")
//	public Result<PageInfo<BulletinCenterDTO>> pageMoreBulletinCenterList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		MsgCenterQueryDTO bulletinCenterQueryDTO = openApiReq.getData();
//		try {
//			//获取半年前的时间
//			Calendar c = Calendar.getInstance();
//			c.setTime(new Date());
//	        c.add(Calendar.MONTH, -6);
//	        Date date = c.getTime();
//	        //获取未读信息总条数
//			BulletinCenterExample bulletinCenterExample = new BulletinCenterExample();
//			if(bulletinCenterQueryDTO.getMore()==1){
//				bulletinCenterExample.createCriteria().andReceiverIdEqualTo(bulletinCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date);
//			}else{
//				bulletinCenterExample.createCriteria().andReceiverIdEqualTo(bulletinCenterQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date).andReadedEqualTo(0);
//			}
//			bulletinCenterExample.setOrderByClause("create_time desc");
//			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//			List<BulletinCenter> resultList = bulletinCenterService.find(bulletinCenterExample);
//			List<BulletinCenterDTO> pageDate = dozerUtils.mapPage(resultList, BulletinCenterDTO.class);
//			return Result.success(new PageInfo<>(pageDate));
//		} catch (Exception e) {
//			log.error("获取更多公告中心数据出错"+e);
//			return Result.fail("获取更多公告中心数据出错");
//		}
//	}
//	/**
//	 * 新增公告中心数据
//	 */
//	@Override
//	@ApiOperation(value = "新增公告中心数据", notes = "新增公告中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<BulletinCenterDTO> addBulletinCenter(@RequestBody BulletinCenterSaveDTO bulletinCenterSaveDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,bulletinCenterSaveDTO);
//		try {
//			BulletinCenter bulletinCenter = dozerUtils.map(bulletinCenterSaveDTO, BulletinCenter.class);
//			bulletinCenter.setReaded(0);
//			bulletinCenter.setCreateTime(new Date());
//			bulletinCenter = bulletinCenterService.save(bulletinCenter);
//			BulletinCenterDTO dto = dozerUtils.map(bulletinCenter, BulletinCenterDTO.class);
//			return Result.success(dto);
//		} catch (Exception e) {
//			log.error("新增公告中心数据出错"+e);
//			return Result.fail("新增公告中心数据出错");
//		}
//	}
//	/**
//	 * 删除公告中心数据
//	 */
//	@Override
//	@ApiOperation(value = "删除公告中心数据", notes = "删除公告中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> deleteBulletinCenter(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			int result = bulletinCenterService.deleteById(id);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("删除公告中心数据出错"+e);
//			return Result.fail("删除公告中心数据出错");
//		}
//	}
//	/**
//	 * 修改公告中心数据
//	 */
//	@Override
//	@ApiOperation(value = "修改公告中心数据", notes = "修改公告中心数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateBulletinCenter(@RequestBody BulletinCenterUpdateDTO bulletinCenterUpdateDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,bulletinCenterUpdateDTO);
//		try {
//			BulletinCenter bulletinCenter = new BulletinCenter();
//			bulletinCenter.setId(bulletinCenterUpdateDTO.getId());
//			bulletinCenter.setTopic(bulletinCenterUpdateDTO.getTopic());
//			bulletinCenter.setSender(bulletinCenterUpdateDTO.getSender());
//			bulletinCenter.setUrl(bulletinCenterUpdateDTO.getUrl());
//			bulletinCenter.setUpdateTime(new Date());
//			int result = bulletinCenterService.updateByIdSelective(bulletinCenter);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改公告中心数据出错"+e);
//			return Result.fail("修改公告中心数据出错");
//		}
//	}
//	/**
//	 * 修改公告中心未读状态
//	 */
//	@Override
//	@ApiOperation(value = "修改公告中心未读状态", notes = "修改公告中心未读状态")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateBulletinCenterStatus(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			BulletinCenter bulletinCenter = new BulletinCenter();
//			bulletinCenter.setReaded(1);
//			bulletinCenter.setId(id);
//			int result = bulletinCenterService.updateByIdSelective(bulletinCenter);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改公告中心未读状态出错"+e);
//			return Result.fail("修改公告中心未读状态出错");
//		}
//	}
//}

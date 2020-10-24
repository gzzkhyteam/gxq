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
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeSaveDTO;
//import com.hengyunsoft.platform.msgs.dto.msg.OfficeUpdateDTO;
//import com.hengyunsoft.platform.msgs.entity.msgsmessage.po.Office;
//import com.hengyunsoft.platform.msgs.open.msg.OfficeApi;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.example.OfficeExample;
//import com.hengyunsoft.platform.msgs.repository.msgsmessage.service.OfficeService;
//import com.hengyunsoft.utils.BizAssert;
//
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
///**
// * 待办公文管理
// * @author dxz
// */
////@RestController
//@Slf4j
////@Api(value = "待办公文管理", description = "待办公文管理")
//public class OfficeApiImpl implements OfficeApi{
//    @Autowired
//    private DozerUtils dozerUtils;
//	@Autowired
//	private OfficeService officeService;
//	/**
//	 * 获取更多待办公文数据
//	 */
//	@Override
//	@ApiOperation(value = "获取更多待办公文数据", notes = "获取更多待办公文数据")
//	public Result<PageInfo<OfficeDTO>> pageMoreOfficeList(@RequestBody OpenApiReq<MsgCenterQueryDTO> openApiReq) {
//		MsgCenterQueryDTO officeQueryDTO = openApiReq.getData();
//		try {
//			//获取半年前的时间
//			Calendar c = Calendar.getInstance();
//			c.setTime(new Date());
//	        c.add(Calendar.MONTH, -6);
//	        Date date = c.getTime();
//	        //获取未读信息总条数
//			OfficeExample officeExample = new OfficeExample();
//			if(officeQueryDTO.getMore()==1){
//				officeExample.createCriteria().andReceiverIdEqualTo(officeQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date);
//			}else{
//				officeExample.createCriteria().andReceiverIdEqualTo(officeQueryDTO.getReciverId())
//				.andCreateTimeGreaterThan(date).andReadedEqualTo(0);
//			}
//			officeExample.setOrderByClause("create_time desc");
//			PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
//			List<Office> resultList = officeService.find(officeExample);
//			List<OfficeDTO> pageDate = dozerUtils.mapPage(resultList, OfficeDTO.class);
//			return Result.success(new PageInfo<>(pageDate));
//		} catch (Exception e) {
//			log.error("获取更多待办公文数据出错"+e);
//			return Result.fail("获取更多待办公文数据出错");
//		}
//	}
//	/**
//	 * 新增待办公文数据
//	 */
//	@Override
//	@ApiOperation(value = "新增待办公文数据", notes = "新增待办公文数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<OfficeDTO> addOffice(@RequestBody OfficeSaveDTO officeSaveDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,officeSaveDTO);
//		try {
//			Office office = dozerUtils.map(officeSaveDTO, Office.class);
//			office.setReaded(0);
//			office.setCreateTime(new Date());
//			office = officeService.save(office);
//			OfficeDTO dto = dozerUtils.map(office, OfficeDTO.class);
//			return Result.success(dto);
//		} catch (Exception e) {
//			log.error("新增待办公文数据出错"+e);
//			return Result.fail("新增待办公文数据出错");
//		}
//	}
//	/**
//	 * 删除待办公文数据
//	 */
//	@Override
//	@ApiOperation(value = "删除待办公文数据", notes = "删除待办公文数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> deleteOffice(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			int result = officeService.deleteById(id);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("删除待办公文数据出错"+e);
//			return Result.fail("删除待办公文数据出错");
//		}
//	}
//	/**
//	 * 修改待办公文数据
//	 */
//	@Override
//	@ApiOperation(value = "修改待办公文数据", notes = "修改待办公文数据")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateOffice(@RequestBody OfficeUpdateDTO officeUpdateDTO) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,officeUpdateDTO);
//		try {
//			Office office = dozerUtils.map(officeUpdateDTO, Office.class);
//			office.setUpdateTime(new Date());
//			int result = officeService.updateByIdSelective(office);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改待办公文数据出错"+e);
//			return Result.fail("修改待办公文数据出错");
//		}
//	}
//	/**
//	 * 修改待办公文未读状态
//	 */
//	@Override
//	@ApiOperation(value = "修改待办公文未读状态", notes = "修改待办公文未读状态")
//    @ApiResponses({
//        @ApiResponse(code = 45000, message = "消息中心请求参数错误"),
//    })
//	public Result<Boolean> updateOfficeStatus(@RequestParam(value="id") Long id) {
//		BizAssert.assertNotNull(SmsExceptionCode.MSG_PARAM_ERROR,id);
//		try {
//			Office office = new Office();
//			office.setReaded(1);
//			office.setId(id);
//			int result = officeService.updateByIdSelective(office);
//			if(result<=0){
//				return Result.success(false);
//			}
//			return Result.success(true);
//		} catch (Exception e) {
//			log.error("修改待办公文未读状态出错"+e);
//			return Result.fail("修改待办公文未读状态出错");
//		}
//	}
//}

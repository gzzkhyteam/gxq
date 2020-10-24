package com.hengyunsoft.platform.hardware.impl.equipmentMonitor;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.context.BaseContextHandler;
import com.hengyunsoft.commons.exception.core.HardWareExceptionCode;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.page.plugins.openapi.OpenApiReq;
import com.hengyunsoft.platform.hardware.dto.equipmentMonitor.EquipmentMonitorDTO;
import com.hengyunsoft.platform.hardware.dto.equipmentMonitor.EquipmentMonitorReportDTO;
import com.hengyunsoft.platform.hardware.entity.apply.po.Attachment;
import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitor;
import com.hengyunsoft.platform.hardware.entity.equipmentMonitor.po.EquipmentMonitorReport;
import com.hengyunsoft.platform.hardware.repository.apply.service.AttachmentService;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service.EquipmentMonitorReportService;
import com.hengyunsoft.platform.hardware.repository.equipmentMonitor.service.EquipmentMonitorService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * 描述：设备监控
 * 修改人：farglory
 * 修改时间：2018/9/4
 * 修改内容：
 */
@Api(value = "API - EquipmentMonitorApiImpl", description = "设备监控")
@RestController
@RequestMapping("equipmentMonitor")
@Slf4j
public class EquipmentMonitorApiImpl{
	@Autowired
	private EquipmentMonitorService equipmentMonitorService;
	@Autowired
	private EquipmentMonitorReportService equipmentMonitorReportService;
	@Autowired
	private DozerUtils dozerUtils;
	@Autowired
    private AttachmentService attachmentService;
	 /**
     * 查询设备监控数据列表
     *
     * @return
     */
    @ApiOperation(value = "查询设备监控数据列表", notes = "查询设备监控数据列表")
    @RequestMapping(value = "emPageList", method = RequestMethod.POST)
    public Result<PageInfo<EquipmentMonitorDTO>> emPageList(@RequestBody OpenApiReq<EquipmentMonitorDTO> openApiReq) {
    	//获取分页模糊查询入参
    	EquipmentMonitorDTO dto = openApiReq.getData();
        //设置查询条件
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        
        EquipmentMonitor em = dozerUtils.map(dto, EquipmentMonitor.class);
        
        List<EquipmentMonitorDTO> list = dozerUtils.mapList(equipmentMonitorService.pageNewest(em), EquipmentMonitorDTO.class);
        
        return Result.success(new PageInfo<>(list));
    }
    
    /**
     * 保存设备监控数据
     * @param saveMachineDTO
     * @return
     */
    @ApiOperation(value = "保存设备监控数据", notes = "保存设备监控数据")
    @RequestMapping(value = "saveEquipmentMonitor",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code =102501,message = "机房编号不能为空"),
            @ApiResponse(code =102502,message = "管理员不能为空"),
            @ApiResponse(code =102503,message = "联系电话不能为空"),
            @ApiResponse(code = 102504,message = "主机数量不能为空"),
            @ApiResponse(code = 102505,message = "路由器数量不能为空"),
            @ApiResponse(code = 102506,message = "空调数量不能为空"),
            @ApiResponse(code = 102507,message = "机柜数量不能为空")
    })
    public  Result<Boolean> saveEquipmentMonitor(@RequestBody EquipmentMonitorDTO equipmentMonitorDTO ){
    	boolean flag = false;
    	try {
    		//1.校验
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ROOMNUMBER_NULL, equipmentMonitorDTO.getRoomNumber());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ROOMADMIN_NULL,equipmentMonitorDTO.getRoomAdmin());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_CONTACTNUMBER_NULL,equipmentMonitorDTO.getContactNumber() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_HOSTNUM_NULL,equipmentMonitorDTO.getHostNum() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ROUTERNUM_NULL,equipmentMonitorDTO.getRouterNum() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_AIRCONNUM_NULL,equipmentMonitorDTO.getAirConNum() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_CABINETNUM_NULL,equipmentMonitorDTO.getCabinetNum() );
        	EquipmentMonitor map = dozerUtils.map(equipmentMonitorDTO, EquipmentMonitor.class);
            map.setCreateTime(new Date());
            map.setIsDelete(0);
            map.setCreateUser(BaseContextHandler.getAdminId().toString());
            map.setUpdateUser(BaseContextHandler.getAdminId().toString());
            map.setUpdateTime(new Date());
            equipmentMonitorService.save(map);
            flag=true;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        return Result.success(flag);
    }
    /**
     * 编辑设备监控数据
     * @param saveMachineDTO
     * @return
     */
    @ApiOperation(value = "编辑设备监控数据", notes = "编辑设备监控数据")
    @RequestMapping(value = "updateEquipmentMonitor",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code =102501,message = "机房编号不能为空"),
            @ApiResponse(code =102502,message = "管理员不能为空"),
            @ApiResponse(code =102503,message = "联系电话不能为空"),
            @ApiResponse(code = 102504,message = "主机数量不能为空"),
            @ApiResponse(code = 102505,message = "路由器数量不能为空"),
            @ApiResponse(code = 102506,message = "空调数量不能为空"),
            @ApiResponse(code = 102507,message = "机柜数量不能为空")
    })
    public  Result<Boolean> updateEquipmentMonitor(@RequestBody EquipmentMonitorDTO equipmentMonitorDTO ){
    	boolean flag = false;
    	try {
    		//1.校验
        	BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ROOMNUMBER_NULL, equipmentMonitorDTO.getRoomNumber());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ROOMADMIN_NULL,equipmentMonitorDTO.getRoomAdmin());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_CONTACTNUMBER_NULL,equipmentMonitorDTO.getContactNumber() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_HOSTNUM_NULL,equipmentMonitorDTO.getHostNum() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ROUTERNUM_NULL,equipmentMonitorDTO.getRouterNum() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_AIRCONNUM_NULL,equipmentMonitorDTO.getAirConNum() );
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_CABINETNUM_NULL,equipmentMonitorDTO.getCabinetNum() );
        	EquipmentMonitor map = dozerUtils.map(equipmentMonitorDTO, EquipmentMonitor.class);
        	map.setUpdateUser(BaseContextHandler.getAdminId().toString());
        	map.setUpdateTime(new Date());
        	equipmentMonitorService.updateByIdSelective(map);
        	flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return Result.success(flag);
    }
    /**
     * 删除设备管理
     * @param id
     * @return
     */
    @ApiOperation(value = "删除设备管理数据", notes = "删除设备管理数据")
    @RequestMapping(value = "deleteEquipmentMonitor",method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code =102500,message = "id不能为空")
    })
    public Result<Boolean> deleteEquipmentMonitor(@RequestParam Long id){
    	boolean flag = false;
    	try {
    		//1.校验
    	       BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITOR_ID_NULL, id);
    	       equipmentMonitorService.removeById(id);
    	       flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
       
       return Result.success(flag);
    }
    
    
    /**
     * 查询设备监控>报告数据列表
     *
     * @return
     */
    @ApiOperation(value = "查询设备监控>报告数据列表", notes = "查询设备监控>报告数据列表")
    @RequestMapping(value = "emrPageList", method = RequestMethod.POST)
    public Result<PageInfo<EquipmentMonitorReportDTO>> emrPageList(@RequestBody OpenApiReq<EquipmentMonitorReportDTO> openApiReq) {
    	//获取分页模糊查询入参
    	EquipmentMonitorReportDTO dto = openApiReq.getData();
        //设置查询条件
        PageHelper.startPage(openApiReq.getPageNo(), openApiReq.getPageSize());
        
        EquipmentMonitorReport emr = dozerUtils.map(dto, EquipmentMonitorReport.class);
        
        List<EquipmentMonitorReportDTO> list = dozerUtils.mapList(equipmentMonitorReportService.pageNewest(emr), EquipmentMonitorReportDTO.class);
        
        return Result.success(new PageInfo<>(list));
    }
    
    /**
     * 保存设备监控>报告数据
     * @param saveMachineDTO
     * @return
     */
    @ApiOperation(value = "保存设备监控>报告数据", notes = "保存设备监控>报告数据")
    @RequestMapping(value = "saveEquipmentMonitorReport",method = RequestMethod.POST)
    @ApiResponses({
    	 @ApiResponse(code =103001,message = "年度不能为空"),
         @ApiResponse(code =103002,message = "月度不能为空"),
         @ApiResponse(code =103003,message = "设备监控id不能为空")
    })
    public  Result<Boolean> saveEquipmentMonitorReport(@RequestBody EquipmentMonitorReportDTO equipmentMonitorReportDTO ){
    	boolean flag = false;
    	try {
    		String userId = BaseContextHandler.getAdminId().toString();
        	//1.校验
        	BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_YEAR_NULL, equipmentMonitorReportDTO.getYear());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_MONTH_NULL,equipmentMonitorReportDTO.getMonth());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_HOSTMGID_NULL,equipmentMonitorReportDTO.getHostMgId());
            EquipmentMonitorReport map = dozerUtils.map(equipmentMonitorReportDTO, EquipmentMonitorReport.class);
            map.setCreateTime(new Date());
            map.setIsDelete(0);
            map.setCreateUser(userId);
            map.setCreateUserName(BaseContextHandler.getName());
            map.setUpdateUser(userId);
            map.setUpdateTime(new Date());
            map = equipmentMonitorReportService.save(map);
            //附件
            List<Attachment> attachment = dozerUtils.mapList(equipmentMonitorReportDTO.getAttachment(),Attachment.class);
            dealAttach(attachment,map.getId(),userId);
            flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        return Result.success(flag);
    }
    /**
     * 编辑设备监控>报告数据
     * @param saveMachineDTO
     * @return
     */
    @ApiOperation(value = "编辑设备监控>报告数据", notes = "编辑设备监控>报告数据")
    @RequestMapping(value = "updateEquipmentMonitorReport",method = RequestMethod.POST)
    @ApiResponses({
            @ApiResponse(code =103001,message = "年度不能为空"),
            @ApiResponse(code =103002,message = "月度不能为空"),
            @ApiResponse(code =103003,message = "设备监控id不能为空")
    })
    public  Result<Boolean> updateEquipmentMonitorReport(@RequestBody EquipmentMonitorReportDTO equipmentMonitorReportDTO ){
    	boolean flag = false;
    	try {
    		String userId = BaseContextHandler.getAdminId().toString();
        	//1.校验
        	BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_YEAR_NULL, equipmentMonitorReportDTO.getYear());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_MONTH_NULL,equipmentMonitorReportDTO.getMonth());
            BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_HOSTMGID_NULL,equipmentMonitorReportDTO.getHostMgId());
        	EquipmentMonitorReport map = dozerUtils.map(equipmentMonitorReportDTO, EquipmentMonitorReport.class);
        	map.setCreateUserName(BaseContextHandler.getName());
        	map.setUpdateUser(userId);
        	map.setUpdateTime(new Date());
        	// 清除附件
        	attachmentService.deleteByBusId(map.getId());
        	// 保存附件
            List<Attachment> attachment = dozerUtils.mapList(equipmentMonitorReportDTO.getAttachment(),Attachment.class);
            dealAttach(attachment,map.getId(),userId);
            map.setCreateUserName(BaseContextHandler.getName());
        	equipmentMonitorReportService.updateByIdSelective(map);
        	flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return Result.success(flag);
    }
    /**
     * 删除设备管理>报告
     * @param id
     * @return
     */
    @ApiOperation(value = "删除设备管理>报告数据", notes = "删除设备管理>报告数据")
    @RequestMapping(value = "deleteEquipmentMonitorReport",method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code =103000,message = "id不能为空")
    })
    public Result<Boolean> deleteEquipmentMonitorReport(@RequestParam Long id){
		boolean flag = false;
		try {
			// 1.校验
			BizAssert.assertNotNull(HardWareExceptionCode.EQUIPMENTMONITORREPORT_ID_NULL, id);
			equipmentMonitorReportService.removeById(id);
			// 删除附件
			attachmentService.deleteByBusId(id);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}

		return Result.success(flag);
    }
    
    
    /**
     * 附件删除
     * @param id
     * @return
     */
    @ApiOperation(value = "附件删除", notes = "附件删除")
    @RequestMapping(value = "deleteAttachmentById",method = RequestMethod.GET)
    public Result<Boolean> deleteAttachmentById(@RequestParam Long id){
    	boolean flag = false;
		try {
			// 删除附件
			attachmentService.deleteById(id);
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Result.success(flag);
    }
    /**
     * 保存附件
     * @param attachment
     * @param busId
     * @param userId
     */
    private void dealAttach(List<Attachment> attachment,Long busId,String userId){
        if(null != attachment){
            attachment.stream().forEach(att -> {
                att.setBusId(busId);
                att.setCreateUser(userId);
                att.setUpdateUser(userId);
            });
            attachmentService.save(attachment);
        }
    }
}
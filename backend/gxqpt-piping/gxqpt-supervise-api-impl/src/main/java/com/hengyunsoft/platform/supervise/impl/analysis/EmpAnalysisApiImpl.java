package com.hengyunsoft.platform.supervise.impl.analysis;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.platform.admin.api.core.api.GxqptEmpApi;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpByUserNameDTO;
import com.hengyunsoft.platform.admin.api.core.dto.emp.GxqptEmpRetDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.*;
import com.hengyunsoft.platform.supervise.util.DateUtil;
import com.hengyunsoft.platform.supervise.util.Utils;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptDutyService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import com.hengyunsoft.platform.warn.repository.service.WarnScaleStatisticalService;
import com.hengyunsoft.utils.BizAssert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Api(value = "API - EmpAnalysisApiImpl.java", description = "人员预警统计API")
@RestController
@Slf4j
@RequestMapping("empanalysis")
public class EmpAnalysisApiImpl {
    @Autowired
    private GxqptDutyService dutyService;
    @Autowired
    private GxqptEmpApi empApi;
    @Autowired
    private GxqptWarnTypeService warnTypeService;
    @Autowired
    private WarnScaleStatisticalService warnScaleStatisticalService;
    /**
     * 获取各人员预警级别列表
     * @return
     */
    @ApiOperation(value="获取各人员预警级别列表",notes = "获取各人员预警级别列表")
    @RequestMapping(value = "/empLevelList",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56000, message = "人员不能为空"),
    })
    public Result<List<EmpsWarnLevelBackDTO>> getEmpWarnLevels(@RequestBody SurveyRecDTO surveyRecDTO){
    	//1.验证
    	List<String> ids = surveyRecDTO.getIds();
    	String depId = surveyRecDTO.getDepId();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, ids);
        //BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, depId);
        if(ids==null||ids.size()==0){
        	return null;
        }
        try {
        	EmpSurveyReqDTO surveyReqDTO = new EmpSurveyReqDTO();
        	String year = surveyRecDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		surveyReqDTO.setStartTime(date);        		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		surveyReqDTO.setEndTime(endDate);
        	}
        	surveyReqDTO.setIds(ids);      
        	surveyReqDTO.setDepId(depId);
            List<EmpsWarnLevelResDTO> list = dutyService.getEmpWarnLevels(surveyReqDTO);
            List<EmpsWarnLevelBackDTO> result = new ArrayList<EmpsWarnLevelBackDTO>();
            for(String id:ids){
            	EmpsWarnLevelBackDTO empsWarnLevelBackDTO = new EmpsWarnLevelBackDTO();
            	Map<String,Object> count = new HashMap<String,Object>();
            	String name = "";
            	for(EmpsWarnLevelResDTO empsWarnLevelResDTO:list){
            		String empid = empsWarnLevelResDTO.getId();
            		if(StringUtils.isEmpty(empid)){
            			continue;
            		}       		
            		if(empid.equals(id)){
            			name = empsWarnLevelResDTO.getName();  
            			count.put(String.valueOf(empsWarnLevelResDTO.getLevel()), empsWarnLevelResDTO.getCount());
            		}
            	}
            	if(!StringUtils.isEmpty(name)){
            		empsWarnLevelBackDTO.setName(name);
            		empsWarnLevelBackDTO.setCount(count);
            		empsWarnLevelBackDTO.setId(id);
            		result.add(empsWarnLevelBackDTO);
            	}           	
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTransLevel(result);
            }
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取各人员预警级别列表出错"+e);
			return Result.fail("获取各人员预警级别列表出错");
		}
    }
    /**
     * 获取各人员预警类别列表
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="获取各人员预警类别列表",notes = "获取各人员预警类别列表")
    @RequestMapping(value = "/empTypeList",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56000, message = "人员不能为空"),
    })
    public Result<List<SurveyBackResDTO>> getEmpartmentWarnTypes(@RequestBody SurveyRecDTO surveyRecDTO){
    	//1.验证
    	List<String> empIds = surveyRecDTO.getIds();
    	String depId = surveyRecDTO.getDepId();
        //BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, depId);
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_NULL, empIds);
        if(empIds==null||empIds.size()==0){
        	return null;
        }
        try {
	        //预警id筛选start
	        GxqptWarnTypeExample gxqptWarnTypeExample = new GxqptWarnTypeExample();
	        gxqptWarnTypeExample.createCriteria();
	        List<GxqptWarnType> gxqptWarnTypeList = warnTypeService.find(gxqptWarnTypeExample);
	        
	        GxqptWarnTypeExample gxqptWarnTypeExample1 = new GxqptWarnTypeExample();
	        gxqptWarnTypeExample1.createCriteria().andTypeNameEqualTo("应用预警");
	        List<GxqptWarnType> gxqptWarnType = warnTypeService.find(gxqptWarnTypeExample1);
	        if(gxqptWarnType!=null&&gxqptWarnType.size()!=0){
	        	List<GxqptWarnType> apps = Utils.selectTrees(gxqptWarnType,gxqptWarnTypeList);
	        	gxqptWarnTypeList.removeAll(apps);
	        	gxqptWarnTypeList.removeAll(gxqptWarnType);
	        }
	        Set<Long> ids = new HashSet<Long>();
	        for(GxqptWarnType warnType:gxqptWarnTypeList){
	        	if(warnType!=null&&warnType.getId()!=null){
	        		ids.add(warnType.getId());
	        	}       	
	        }
	        //预警id筛选end
	        //查询
	        SurveyReqDTO surveyReqDTO = new SurveyReqDTO();
        	String year = surveyRecDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		surveyReqDTO.setStartTime(date);        		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		surveyReqDTO.setEndTime(endDate);
        	}
        	surveyReqDTO.setIds(empIds);
        	surveyReqDTO.setTypeIds(ids);
        	surveyReqDTO.setDepId(depId);
        	List<SurveyBackResDTO> result = new ArrayList<SurveyBackResDTO>();
            List<WarnTypesResDTO> list = dutyService.getEmpWarnTypes(surveyReqDTO);
            for(String id:empIds){
            	SurveyBackResDTO warnTypesDTO = new SurveyBackResDTO();
            	Map<String,Object> count = new HashMap<String,Object>();
            	String name = "";
            	String typeId = "";
            	for(WarnTypesResDTO empWarnTypesResDTO:list){
            		String empid = empWarnTypesResDTO.getId();
            		if(StringUtils.isEmpty(empid)){
            			continue;
            		}       		
            		if(empid.equals(id)){
            			name = empWarnTypesResDTO.getName(); 
            			typeId = empWarnTypesResDTO.getId();
            			count.put(empWarnTypesResDTO.getType(), empWarnTypesResDTO.getCount());
            		}
            	}
            	if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(typeId)){
	            	warnTypesDTO.setName(name);
	            	warnTypesDTO.setId(typeId);
	            	warnTypesDTO.setCount(count);
	        		result.add(warnTypesDTO);    
            	}
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTrans(result);
            }
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取各人员预警类别列表出错"+e);
			return Result.fail("获取各人员预警类别列表出错");
		}
    }
    /**
     * 单个人员预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="单个人员预警类型统计分析",notes = "单个人员预警类型统计分析")
    @RequestMapping(value = "/warntype",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56001, message = "人员ID不能为空"),
    })
    public Result<List<EmpWarnTypeResDTO>> getWarnTypes(@RequestBody EmpWarnTypeReqDTO empWarnTypeReqDTO){
    	//1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, empWarnTypeReqDTO.getEmpId());
        //BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, empWarnTypeReqDTO.getDepId());
        if(empWarnTypeReqDTO.getEmpId()==null||"".equals(empWarnTypeReqDTO.getEmpId())){
        	return null;
        }
        try {
        	EmpWarnCheckDTO empWarnTypeCheckDTO = new EmpWarnCheckDTO();
        	String year = empWarnTypeReqDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		empWarnTypeCheckDTO.setStartTime(date);        		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		empWarnTypeCheckDTO.setEndTime(endDate);
        	}
        	empWarnTypeCheckDTO.setEmpId(empWarnTypeReqDTO.getEmpId());
        	empWarnTypeCheckDTO.setDepId(empWarnTypeReqDTO.getDepId());
            List<EmpWarnTypeResDTO> list = dutyService.getWarnTypes(empWarnTypeCheckDTO);
            return Result.success(list);
		} catch (Exception e) {
			log.error("单个人员预警类型统计分析出错"+e);
			return Result.fail("单个人员预警类型统计分析出错");
		}
    }
    /**
     * 单个人员预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="单个人员预警级别统计分析",notes = "单个人员预警级别统计分析")
    @RequestMapping(value = "/warnlevel",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56001, message = "人员ID不能为空"),
    })
    public Result<List<EmpWarnLevelResDTO>> getWarnLevels(@RequestBody EmpWarnTypeReqDTO empWarnTypeReqDTO){
    	//1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, empWarnTypeReqDTO.getEmpId());
        //BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, empWarnTypeReqDTO.getDepId());
        if(empWarnTypeReqDTO.getEmpId()==null||"".equals(empWarnTypeReqDTO.getEmpId())){
        	return null;
        }
        try {
        	EmpWarnCheckDTO empWarnCheckDTO = new EmpWarnCheckDTO();
        	String year = empWarnTypeReqDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		empWarnCheckDTO.setStartTime(date);        		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		empWarnCheckDTO.setEndTime(endDate);
        	}
        	empWarnCheckDTO.setEmpId(empWarnTypeReqDTO.getEmpId());
        	empWarnCheckDTO.setDepId(empWarnTypeReqDTO.getDepId());
            List<EmpWarnLevelResDTO> list = dutyService.getWarnLevels(empWarnCheckDTO);
            return Result.success(list);
		} catch (Exception e) {
			log.error("单个人员预警级别统计分析出错"+e);
			return Result.fail("单个人员预警级别统计分析出错");
		}
    }
    
    /**
     * 人员预警产生、处理情况
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="单个人员预警产生、处理情况",notes = "单个人员预警产生、处理情况")
    @RequestMapping(value = "/warnHandleStatistical",method = RequestMethod.GET)
    @ApiResponses({
        @ApiResponse(code = 56001, message = "人员ID不能为空"),
    })
    public Result<List<WarnScaleCountDTO>> getWarnProvHandle(@RequestParam(value = "id") String id,@RequestParam(value = "depId") String depId,
    		@RequestParam(value = "year") String year){
    	BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_EMP_ID, id);
        if(id==null||"".equals(id)){
        	return null;
        }
		try {
			ScaleReqDTO scaleReqDTO = new ScaleReqDTO();
			if(!StringUtils.isEmpty(year)){
				int date = Integer.valueOf(year);
				String startMonth = (date-1)+"12";
				String endMonth = (date+1)+"01";
				//修改 不用传年月  后台自行处理
				scaleReqDTO.setStartMonth(startMonth);
				scaleReqDTO.setEndMonth(endMonth);
				scaleReqDTO.setYear(year);
			}
			scaleReqDTO.setId(id);
			List<WarnScaleCountDTO> list = warnScaleStatisticalService.getScaleByEmpId(scaleReqDTO);
			return Result.success(list);
		} catch (Exception e) {
			log.error("单个人员预警产生、处理情况出错"+e);
			return Result.fail("单个人员预警产生、处理情况出错");
		}
    }
    /**
     * 同步权限系统人员名称
     * @param list
     */
    private <T extends SurveyBackResDTO> void orgNodeTrans(List<T> list){
    	List<String> ids = list.stream().map(SurveyBackResDTO::getId).collect(Collectors.toList());
    	GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
        dto.setUserIds(ids);
        dto.setPageNo(1);
        dto.setPageSize(ids.size());
        List<GxqptEmpRetDTO> empDate = empApi.findEmpByUserIds(dto).getData().getList();
        empDate.forEach(obj ->{
            if (ids.indexOf(obj.getId())!=-1){
                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
            }
        });
    }
    /**
     * 同步权限系统人员名称(级别)
     * @param list
     */
    private <T extends EmpsWarnLevelBackDTO> void orgNodeTransLevel(List<T> list){
    	List<String> ids = list.stream().map(EmpsWarnLevelBackDTO::getId).collect(Collectors.toList());
    	GxqptEmpByUserNameDTO dto = new GxqptEmpByUserNameDTO();
        dto.setUserIds(ids);
        dto.setPageNo(1);
        dto.setPageSize(ids.size());
        List<GxqptEmpRetDTO> empDate = empApi.findEmpByUserIds(dto).getData().getList();
        empDate.forEach(obj ->{
            if (ids.indexOf(obj.getId())!=-1){
                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
            }
        });
    }
}

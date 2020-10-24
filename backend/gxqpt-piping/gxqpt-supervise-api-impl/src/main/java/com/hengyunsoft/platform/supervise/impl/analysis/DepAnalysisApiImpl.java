package com.hengyunsoft.platform.supervise.impl.analysis;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.exception.core.AuthorityExceptionCode;
import com.hengyunsoft.platform.admin.api.core.api.GxqptDpmApi;
import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.DepWarnCheckDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.DepWarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyBackResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyRecDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnLevelBackDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnScaleCountDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypeReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypeResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypesResDTO;
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

@Api(value = "API - DepAnalysisApiImpl.java", description = "部门预警统计API")
@RestController
@Slf4j
@RequestMapping("depanalysis")
public class DepAnalysisApiImpl {
	
    @Autowired
    private GxqptDutyService dutyService;
    @Autowired
    private GxqptDpmApi dpmApi;
    @Autowired
    private GxqptWarnTypeService warnTypeService;
    @Autowired
    private WarnScaleStatisticalService warnScaleStatisticalService;
    
	/**
     * 获取部门预警类别列表
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="获取部门预警类别列表",notes = "获取部门预警类别列表")
    @RequestMapping(value = "/departmentTypeList",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56010, message = "部门不能为空"),
    })
    public Result<List<SurveyBackResDTO>> getDepartmentWarnTypes(@RequestBody SurveyRecDTO depSurveyRecDTO){
    	//1.验证
    	List<String> depIds = depSurveyRecDTO.getIds();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_NULL, depIds);
        if(depIds==null||depIds.size()==0){
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
	        SurveyReqDTO depSurveyReqDTO = new SurveyReqDTO();
        	String year = depSurveyRecDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		depSurveyReqDTO.setStartTime(date);       		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		depSurveyReqDTO.setEndTime(endDate);
        	}
        	depSurveyReqDTO.setIds(depIds);
        	depSurveyReqDTO.setTypeIds(ids);
        	List<SurveyBackResDTO> result = new ArrayList<SurveyBackResDTO>();
            List<WarnTypesResDTO> list = dutyService.getDepartmentWarnTypes(depSurveyReqDTO);
            for(String id:depIds){
            	SurveyBackResDTO depWarnTypesDTO = new SurveyBackResDTO();
            	Map<String,Object> count = new HashMap<String,Object>();
            	String name = "";
            	String typeId = "";
            	for(WarnTypesResDTO depWarnTypesResDTO:list){
            		String depid = depWarnTypesResDTO.getId();
            		if(StringUtils.isEmpty(depid)){
            			continue;
            		}       		
            		if(depid.equals(id)){
            			name = depWarnTypesResDTO.getName(); 
            			typeId = depWarnTypesResDTO.getId();
            			count.put(depWarnTypesResDTO.getType(), depWarnTypesResDTO.getCount());
            		}
            	}
            	if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(typeId)){
                	depWarnTypesDTO.setName(name);
                	depWarnTypesDTO.setId(typeId);
                	depWarnTypesDTO.setCount(count);
            		result.add(depWarnTypesDTO);
            	}        	
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTrans(result);
            }
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取部门预警类别列表出错"+e);
			return Result.fail("获取部门预警类别列表出错");
		}
    }
    
	/**
     * 获取部门预警级别列表
     * @return
     */
    @ApiOperation(value="获取各部门预警级别列表",notes = "获取各部门预警级别列表")
    @RequestMapping(value = "/departmentLevelList",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56010, message = "部门不能为空"),
    })
    public Result<List<WarnLevelBackDTO>> getDepartmentWarnLevels(@RequestBody SurveyRecDTO surveyRecDTO){
    	//1.验证
    	List<String> ids = surveyRecDTO.getIds();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_NULL, ids);
        if(ids==null||ids.size()==0){
        	return null;
        }
        try {
        	SurveyReqDTO depSurveyReqDTO = new SurveyReqDTO();
        	String year = surveyRecDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		depSurveyReqDTO.setStartTime(date);       		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		depSurveyReqDTO.setEndTime(endDate);
        	}
        	depSurveyReqDTO.setIds(ids);
            List<WarnLevelResDTO> list = dutyService.getDepartmentWarnLevels(depSurveyReqDTO);
            List<WarnLevelBackDTO> result = new ArrayList<WarnLevelBackDTO>();
            for(String id:ids){
            	WarnLevelBackDTO depsWarnLevelBackDTO = new WarnLevelBackDTO();
            	Map<String,Object> count = new HashMap<String,Object>();
            	String name = "";
            	for(WarnLevelResDTO depsWarnLevelResDTO:list){
            		String depid = depsWarnLevelResDTO.getId();
            		if(StringUtils.isEmpty(depid)){
            			continue;
            		}       		
            		if(depid.equals(id)){
            			name = depsWarnLevelResDTO.getName();  
            			count.put(String.valueOf(depsWarnLevelResDTO.getLevel()), depsWarnLevelResDTO.getCount());
            		}
            	}
            	if(!StringUtils.isEmpty(name)){
	        		depsWarnLevelBackDTO.setName(name);
	        		depsWarnLevelBackDTO.setCount(count);
	        		depsWarnLevelBackDTO.setId(id);
	        		result.add(depsWarnLevelBackDTO); 
            	}
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTransLevel(result);
            }            
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取各部门预警级别列表出错"+e);
			return Result.fail("获取各部门预警级别列表出错");
		}
    }
    /**
     * 单个部门预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="单个部门预警类型统计分析",notes = "单个部门预警类型统计分析")
    @RequestMapping(value = "/warntype",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56011, message = "部门id不能为空"),
    })
    public Result<List<WarnTypeResDTO>> getWarnTypes(@RequestBody WarnTypeReqDTO depWarnTypeReqDTO){
    	//1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, depWarnTypeReqDTO.getId());
        if(depWarnTypeReqDTO.getId()==null||"".equals(depWarnTypeReqDTO.getId())){
        	return null;
        }
        try {
        	DepWarnCheckDTO depWarnTypeCheckDTO = new DepWarnCheckDTO();
        	String year = depWarnTypeReqDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		depWarnTypeCheckDTO.setStartTime(date);       		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		depWarnTypeCheckDTO.setEndTime(endDate);
        	}
        	depWarnTypeCheckDTO.setDepartmentId(depWarnTypeReqDTO.getId());
            List<WarnTypeResDTO> list = dutyService.getWarnTypes(depWarnTypeCheckDTO);
            return Result.success(list);
		} catch (Exception e) {
			log.error("单个部门预警类型统计分析出错"+e);
			return Result.fail("单个部门预警类型统计分析出错");
		}
    }
    /**
     * 单个部门预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="单个部门预警级别统计分析",notes = "单个部门预警级别统计分析")
    @RequestMapping(value = "/warnlevel",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56011, message = "部门id不能为空"),
    })
    public Result<List<DepWarnLevelResDTO>> getWarnLevels(@RequestBody WarnTypeReqDTO depWarnTypeReqDTO){
    	//1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, depWarnTypeReqDTO.getId());
        if(depWarnTypeReqDTO.getId()==null||"".equals(depWarnTypeReqDTO.getId())){
        	return null;
        }
        try {
        	DepWarnCheckDTO depWarnCheckDTO = new DepWarnCheckDTO();
        	String year = depWarnTypeReqDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		depWarnCheckDTO.setStartTime(date);       		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		depWarnCheckDTO.setEndTime(endDate);
        	}
        	depWarnCheckDTO.setDepartmentId(depWarnTypeReqDTO.getId());
            List<DepWarnLevelResDTO> list = dutyService.getWarnLevels(depWarnCheckDTO);
            return Result.success(list);
		} catch (Exception e) {
			log.error("单个部门预警级别统计分析出错"+e);
			return Result.fail("单个部门预警级别统计分析出错");
		}
    }
    
    /**
     * 部门预警产生、处理情况
     * @param surveyReqDTO
     * @return
     */
    @ApiOperation(value="单个部门预警产生、处理情况",notes = "单个部门预警产生、处理情况")
    @RequestMapping(value = "/warnHandleStatistical",method = RequestMethod.GET)
    @ApiResponses({
        @ApiResponse(code = 56011, message = "部门id不能为空"),
    })
    public Result<List<WarnScaleCountDTO>> getWarnProvHandle(@RequestParam(value = "id") String id,
    		@RequestParam(value = "year") String year){
    	BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_DPM_ID, id);
        if(id==null||"".equals(id)){
        	return null;
        }
		try {
			ScaleReqDTO scaleReqDTO = new ScaleReqDTO();
			if(!StringUtils.isEmpty(year)){
				int date = Integer.valueOf(year);
				String startMonth = (date-1)+"12";
				String endMonth = (date+1)+"01";
				scaleReqDTO.setStartMonth(startMonth);
				scaleReqDTO.setEndMonth(endMonth);
				scaleReqDTO.setYear(year);
			}
			scaleReqDTO.setId(id);
			List<WarnScaleCountDTO> list = warnScaleStatisticalService.getScaleByDepId(scaleReqDTO);
			return Result.success(list);
		} catch (Exception e) {
			log.error("单个部门预警产生、处理情况出错"+e);
			return Result.fail("单个部门预警产生、处理情况出错");
		}
    }
    
    /**
     * 同步权限系统部门名称
     * @param list
     */
    private <T extends SurveyBackResDTO> void orgNodeTrans(List<T> list){
    	List<String> ids = list.stream().map(SurveyBackResDTO::getId).collect(Collectors.toList());
        List<GxqptDpmResDTO> dpmDate = dpmApi.findDpmNameByIds(ids).getData();
        dpmDate.forEach(obj ->{
            if (ids.indexOf(obj.getId())!=-1){
                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
            }
        });
    }
    /**
     * 同步权限系统部门名称(级别)
     * @param list
     */
    private <T extends WarnLevelBackDTO> void orgNodeTransLevel(List<T> list){
    	List<String> ids = list.stream().map(WarnLevelBackDTO::getId).collect(Collectors.toList());
        List<GxqptDpmResDTO> dpmDate = dpmApi.findDpmNameByIds(ids).getData();
        dpmDate.forEach(obj ->{
            if (ids.indexOf(obj.getId())!=-1){
                list.get(ids.indexOf(obj.getId())).setName(obj.getName());
            }
        });
    }
}

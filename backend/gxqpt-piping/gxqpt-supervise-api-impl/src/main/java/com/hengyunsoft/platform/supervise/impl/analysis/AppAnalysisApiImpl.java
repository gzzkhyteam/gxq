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
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationAllDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.AppWarnCheckDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.DepWarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.ScaleReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyBackResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyRecDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.SurveyReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnLevelBackDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnLevelResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypeReqDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypeResDTO;
import com.hengyunsoft.platform.supervise.dto.analysis.WarnTypesResDTO;
import com.hengyunsoft.platform.supervise.util.DateUtil;
import com.hengyunsoft.platform.supervise.util.Utils;
import com.hengyunsoft.platform.warn.entity.domain.FairWarnTimeSlotCountDO;
import com.hengyunsoft.platform.warn.entity.po.GxqptWarnType;
import com.hengyunsoft.platform.warn.repository.example.GxqptWarnTypeExample;
import com.hengyunsoft.platform.warn.repository.service.GxqptDutyService;
import com.hengyunsoft.platform.warn.repository.service.GxqptWarnTypeService;
import com.hengyunsoft.platform.warn.repository.service.WarnTimeSlotService;
import com.hengyunsoft.utils.BizAssert;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Api(value = "API - AppAnalysisApiImpl.java", description = "应用预警统计API")
@RestController
@Slf4j
@RequestMapping("appanalysis")
public class AppAnalysisApiImpl {
    @Autowired
    private GxqptDutyService dutyService;
    @Autowired
    private ApplicationApi applicationApi;
    @Autowired
    private GxqptWarnTypeService warnTypeService;
	@Autowired
	private WarnTimeSlotService warnTimeSlotService;
    /**
     * 获取应用预警类别列表
     * @param surveyReqDTO
     * @return
     */
	@ApiOperation(value="获取各应用预警类别列表",notes = "获取各应用预警类别列表")
    @RequestMapping(value = "/findTypeList",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56034, message = "应用不能为空"),
    })
    public Result<List<SurveyBackResDTO>> getAppWarnTypes(@RequestBody SurveyRecDTO surveyRecDTO){
    	//1.验证
    	List<String> appIds = surveyRecDTO.getIds();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_APP_NULL, appIds);
        if(appIds.size()==0){
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
	        List<GxqptWarnType> apps = new ArrayList<GxqptWarnType>();
	        if(gxqptWarnType!=null&&gxqptWarnType.size()!=0){
	        	apps = Utils.selectTrees(gxqptWarnType,gxqptWarnTypeList);
	        }else{
	        	return null;
	        }
	        Set<Long> ids = new HashSet<Long>();
	        for(GxqptWarnType warnType:apps){
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
        	surveyReqDTO.setIds(appIds);
        	surveyReqDTO.setTypeIds(ids);
        	List<SurveyBackResDTO> result = new ArrayList<SurveyBackResDTO>();
            List<WarnTypesResDTO> list = dutyService.getAppWarnTypes(surveyReqDTO);
            for(String id:appIds){
            	SurveyBackResDTO appWarnTypesDTO = new SurveyBackResDTO();
            	Map<String,Object> count = new HashMap<String,Object>();
            	String name = "";
            	String typeId = "";
            	for(WarnTypesResDTO appWarnTypesResDTO:list){
            		String appid = appWarnTypesResDTO.getId();
            		if(StringUtils.isEmpty(appid)){
            			continue;
            		}       		
            		if(appid.equals(id)){
            			name = appWarnTypesResDTO.getName(); 
            			typeId = appWarnTypesResDTO.getId();
            			count.put(appWarnTypesResDTO.getType(), appWarnTypesResDTO.getCount());
            		}
            	}
            	if(!StringUtils.isEmpty(name)&&!StringUtils.isEmpty(typeId)){
                	appWarnTypesDTO.setName(name);
                	appWarnTypesDTO.setId(typeId);
                	appWarnTypesDTO.setCount(count);
            		result.add(appWarnTypesDTO);
            	}        	
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTrans(result);
            }
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取各应用预警类别列表出错"+e);
			return Result.fail("获取各应用预警类别列表出错");
		}
    }
    
	/**
     * 获取各应用预警级别列表
     * @return
     */
	@ApiOperation(value="获取各应用预警级别列表",notes = "获取各应用预警级别列表")
    @RequestMapping(value = "/findLevelList",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56034, message = "应用不能为空"),
    })
    public Result<List<WarnLevelBackDTO>> getAppWarnLevels(@RequestBody SurveyRecDTO surveyRecDTO){
    	//1.验证
    	List<String> ids = surveyRecDTO.getIds();
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_APP_NULL, ids);
        if(ids.size()==0){
        	return null;
        }
        try {
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
        	surveyReqDTO.setIds(ids);
            List<WarnLevelResDTO> list = dutyService.getAppWarnLevels(surveyReqDTO);
            List<WarnLevelBackDTO> result = new ArrayList<WarnLevelBackDTO>();
            for(String id:ids){
            	WarnLevelBackDTO appsWarnLevelBackDTO = new WarnLevelBackDTO();
            	Map<String,Object> count = new HashMap<String,Object>();
            	String name = "";
            	for(WarnLevelResDTO appsWarnLevelResDTO:list){
            		String appid = appsWarnLevelResDTO.getId();
            		if(StringUtils.isEmpty(appid)){
            			continue;
            		}       		
            		if(appid.equals(id)){
            			name = appsWarnLevelResDTO.getName();  
            			count.put(String.valueOf(appsWarnLevelResDTO.getLevel()), appsWarnLevelResDTO.getCount());
            		}
            	}
            	if(!StringUtils.isEmpty(name)){
                	appsWarnLevelBackDTO.setName(name);
                	appsWarnLevelBackDTO.setCount(count);
                	appsWarnLevelBackDTO.setId(id);
            		result.add(appsWarnLevelBackDTO);            		
            	}        	
            }
            if(result!=null&&result.size()!=0){
            	orgNodeTransLevel(result);
            }
            return Result.success(result);
		} catch (Exception e) {
			log.error("获取各应用预警级别列表出错"+e);
			return Result.fail("获取各应用预警级别列表出错");
		}
    }
    /**
     * 单个应用预警类型统计分析
     * @param surveyReqDTO
     * @return
     */
	@ApiOperation(value="单个应用预警类型统计分析",notes = "单个应用预警类型统计分析")
    @RequestMapping(value = "/warntype",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56035, message = "应用id不能为空"),
    })
    public Result<Map<String,List<WarnTypeResDTO>>> getWarnTypes(@RequestBody WarnTypeReqDTO warnTypeReqDTO){
    	//1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_APP_ID, warnTypeReqDTO.getId());
        if("".equals(warnTypeReqDTO.getId())){
        	return null;
        }
        try {
        	Map<String,List<WarnTypeResDTO>> map = new HashMap<String,List<WarnTypeResDTO>>();
        	AppWarnCheckDTO appWarnTypeCheckDTO = new AppWarnCheckDTO();
        	String year = warnTypeReqDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		appWarnTypeCheckDTO.setStartTime(date);        		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		appWarnTypeCheckDTO.setEndTime(endDate);
        	}
        	appWarnTypeCheckDTO.setAppId(warnTypeReqDTO.getId());        	
            List<WarnTypeResDTO> list = dutyService.getAppWarnTypes(appWarnTypeCheckDTO);
            List<WarnTypeResDTO> list1 = dutyService.getAppWarnTypeAvg(appWarnTypeCheckDTO);
            map.put("app", list);
            map.put("avg", list1);
            return Result.success(map);
		} catch (Exception e) {
			log.error("单个应用预警类型统计分析出错"+e);
			return Result.fail("单个应用预警类型统计分析出错");
		}
    }
    /**
     * 单个应用预警级别统计分析
     * @param surveyReqDTO
     * @return
     */
	@ApiOperation(value="单个应用预警级别统计分析",notes = "单个应用预警级别统计分析")
    @RequestMapping(value = "/warnlevel",method = RequestMethod.POST)
    @ApiResponses({
        @ApiResponse(code = 56035, message = "应用id不能为空"),
    })
    public Result<Map<String,List<DepWarnLevelResDTO>>> getWarnLevels(@RequestBody WarnTypeReqDTO warnTypeReqDTO){
    	//1.验证
        BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_APP_ID, warnTypeReqDTO.getId());
        if("".equals(warnTypeReqDTO.getId())){
        	return null;
        }
        try {
        	AppWarnCheckDTO appWarnCheckDTO = new AppWarnCheckDTO();
        	String year = warnTypeReqDTO.getYear();
        	if(!StringUtils.isEmpty(year)){ 
        		int yearNum = Integer.parseInt(year);
        		Date date = DateUtil.yearToDate(year);
        		appWarnCheckDTO.setStartTime(date);        		
        		String endTime = String.valueOf(yearNum+1);
        		Date endDate = DateUtil.yearToDate(endTime);
        		appWarnCheckDTO.setEndTime(endDate);
        	}
        	appWarnCheckDTO.setAppId(warnTypeReqDTO.getId());
        	Map<String,List<DepWarnLevelResDTO>> map = new HashMap<String,List<DepWarnLevelResDTO>>();
            List<DepWarnLevelResDTO> list = dutyService.getAppWarnLevels(appWarnCheckDTO);
            List<DepWarnLevelResDTO> list1 = dutyService.getAppWarnLevelAvg(appWarnCheckDTO);
            map.put("app", list);
            map.put("avg", list1);
            return Result.success(map);
		} catch (Exception e) {
			log.error("单个应用预警级别统计分析出错"+e);
			return Result.fail("单个应用预警级别统计分析出错");
		}
    }
    
    /**
     * 应用预警产生、处理情况
     * @param surveyReqDTO
     * @return
     */
	@ApiOperation(value="单个应用预警产生、处理情况",notes = "单个应用预警产生、处理情况")
    @RequestMapping(value = "/warnHandleStatistical",method = RequestMethod.GET)
    @ApiResponses({
        @ApiResponse(code = 56035, message = "应用id不能为空"),
    })
    public Result<List<FairWarnTimeSlotCountDO>> getWarnProvHandle(@RequestParam(value = "appid") String appid,
    		@RequestParam(value = "year") String year){
    	BizAssert.assertNotNull(AuthorityExceptionCode.GXQPT_APP_ID, appid);
        if("".equals(appid)){
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
    		}			
			scaleReqDTO.setId(appid);
			List<FairWarnTimeSlotCountDO> list = warnTimeSlotService.getScaleByAppId(scaleReqDTO);
			return Result.success(list);
		} catch (Exception e) {
			log.error("单个应用预警产生、处理情况出错"+e);
			return Result.fail("单个应用预警产生、处理情况出错");
		}
    }

	/**
     * 同步权限系统应用名称
     * @param list
     */
    private <T extends SurveyBackResDTO> void orgNodeTrans(List<T> list){
    	List<String> ids = list.stream().map(SurveyBackResDTO::getId).collect(Collectors.toList());
    	List<ApplicationAllDTO> appDate = applicationApi.findAllList().getData();
        appDate.forEach(obj ->{
            if (ids.indexOf(obj.getAppId())!=-1){
                list.get(ids.indexOf(obj.getAppId())).setName(obj.getName());
            }
        });
    }
    /**
     * 同步权限系统应用名称(级别)
     * @param list
     */
    private <T extends WarnLevelBackDTO> void orgNodeTransLevel(List<T> list){
    	List<String> ids = list.stream().map(WarnLevelBackDTO::getId).collect(Collectors.toList());
    	List<ApplicationAllDTO> appDate = applicationApi.findAllList().getData();
        appDate.forEach(obj ->{
            if (ids.indexOf(obj.getAppId())!=-1){
                list.get(ids.indexOf(obj.getAppId())).setName(obj.getName());
            }
        });
    }
}

package com.hengyunsoft.platform.developer.impl.screen;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.ReducedCostScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisListDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.ReducedCostDTO;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.utils.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author farglory
 * @create 2018-04-30 21:37
 * @desc 降本提质大屏Api实现
 **/
@Api(value = "API - ReducedCostScreenApiImpl", description = "大屏降本提质查询")
@RestController
@RequestMapping("reducedCost")
@Slf4j
public class ReducedCostScreenApiImpl implements ReducedCostScreenApi {
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ServiceModuleService serviceModuleService;

    @Override
    @ApiOperation(value = "查询所有组件预估价值", notes = "查询所有组件预估价值")
    @RequestMapping(value = "/componentEstimatedValue", method = RequestMethod.GET)
    public Result<ReducedCostDTO> componentEstimatedValue() {
//    	ReducedCostDTO reducedCostDTO = new ReducedCostDTO();
//		// 获取应用数
//    	List<Map<String,Object>> applicationList = applicationService.findComponentEstimatedValue();
//
//    	List<Object> name = new ArrayList<Object>();
//    	List<Object> reduceTimeNum = new ArrayList<Object>();
//    	List<Object> reduceCostNum = new ArrayList<Object>();
//
//		if(applicationList !=null && applicationList.size()>0) {
//			for (Map<String,Object> object : applicationList) {
//				name.add(object.get("name_"));
//				reduceTimeNum.add(object.get("reduce_time"));
//    			reduceCostNum.add(object.get("reduce_cost"));
//			}
//    	}
//    	// 获取功能模块数
//    	List<Map<String,Object>> serviceModulelist = serviceModuleService.findComponentEstimatedValue();
//    	if(serviceModulelist !=null && serviceModulelist.size()>0) {
//    		for (Map<String,Object> object : serviceModulelist) {
//				name.add(object.get("name_"));
//				reduceTimeNum.add(object.get("reduce_time"));
//    			reduceCostNum.add(object.get("reduce_cost"));
//			}
//    	}
//    	reducedCostDTO.setNameList(name);
//    	reducedCostDTO.setReduceCostNumlist(reduceCostNum);
//    	reducedCostDTO.setReduceTimeNumlist(reduceTimeNum);
//
//    	// 总数统计
//    	List<Map<String,Object>>  applicationTotalList =applicationService.findTotalStatistics();
//    	if(applicationTotalList != null && applicationTotalList.size()>0) {
//    		for (Map<String, Object> map : applicationTotalList) {
//    			reducedCostDTO.setReduceCostTotal(map.get("application_total")+"");
//        		reducedCostDTO.setReduceTimeTotal(map.get("application_total")+"");
//        		reducedCostDTO.setUseApplicationTotal(map.get("application_total")+"");
//			}
//    	}else {
//    		reducedCostDTO.setReduceCostTotal(0+"");
//    		reducedCostDTO.setReduceTimeTotal(0+"");
//    		reducedCostDTO.setUseApplicationTotal(0+"");
//    	}
//    	List<Map<String,Object>>  moduleTotalList =serviceModuleService.findTotalStatistics();
//    	if(moduleTotalList != null && moduleTotalList.size()>0) {
//    		for (Map<String, Object> map : moduleTotalList) {
//    			reducedCostDTO.setUseModuleTotal(map.get("module_total")+"");
//			}
//    	}else {
//    		reducedCostDTO.setUseModuleTotal(0+"");
//    	}
//		return Result.success(reducedCostDTO);
        try {
            return Result.success(ExcelUtil.componentEstimatedValue());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }

    @Override
    @ApiOperation(value = "查询所有组件预估价值", notes = "查询所有组件预估价值")
    @RequestMapping(value = "/reducedExample", method = RequestMethod.GET)
    public Result<ApplicationReduceAnalysisListDTO> reducedExample() {
        try {
            return Result.success(ExcelUtil.reducedExample());
        } catch (Exception e) {
            log.error("读取Excel失败！", e);
        }
        return Result.fail("fail");
    }
}

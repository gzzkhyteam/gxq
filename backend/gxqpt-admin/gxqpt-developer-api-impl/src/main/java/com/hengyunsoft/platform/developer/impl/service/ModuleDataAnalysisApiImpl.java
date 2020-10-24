package com.hengyunsoft.platform.developer.impl.service;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.developer.entity.apply.po.Application;
import com.hengyunsoft.platform.developer.entity.core.po.ModuleUseInfo;
import com.hengyunsoft.platform.developer.repository.apply.example.ApplicationExample;
import com.hengyunsoft.platform.developer.repository.apply.service.ApplicationService;
import com.hengyunsoft.platform.developer.repository.apply.service.ServiceModuleService;
import com.hengyunsoft.platform.developer.repository.core.example.LoginAmountExample;
import com.hengyunsoft.platform.developer.repository.core.example.ModuleUseInfoExample;
import com.hengyunsoft.platform.developer.repository.core.service.LoginAmountApiService;
import com.hengyunsoft.platform.developer.repository.service.service.ModuleUseJnlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * com.hengyunsoft.platform.developer.api.service.api
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：数据统计Api
 * 修改人：wt
 * 修改时间：2018/9/4
 * 修改内容：
 */
@Data
@Api(value = "API-ModuleDataAnalysisApiImpl.java", description = "数据统计Api")
@RestController
@RequestMapping("module")
@Slf4j
public class ModuleDataAnalysisApiImpl {

    @Autowired
    ModuleUseJnlService moduleUseJnlService;

    @Autowired
    private ServiceModuleService serviceModuleService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private LoginAmountApiService loginAmountApiService;

    /**
     * 描述：对外接口数据统计
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/9/4
     * 修改内容：
     */
    @ApiOperation(value = "对外接口数据统计", notes = "对外接口数据统计")
    @ApiResponses({
    })
    @RequestMapping(value = "/dataAnalysis", method = RequestMethod.GET)
    public Result<Map<String,Object>> dataAnalysis() {
        Map<String,Object> result = new HashMap<String,Object>();
        String [] yearMonthArray = DateUtils.getLatest12Month();
        result.put("yMonthArray",yearMonthArray);
        List<Map<String,Object>> serverUseTop = serviceModuleService.getServerUseTop();
        result.put("useTop",serverUseTop);
        ApplicationExample example = new ApplicationExample();
        List<Short> params = new ArrayList<Short>();
        params.add((short)2);
        params.add((short)3);
        example.createCriteria().andAppTypeIn(params);
        List<Application> applicationList = applicationService.find(example);
        List<String> appIdList = new ArrayList<String>();
        for (Application curr : applicationList){
            appIdList.add(curr.getAppId());
        }
        Integer appCount = applicationList.size();
        List<Integer> serverNumList = new ArrayList<Integer>();
        List<Double> serverRateList = new ArrayList<Double>();
        for(int i=0; i<12; i++){
            Date startDate = DateUtils.getDate(yearMonthArray[i]+"-01 00:00:00");
            Date endDate = DateUtils.getDate(yearMonthArray[i]+"-31 23:59:59");
            ModuleUseInfoExample moduleUseInfoExample = new ModuleUseInfoExample();
            moduleUseInfoExample.createCriteria().andAppIdIn(appIdList).andUpdateTimeBetween(startDate,endDate);
            moduleUseInfoExample.setGroupByClause("app_id");
            List<ModuleUseInfo> moduleUseInfoList = moduleUseJnlService.find(moduleUseInfoExample);
            Integer useNumber = moduleUseInfoList.size();
            serverNumList.add(useNumber);
            if(useNumber != 0) {
                BigDecimal value1 = new BigDecimal(appCount + "");
                BigDecimal value2 = new BigDecimal(useNumber + "");
                BigDecimal value3 = new BigDecimal(100 + "");
                Double userRate = value2.divide(value1,2,BigDecimal.ROUND_HALF_UP).multiply(value3).doubleValue();
                serverRateList.add(userRate);
            }else{
                serverRateList.add(0.00);
            }
        }
        result.put("serverNum",serverNumList);
        result.put("serverRate",serverRateList);
        return Result.success(result);
    }

    /**
     * 描述：应用登录量数据统计
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/9/4
     * 修改内容：
     */
    @ApiOperation(value = "应用登录量数据统计", notes = "应用登录量数据统计")
    @ApiResponses({
    })
    @RequestMapping(value = "/loginAmount", method = RequestMethod.GET)
    public Result<Map<String,Object>> loginAmount() {
        Map<String,Object> result = new HashMap<String,Object>();
        String [] yearMonthArray = DateUtils.getLatest12Month();
        result.put("yMonthArray",yearMonthArray);
        ApplicationExample example = new ApplicationExample();
        List<Short> params = new ArrayList<Short>();
        params.add((short)1);
        params.add((short)3);
        example.createCriteria().andAppTypeIn(params);
        List<Application> applicationList = applicationService.find(example);
        List<String> appIdList = new ArrayList<String>();
        for (Application curr : applicationList){
            appIdList.add(curr.getAppId());
        }
        List<Integer> loginAmount = new ArrayList<Integer>();
        for(int i=0; i<12; i++) {
            Date startDate = DateUtils.getDate(yearMonthArray[i] + "-01 00:00:00");
            Date endDate = DateUtils.getDate(yearMonthArray[i] + "-31 23:59:59");
            LoginAmountExample loginLogsExample = new LoginAmountExample();
            loginLogsExample.createCriteria().andAppIdIn(appIdList).andLoginTimeBetween(startDate,endDate);
            Integer loginCount = loginAmountApiService.count(loginLogsExample);
            loginAmount.add(loginCount);
        }
        result.put("loginAmount",loginAmount);
        return Result.success(result);
    }

    /**
     * 描述：网站监控数据统计
     * 参数：
     * 返回值：
     * 修改人：wt
     * 修改时间：2018/9/4
     * 修改内容：
     */
    @ApiOperation(value = "网站监控数据统计", notes = "网站监控数据统计")
    @ApiResponses({
    })
    @RequestMapping(value = "/webMonitor", method = RequestMethod.GET)
    public Result<Map<String,Object>> webMonitor() {
        Map<String,Object> result = new HashMap<String,Object>();
        Date dayBegin = DateUtils.getDayBegin();
        ModuleUseInfoExample moduleUseInfoExample = new ModuleUseInfoExample();
        moduleUseInfoExample.createCriteria().andUpdateTimeBetween(dayBegin,new Date());
        Integer invokingNum = moduleUseJnlService.count(moduleUseInfoExample);
        result.put("invokingNum",invokingNum);

        ApplicationExample example = new ApplicationExample();
        List<Short> params = new ArrayList<Short>();
        params.add((short)2);
        params.add((short)3);
        example.createCriteria().andAppTypeIn(params);
        List<Application> applicationList = applicationService.find(example);
        List<String> appIdList = new ArrayList<String>();
        for (Application curr : applicationList){
            appIdList.add(curr.getAppId());
        }
        ModuleUseInfoExample appExample = new ModuleUseInfoExample();
        appExample.createCriteria().andAppIdIn(appIdList).andUpdateTimeBetween(dayBegin,new Date());
        appExample.setGroupByClause("app_id");
        List<ModuleUseInfo> appList = moduleUseJnlService.find(appExample);
        result.put("appNum",appList.size());

        LoginAmountExample loginLogsExample = new LoginAmountExample();
        loginLogsExample.createCriteria().andLoginTimeBetween(dayBegin,new Date());
        Integer userNum = loginAmountApiService.count(loginLogsExample);
        result.put("userNum",userNum);

        Calendar curr = Calendar.getInstance();
        Integer currYear = curr.get(Calendar.YEAR);
        Integer currMonth = curr.get(Calendar.MONTH )+1;
        curr.add(Calendar.MONTH, -1);
        Integer upYear = curr.get(Calendar.YEAR);
        Integer upMonth = curr.get(Calendar.MONTH )+1;
        Integer currDay = curr.get(Calendar.DATE);
        Integer[] monthDayArray = getCurrMonthDay();
        result.put("monthDayArray",monthDayArray);
        List<Integer> invokingCurrList = new ArrayList<Integer>();
        List<Integer> invokingUpList = new ArrayList<Integer>();
        List<Integer> userCurrList = new ArrayList<Integer>();
        List<Integer> userUpList = new ArrayList<Integer>();
        for (Integer monthDay : monthDayArray){
            if(monthDay <= currDay) {
                Date currStartDate = DateUtils.getDate(currYear + "-" + currMonth + "-" + monthDay + " 00:00:00");
                Date currEndDate = DateUtils.getDate(currYear + "-" + currMonth + "-" + monthDay + " 23:59:59");
                Date upStartDate = DateUtils.getDate(upYear + "-" + upMonth + "-" + monthDay + " 00:00:00");
                Date upEndDate = DateUtils.getDate(upYear + "-" + upMonth + "-" + monthDay + " 23:59:59");
                ModuleUseInfoExample invokingCurrExample = new ModuleUseInfoExample();
                invokingCurrExample.createCriteria().andUpdateTimeBetween(currStartDate,currEndDate);
                Integer currInvokingNum = moduleUseJnlService.count(invokingCurrExample);
                invokingCurrList.add(currInvokingNum);
                ModuleUseInfoExample invokingUpExample = new ModuleUseInfoExample();
                invokingUpExample.createCriteria().andUpdateTimeBetween(upStartDate,upEndDate);
                Integer upInvokingNum = moduleUseJnlService.count(invokingUpExample);
                invokingUpList.add(upInvokingNum);

                LoginAmountExample userCurrExample = new LoginAmountExample();
                userCurrExample.createCriteria().andLoginTimeBetween(currStartDate,currEndDate);
                Integer currUserNum = loginAmountApiService.count(userCurrExample);
                userCurrList.add(currUserNum);
                LoginAmountExample userUpExample = new LoginAmountExample();
                userUpExample.createCriteria().andLoginTimeBetween(upStartDate,upEndDate);
                Integer upUserNum = loginAmountApiService.count(userUpExample);
                userUpList.add(upUserNum);
            }else{
                invokingCurrList.add(0);
                invokingUpList.add(0);
                userCurrList.add(0);
                userUpList.add(0);
            }
        }
        result.put("invokingCurrList",invokingCurrList);
        result.put("invokingUpList",invokingUpList);
        result.put("userCurrList",userCurrList);
        result.put("userUpList",userUpList);

        List<Map<String,Object>> invokingTop = serviceModuleService.getMonthInvokingTop();
        List<Map<String,Object>> appTop = serviceModuleService.getMonthAppTop();
        result.put("invokingTop",invokingTop);
        result.put("appTop",appTop);
        return Result.success(result);
    }


    /**
     * 获取当月天数数组集合
     * @return
     */
    private static Integer[] getCurrMonthDay(){
        Integer monthDay = DateUtils.getMonthDay(new Date());
        Integer[] result = new Integer[monthDay];
        for (int i = 0; i < monthDay; i++){
            result[i]=i+1;
        }
        return result;
    }

}
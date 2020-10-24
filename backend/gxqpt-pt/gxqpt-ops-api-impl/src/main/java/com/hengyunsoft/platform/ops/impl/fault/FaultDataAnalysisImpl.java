package com.hengyunsoft.platform.ops.impl.fault;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.platform.developer.api.core.api.ApplicationApi;
import com.hengyunsoft.platform.developer.api.core.dto.application.ApplicationSelectDTO;
import com.hengyunsoft.platform.ops.entity.fault.po.FaultManage;
import com.hengyunsoft.platform.ops.repository.fault.example.FaultManageExample;
import com.hengyunsoft.platform.ops.repository.fault.service.FaultManageService;
import com.hengyunsoft.security.auth.client.annotation.IgnoreToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import static com.hengyunsoft.platform.ops.impl.utils.OpsDateUtils.getDistHour;

@RestController
@Slf4j
@RequestMapping("fault")
@Api(value = "API - FaultDataAnalysisImpl", description = "共性服务分析")
public class FaultDataAnalysisImpl implements Serializable{

    @Autowired
    private FaultManageService faultManageService;
    @Autowired
    private ApplicationApi applicationApi;

    @RequestMapping(value = "fault/serviceAnalysis",method = RequestMethod.GET)
    @IgnoreToken
    @ApiOperation(value = "共性服务分析",notes = "共性服务分析")
    @ApiResponses({
    })
    public Result<Map<String,Object>> getServerFaultData(){
        Map<String,Object> result = new HashMap<String,Object>();
        String [] yearMonthArray = DateUtils.getLatest12Month();
        result.put("yMonthArray",yearMonthArray);
        List<ApplicationSelectDTO> serverList =  applicationApi.findByType((short)2).getData();
        List<String> appIdList = new ArrayList<String>();
        for (ApplicationSelectDTO curr : serverList){
            appIdList.add(curr.getAppId());
        }
        List<Integer> faultList = new ArrayList<Integer>();
        List<Integer> dealList = new ArrayList<Integer>();
        for(int i=0; i<12; i++) {
            Date startDate = DateUtils.getDate(yearMonthArray[i] + "-01 00:00:00");
            Date endDate = DateUtils.getDate(yearMonthArray[i] + "-31 23:59:59");
            FaultManageExample faulExample = new FaultManageExample();
            faulExample.createCriteria().andSystemIdIn(appIdList).andCreateTimeBetween(startDate,endDate).andDealTimeIsNull();
            Integer faultNum = faultManageService.count(faulExample);
            faultList.add(faultNum);
            FaultManageExample dealExample = new FaultManageExample();
            dealExample.createCriteria().andSystemIdIn(appIdList).andCreateTimeBetween(startDate,endDate).andDealTimeIsNotNull();
            Integer dealNum = faultManageService.count(dealExample);
            dealList.add(dealNum);
        }
        result.put("faultList",faultList);
        result.put("dealList",dealList);
        return Result.success(result);
    }

    @RequestMapping(value = "fault/appAnalysis",method = RequestMethod.GET)
    @IgnoreToken
    @ApiOperation(value = "共性应用分析",notes = "共性应用分析")
    @ApiResponses({
    })
    public Result<Map<String,Object>> getAppFaultData(){
        Map<String,Object> result = new HashMap<String,Object>();
        String [] yearMonthArray = DateUtils.getLatest12Month();
        result.put("yMonthArray",yearMonthArray);
        List<ApplicationSelectDTO> serverList =  applicationApi.findByType((short)1).getData();
        List<String> appIdList = new ArrayList<String>();
        for (ApplicationSelectDTO curr : serverList){
            appIdList.add(curr.getAppId());
        }
        Integer appCount = serverList.size();
        List<Double> faultAvgList = new ArrayList<Double>();
        List<Integer> faultNumList = new ArrayList<Integer>();
        List<Integer> faultDealList = new ArrayList<Integer>();
        List<Double> faultRateList = new ArrayList<Double>();
        for(int i=0; i<12; i++) {
            Date startDate = DateUtils.getDate(yearMonthArray[i] + "-01 00:00:00");
            Date endDate = DateUtils.getDate(yearMonthArray[i] + "-31 23:59:59");
            FaultManageExample example = new FaultManageExample();
            example.createCriteria().andSystemIdIn(appIdList).andCreateTimeBetween(startDate,endDate);
            List<FaultManage> faultManageList = faultManageService.find(example);
            Double countDay = 0.0;
            Integer faultDealNum = 0;
            for (FaultManage faultManage : faultManageList){
                if(faultManage.getDealTime() != null){
                    Date startTime = faultManage.getHappenTime();
                    Date endTime = faultManage.getDealTime();
                    countDay += getDistHour(startTime,endTime);
                    faultDealNum += 1;
                }
            }
            //故障处理时间平均值（天）
            if(countDay > 0 && faultDealNum > 0) {
                BigDecimal value1 = new BigDecimal(countDay + "");
                BigDecimal value2 = new BigDecimal(faultDealNum + "");
                Double avgFault = value1.divide(value2, 2, RoundingMode.HALF_UP).doubleValue();
                faultAvgList.add(avgFault);
            }else{
                faultAvgList.add(0.0);
            }
            faultNumList.add(faultManageList.size());
            faultDealList.add(faultDealNum);
            Integer faultManageRate = faultManageService.getApplicationRatioSum(appIdList,startDate,endDate);
            if(faultManageRate > 0) {
                BigDecimal val1 = new BigDecimal(appCount + "");
                BigDecimal val2 = new BigDecimal(faultManageRate + "");
                BigDecimal val3 = new BigDecimal(100 + "");
                Double faultRate = val2.divide(val1, 2, BigDecimal.ROUND_HALF_UP).multiply(val3).doubleValue();
                faultRateList.add(faultRate);
            }else{
                faultRateList.add(0.0);
            }
        }
        result.put("faultAvgList",faultAvgList);
        result.put("faultNumList",faultNumList);
        result.put("faultDealList",faultDealList);
        result.put("faultRateList",faultRateList);
        return Result.success(result);
    }
}

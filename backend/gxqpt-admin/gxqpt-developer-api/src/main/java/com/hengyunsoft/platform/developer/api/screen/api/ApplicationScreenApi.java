package com.hengyunsoft.platform.developer.api.screen.api;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.hystrix.ApplicationScreenApiHystrix;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationAndServiceNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationInComeAppDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceCostAndTimeDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationTypeNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationVisitCountDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.UseNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsCostDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsTimeDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author wz
 * @create 2018-04-30 21:37
 * @desc 应用大屏Api
 **/
@FeignClient(name = "${gxqpt.gate.feign.server:gxqpt-gate-server}",
        path = "/api/developer", fallback = ApplicationScreenApiHystrix.class)
public interface ApplicationScreenApi {
    /**
     * 可用应用分类查询
     *
     * @return
     */
    @RequestMapping(value = "/app/findAppStatistics", method = RequestMethod.GET)
    Result<Map> findAppStatistics();

    /**
     * 统计应用可降低成本与时间
     *
     * @return
     */
    @RequestMapping(value = "/app/findReduceCostAndTime", method = RequestMethod.GET)
    Result<List<ApplicationReduceCostAndTimeDTO>> findReduceCostAndTime();

    /**
     * 统计应用预计降本率
     *
     * @return
     */
    @ApiOperation(value = "统计应用预计降本率", notes = "统计应用预计降本率")
    @RequestMapping(value = "/app/getReduced", method = RequestMethod.GET)
    Result<Integer> getReduced();

    /**
     * 降本提质-成本统计
     *
     * @return
     */
    @ApiOperation(value = "降本提质-成本统计", notes = "降本提质-成本统计")
    @RequestMapping(value = "/app/findApplicationReduceCost", method = RequestMethod.GET)
    Result<RelationStatisticsCostDTO> findApplicationReduceCost();

    /**
     * 降本提质-工期统计
     *
     * @return
     */
    @ApiOperation(value = "降本提质-工期统计", notes = "降本提质-工期统计")
    @RequestMapping(value = "/app/findApplicationReduceTime", method = RequestMethod.GET)
    Result<RelationStatisticsTimeDTO> findApplicationReduceTime();

    /**
     * 大屏应用与服务统计
     * @return
     */
    @ApiOperation(value = "大屏应用与服务统计", notes = "大屏应用与服务统计")
    @RequestMapping(value = "/app/findApplicationAndServiceNum", method = RequestMethod.GET)
    Result<ApplicationAndServiceNumDTO> findApplicationAndServiceNum();


    /**
     * 大屏运维监控应用系统访问次数top10
     * @return
     */
    @ApiOperation(value = "大屏运维监控应用系统访问次数top10", notes = "大屏运维监控应用系统访问次数top10")
    @RequestMapping(value = "/app/findApplicationVisitCount", method = RequestMethod.GET)
    Result<List<ApplicationVisitCountDTO>> findApplicationVisitCount();

    /**
     * 大屏运维监控调用方应用系统访问次数top10
     * @return
     */
    @ApiOperation(value = "大屏运维监控调用方应用系统访问次数top10", notes = "大屏运维监控调用方应用系统访问次数top10")
    @RequestMapping(value = "/app/findConsumerAppApplicationVisitCount", method = RequestMethod.GET)
    Result<List<ApplicationVisitCountDTO>> findConsumerAppApplicationVisitCount();


    /**
     * 2018-5-11
     * 因大屏需求修改应用集成所有接口重写
     * 根据定窑新需求：接入应用查询
     * @return
     */
    @ApiOperation(value = "大屏应用集成接入应用查询", notes = "大屏应用集成接入应用查询")
    @RequestMapping(value = "/app/findAllIncomeApplication", method = RequestMethod.GET)
    Result<List<ApplicationInComeAppDTO>> findAllIncomeApplication(@RequestParam(value = "top") Integer top);

    /**
     * 降本分析
     * @return
     */
    @ApiOperation(value = "降本分析", notes = "降本分析")
    @RequestMapping(value = "/app/getReduceAnalysis", method = RequestMethod.GET)
    Result<ApplicationReduceAnalysisDTO> getReduceAnalysis();

    /**
     * 组件降本情况
     * @return
     */
    @ApiOperation(value = "组件降本情况", notes = "组件降本情况")
    @RequestMapping(value = "/app/getAssemblyCost", method = RequestMethod.GET)
    Result<ApplicationTypeNumDTO> getAssemblyCost();

    /**
     * 组件增效情况
     * @return
     */
    @ApiOperation(value = "组件增效情况", notes = "组件增效情况")
    @RequestMapping(value = "/app/getAssemblyTime", method = RequestMethod.GET)
    Result<ApplicationTypeNumDTO> getAssemblyTime();

    @ApiOperation(value = "累计调用服务数", notes = "累计调用服务数")
    @RequestMapping(value = "/app/getSeviceUseNum", method = RequestMethod.GET)
    Result<UseNumDTO> getSeviceUseNum();
}

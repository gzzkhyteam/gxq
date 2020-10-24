package com.hengyunsoft.platform.developer.api.screen.api.hystrix;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.platform.developer.api.screen.api.ApplicationScreenApi;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationAndServiceNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceAnalysisDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationInComeAppDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationReduceCostAndTimeDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationTypeNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.ApplicationVisitCountDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.app.UseNumDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsCostDTO;
import com.hengyunsoft.platform.developer.api.screen.dto.reducedCost.RelationStatisticsTimeDTO;

import java.util.List;
import java.util.Map;

/**
 * @author luchanghong
 * @create 2018-05-01 11:08
 * @desc 应用大屏熔断层
 **/
public class ApplicationScreenApiHystrix implements ApplicationScreenApi {
    @Override
    public Result<Map> findAppStatistics() {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationReduceCostAndTimeDTO>> findReduceCostAndTime() {
        return Result.timeout();
    }

    @Override
    public Result<Integer> getReduced() {
        return Result.timeout();
    }

    @Override
    public Result<RelationStatisticsCostDTO> findApplicationReduceCost() {
        return Result.timeout();
    }

    @Override
    public Result<RelationStatisticsTimeDTO> findApplicationReduceTime() {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationAndServiceNumDTO> findApplicationAndServiceNum() {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationVisitCountDTO>> findApplicationVisitCount() {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationVisitCountDTO>> findConsumerAppApplicationVisitCount() {
        return Result.timeout();
    }

    @Override
    public Result<List<ApplicationInComeAppDTO>> findAllIncomeApplication(Integer top) {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationReduceAnalysisDTO> getReduceAnalysis() {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationTypeNumDTO> getAssemblyCost() {
        return Result.timeout();
    }

    @Override
    public Result<ApplicationTypeNumDTO> getAssemblyTime() {
        return Result.timeout();
    }

    @Override
    public Result<UseNumDTO> getSeviceUseNum() {
        return Result.timeout();
    }
}
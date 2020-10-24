package com.hengyunsoft.platform.modular.impl;

import com.hengyunsoft.base.Result;
import com.hengyunsoft.commons.utils.DateUtils;
import com.hengyunsoft.commons.utils.context.DozerUtils;
import com.hengyunsoft.platform.modular.dto.ModularDataAnalysisDTO;
import com.hengyunsoft.platform.modular.dto.ModularDownloadTopDTO;
import com.hengyunsoft.platform.modular.entity.modular.domain.ModularDO;
import com.hengyunsoft.platform.modular.repository.modular.example.ModularExample;
import com.hengyunsoft.platform.modular.repository.service.ModularLogService;
import com.hengyunsoft.platform.modular.repository.service.ModularService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wt
 * @createTime 2018-9-3
 */
@RestController
@Api(value = "API - ModularDataAnalysisApiImpl", description = "模块数据分析-API")
public class ModularDataAnalysisApiImpl {

    @Autowired
    private DozerUtils dozerUtils;
    @Autowired
    private ModularService modularService;
    @Autowired
    private ModularLogService modularLogService;

    /**
     * 模块数据分析
     *
     * @param
     * @return ModularDataAnalysisDTO
     * @createTime 2018-9-3
     * @author wt
     */
    @ApiOperation(value = "模块数据分析", notes = "模块数据分析")
    @RequestMapping(value = "/getDataAnalysis", method = RequestMethod.GET)
    @ApiResponses({
    })
    public Result<ModularDataAnalysisDTO> getDataAnalysis() {
        ModularDataAnalysisDTO result = new ModularDataAnalysisDTO();
        String[] yearMonthArray = DateUtils.getLatest12Month();
        result.setYMonthArray(yearMonthArray);
        List<ModularDO> downTop10List = modularLogService.findModularDownTop10();
        List<ModularDownloadTopDTO> useTopList = dozerUtils.mapList(downTop10List, ModularDownloadTopDTO.class);
        result.setUseTop(useTopList);
        List<Integer> insertNumberList = new ArrayList<>();
        List<Integer> useNumberList = new ArrayList<>();
        List<Double> useRateList = new ArrayList<>();
        ModularExample example = new ModularExample();
        example.createCriteria().andIdIsNotNull();
        int modularCount = modularService.count(example);
        for (int i = 0; i < 12; i++) {
            Date startDate = DateUtils.getDate(yearMonthArray[i] + "-01 00:00:00");
            Date endDate = org.apache.commons.lang3.time.DateUtils.addMilliseconds(
                    org.apache.commons.lang3.time.DateUtils.addMonths(startDate, 1), -1);
            ModularExample modularExample = new ModularExample();
            modularExample.createCriteria().andCreateTimeBetween(startDate, endDate);
            insertNumberList.add(modularService.count(modularExample));

            Integer downNumber = modularLogService.getModularRatioSum(null, startDate, endDate);
            useNumberList.add(downNumber);
            if (downNumber > 0) {
                useRateList.add((double) (downNumber * 100 / modularCount));
            } else {
                useRateList.add(0.00);
            }
        }
        result.setInsertNumber(insertNumberList);
        result.setUseNumber(useNumberList);
        result.setUseRate(useRateList);
        return Result.success(result);
    }

}
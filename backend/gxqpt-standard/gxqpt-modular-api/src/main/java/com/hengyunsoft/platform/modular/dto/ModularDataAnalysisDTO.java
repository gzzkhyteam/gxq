package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ModularDataAnalysis", description = "模块统计分析返回数据")
public class ModularDataAnalysisDTO {

    /**
     * X轴数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "X轴数据")
    private String[] yMonthArray;

    /**
     * Y轴新增量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Y轴新增量")
    private List<Integer> insertNumber;

    /**
     * Y轴使用量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Y轴使用量")
    private List<Integer> useNumber;

    /**
     * Y轴使用率
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Y轴使用率")
    private List<Double> useRate;

    /**
     * 使用top10
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "使用top10")
    private List<ModularDownloadTopDTO> useTop;
}

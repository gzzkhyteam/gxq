package com.hengyunsoft.platform.developer.api.screen.dto.reducedCost;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "RelationStatisticsCost", description = "大屏引用工期降本提质计数")
public class RelationStatisticsTimeDTO {
    @ApiModelProperty(value = "应用名称、服务名称集合")
    private List<String> appNameList;
    @ApiModelProperty(value = "可节约工期数集合")
    private List<Double> reduceTimeList;
    @ApiModelProperty(value = "原创工期数集合")
    private List<Double> originalTimeList;
    @ApiModelProperty(value = "引用到的模块数集合")
    private List<Object> producerNameList;
    @ApiModelProperty(value = "实际工期数集合")
    private List<Double> actualReduceTimeList;

    public RelationStatisticsTimeDTO(){
        appNameList = new ArrayList<>();
        reduceTimeList = new ArrayList<>();
        originalTimeList = new ArrayList<>();
        producerNameList = new ArrayList<>();
        actualReduceTimeList = new ArrayList<>();
    }
}

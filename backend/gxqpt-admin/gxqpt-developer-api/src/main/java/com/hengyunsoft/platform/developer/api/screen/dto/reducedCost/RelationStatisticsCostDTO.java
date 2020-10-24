package com.hengyunsoft.platform.developer.api.screen.dto.reducedCost;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "RelationStatisticsCost", description = "大屏引用资金降本提质计数")
public class RelationStatisticsCostDTO {
    @ApiModelProperty(value = "应用名称、服务名称集合")
    private List<String> appNameList;
    @ApiModelProperty(value = "可节约资金数集合")
    private List<Object> reduceCostList;
    @ApiModelProperty(value = "原创资金数集合")
    private List<Object> originalCostList;
    @ApiModelProperty(value = "引用到的模块数集合")
    private List<Object> producerNameList;
    @ApiModelProperty(value = "实际资金数集合")
    private List<Object> actualReduceCostList;
    @ApiModelProperty(value = "维护资金数集合")
    private List<Object> reduceProtectCost;

    public RelationStatisticsCostDTO(){
        appNameList = new ArrayList<>();
        reduceCostList = new ArrayList<>();
        originalCostList = new ArrayList<>();
        producerNameList = new ArrayList<>();
        reduceProtectCost = new ArrayList<>();
        actualReduceCostList = new ArrayList<>();
    }
}

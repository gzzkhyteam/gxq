package com.hengyunsoft.platform.developer.api.screen.dto.reducedCost;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "ReducedCost",description = "大屏降本提质计数")
public class ReducedCostDTO {
	
	@ApiModelProperty(value = "应用名称、服务名称集合")
    private List<Object> nameList;
	
    @ApiModelProperty(value = "可缩短工期总数")
    private String reduceTimeTotal;
    
    @ApiModelProperty(value = "可缩短工期数集合")
    private List<Object> reduceTimeNumlist;
    
    @ApiModelProperty(value = "可降低成本总金额")
    private String reduceCostTotal;
    
    @ApiModelProperty(value = "可降低成本金额集合")
	private List<Object> reduceCostNumlist;
    
    @ApiModelProperty(value = "累计使用模块数")
    private String useModuleTotal;
    
    @ApiModelProperty(value = "累计使用应用数")
    private String useApplicationTotal;

    public ReducedCostDTO(){
        nameList = new ArrayList<>();
        reduceTimeNumlist = new ArrayList<>();
        reduceCostNumlist = new ArrayList<>();
    }

}

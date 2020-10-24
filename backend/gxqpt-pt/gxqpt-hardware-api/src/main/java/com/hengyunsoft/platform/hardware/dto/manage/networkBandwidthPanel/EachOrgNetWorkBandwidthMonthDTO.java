package com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EachOrgNetWorkBandwidthDTO", description = "网络带宽面板  各部门网络带宽统计 ")
public class EachOrgNetWorkBandwidthMonthDTO{
	
    @ApiModelProperty(value = "部门")
    private List<String> nameList;

    @ApiModelProperty(value = "网络带宽")
    private List<Integer> numList;

}

package com.hengyunsoft.platform.hardware.dto.manage.networkBandwidthPanel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ThisMonthStatisticsDTO", description = "网络带宽面板  本月统计 ")
public class ThisMonthStatisticsDTO{
	
	@ApiModelProperty(value = "network")
    private int network;

    @ApiModelProperty(value = "本月新增")
    private int curMonAdd;

    @ApiModelProperty(value = "本月回收")
    private int curMonSub;

    @ApiModelProperty(value = "新增占比")
    private String addPercent;

    @ApiModelProperty(value = "回收占比")
    private String subPercent;

    @ApiModelProperty(value = "新增环比")
    private String ciraddPercent;

    @ApiModelProperty(value = "回收环比")
    private String revertPercent;

    @ApiModelProperty(value = "净增")
    private int jadd;

    @ApiModelProperty(value = "净增环比")
    private String jaddPercent;

}

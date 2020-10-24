package com.hengyunsoft.platform.hardware.dto.panel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CpuResDTO", description = "计算资源面板CPU相关资源情况")
public class CpuResDTO {

    @ApiModelProperty(value = "cpu")
    private int cpu;

    @ApiModelProperty(value = "本月新增")
    private int curMonAdd;

    @ApiModelProperty(value = "本月回收")
    private int curMonSub;

    @ApiModelProperty(value = "新增占比")
    private float addPercent;

    @ApiModelProperty(value = "回收占比")
    private float subPercent;

    @ApiModelProperty(value = "新增环比")
    private float ciraddPercent;

    @ApiModelProperty(value = "回收环比")
    private float revertPercent;

    @ApiModelProperty(value = "净增")
    private int jadd;

    @ApiModelProperty(value = "净增环比")
    private float jaddPercent;
}

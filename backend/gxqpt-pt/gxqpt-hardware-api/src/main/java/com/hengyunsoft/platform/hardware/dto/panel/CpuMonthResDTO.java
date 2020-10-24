package com.hengyunsoft.platform.hardware.dto.panel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CpuMonthResDTO", description = "各月CPU资源统计情况")
public class CpuMonthResDTO {

    /**
     * cpu数量
     */
    @ApiModelProperty(value = "cpu")
    private int[] cpuCount;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String orgname;

}

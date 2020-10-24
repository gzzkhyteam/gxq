package com.hengyunsoft.platform.hardware.dto.panel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "CpuMonthResDTO", description = "各月CPU资源统计情况")
public class CpuMonthResRetDTO {

    /**
     * 月份
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "月份")
    private String[] months;

    @ApiModelProperty(value = "每月各单位CPU资源")
    List<CpuMonthResDTO> orgCpuRes;
}

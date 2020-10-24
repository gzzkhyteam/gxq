package com.hengyunsoft.platform.hardware.dto.panel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrgCpuResDTO", description = "各单位计算资源面板CPU相关资源情况")
public class OrgCpuResDTO {

    /**
     * cpu数量
     */
    @ApiModelProperty(value = "cpu")
    private int cpuCount;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String orgname;

}

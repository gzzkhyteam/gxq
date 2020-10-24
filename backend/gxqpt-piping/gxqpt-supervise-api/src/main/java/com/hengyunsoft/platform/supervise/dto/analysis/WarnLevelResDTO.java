package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WarnLevelResDTO {
    @ApiModelProperty(value = "单位/部门/人员/应用id")
    private String id;
    @ApiModelProperty(value = "单位/部门/人员/应用名称")
    private String name;
    @ApiModelProperty(value = "预警级别")
    private Integer level;
    @ApiModelProperty(value = "预警数量")
    private Integer count;
}

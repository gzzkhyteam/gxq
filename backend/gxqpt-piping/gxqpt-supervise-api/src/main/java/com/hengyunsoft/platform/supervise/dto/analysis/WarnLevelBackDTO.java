package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "WarnLevelBackDTO", description = "预警级别返回参数")
public class WarnLevelBackDTO {
    @ApiModelProperty(value = "单位/部门/人员/应用id")
    private String id;
    @ApiModelProperty(value = "单位/部门/人员/应用名称")
    private String name;
    @ApiModelProperty(value = "预警数量")
    private Map<String,Object> count;
}

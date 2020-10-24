package com.hengyunsoft.platform.supervise.dto.analysis;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "EmpsWarnLevelRes", description = "人员预警级别返回参数")
public class EmpsWarnLevelBackDTO {
    @ApiModelProperty(value = "人员名称")
    private String name;
    @ApiModelProperty(value = "人员id")
    private String id;
    @ApiModelProperty(value = "预警数量")
    private Map<String,Object> count;
}

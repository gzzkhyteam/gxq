package com.hengyunsoft.platform.supervise.dto.analysis;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class EmpsWarnLevelResDTO {
    @ApiModelProperty(value = "人员id")
    private String id;
    @ApiModelProperty(value = "人员名称")
    private String name;
    @ApiModelProperty(value = "预警级别")
    private Integer level;
    @ApiModelProperty(value = "预警数量")
    private Integer count;
}

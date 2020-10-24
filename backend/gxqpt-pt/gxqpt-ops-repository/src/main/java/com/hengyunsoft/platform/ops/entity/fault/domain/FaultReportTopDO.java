package com.hengyunsoft.platform.ops.entity.fault.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class FaultReportTopDO implements Serializable{

    @ApiModelProperty(value = "系统名称")
    private String systemName;
    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value = "数量")
    private Integer wclCount;

}

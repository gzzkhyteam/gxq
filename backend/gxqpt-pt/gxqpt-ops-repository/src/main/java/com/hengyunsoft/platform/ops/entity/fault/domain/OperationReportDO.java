package com.hengyunsoft.platform.ops.entity.fault.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class OperationReportDO implements Serializable{

    @ApiModelProperty(value = "月份")
    private String yearMonth;
    @ApiModelProperty(value = "数量")
    private Integer number;

}

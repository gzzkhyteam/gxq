package com.hengyunsoft.platform.ops.entity.alarm.po.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class ServiceManageAlarmDO implements Serializable{
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "申请编号")
    private String applyCode;
    @ApiModelProperty(value = "天数")
    private Integer day;
    @ApiModelProperty(value = "状态")
    private Integer status;

}

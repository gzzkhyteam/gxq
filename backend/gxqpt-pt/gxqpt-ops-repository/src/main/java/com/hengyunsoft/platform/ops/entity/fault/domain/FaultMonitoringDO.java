package com.hengyunsoft.platform.ops.entity.fault.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *故障管理
 */
@Data
public class FaultMonitoringDO  implements Serializable{

    @ApiModelProperty(value = "系统id总数")
    private Integer  count;
    @ApiModelProperty(value = "处理时长")
    private Integer  hour;




}

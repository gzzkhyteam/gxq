package com.hengyunsoft.platform.ops.alarmdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-09-03
 */
@Data
@ApiModel(value = "AlarmRuleSetPageReqDTO", description = "告警规则设置管理")
public class AlarmRuleSetPageReqDTO implements Serializable{

    @ApiModelProperty(value = "告警名称" ,required = false)
    private String alarmName;
    @ApiModelProperty(value = "告警级别" ,required = false)
    private Integer alarmLevel;

    @ApiModelProperty(value = "告警类型" ,required = false)
    private Integer alarmType;

}

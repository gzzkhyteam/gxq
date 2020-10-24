package com.hengyunsoft.platform.ops.alarmdto;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AlarmRuleSettingsDTO  implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "告警名称")
    private String alarmName;

    @ApiModelProperty(value = "告警级别")
    private Integer alarmLevel;

    @ApiModelProperty(value = "告警类型")
    private Integer alarmType;

    @ApiModelProperty(value = "任务类型")
    private Integer taskType;

    @ApiModelProperty(value = "预警天数")
    private Integer day;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
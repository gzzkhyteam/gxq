package com.hengyunsoft.platform.ops.entity.alarm.po.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class AlarmInformationDO implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "告警名称")
    private String alarmName;

    @ApiModelProperty(value = "告警级别" )
    private Integer alarmLevel;

    @ApiModelProperty(value = "系统id")
    private String systemId;

    @ApiModelProperty(value = "系统名称")
    private String systemName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    @ApiModelProperty(value = "告警规则id")
    private Long ruleId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "详情跳转地址")
    private String detailsUrl;
    @ApiModelProperty(value = "处理人")
    private Long createUser;

}
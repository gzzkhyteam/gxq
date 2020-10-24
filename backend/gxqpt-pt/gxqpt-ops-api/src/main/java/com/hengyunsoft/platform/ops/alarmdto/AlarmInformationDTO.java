package com.hengyunsoft.platform.ops.alarmdto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class AlarmInformationDTO  implements Serializable {

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

    @ApiModelProperty(value = "状态:1未处理，2已处理")
    private Integer status;

    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    @ApiModelProperty(value = "告警规则id")
    private Long ruleId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "详情地址(单击处理调整地址)")
    private String detailsUrl;
}
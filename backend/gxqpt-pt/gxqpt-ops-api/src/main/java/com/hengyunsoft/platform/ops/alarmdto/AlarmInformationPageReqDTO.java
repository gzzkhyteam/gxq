package com.hengyunsoft.platform.ops.alarmdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author tianai
 * @createTime 2018-09-03
 */
@Data
@ApiModel(value = "AlarmInformationPageReqDTO", description = "告警列表信息管理")
public class AlarmInformationPageReqDTO implements Serializable {

    @ApiModelProperty(value = "告警名称" ,required = false)
    private String alarmName;
    @ApiModelProperty(value = "告警级别" ,required = false)
    private Integer alarmLevel;
    @ApiModelProperty(value = "状态:1未处理，2已处理",required = false)
    private Integer status;
    @ApiModelProperty(value = "创建时间",required = false)
    private Date startTime;
    @ApiModelProperty(value = "更新时间",required = false)
    private Date endTime;

}
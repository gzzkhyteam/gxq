package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "LogWarningQuery", description = "日志告警信息")
public class LogWarningQueryDTO {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     *日志告警   条件：开始时间
     */
    @ApiModelProperty(value = "日志告警（条件开始）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeStart;
    /**
     *日志告警   条件：结束时间
     */
    @ApiModelProperty(value = "日志告警（条件结束）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTimeEnd;
    /**
     * 告警名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警名称")
    private String name;
    /**
     * 处理状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理状态")
    private String isDeal;
    /**
     * 应用系统id（多个用“，”号分隔）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统id")
    private String appId;
    /**
     * 告警级别，1：一级；2：二级；3：三级（多个用“，”号分隔）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警级别")
    private String warnLevel;
    /**
     * 告警规则类型，（多个用“，”分隔）KEY:关键字告警；QUANTITY：数量告警
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警类型")
    private String warnType;
}

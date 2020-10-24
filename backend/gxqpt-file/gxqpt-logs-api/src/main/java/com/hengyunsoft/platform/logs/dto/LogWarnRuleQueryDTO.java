package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogWarnRuleQuery", description = "告警规则详情")
public class LogWarnRuleQueryDTO{
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 告警名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警名称")
    private String name;
    /**
     * 告警内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警内容")
    private String warnDescription;
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

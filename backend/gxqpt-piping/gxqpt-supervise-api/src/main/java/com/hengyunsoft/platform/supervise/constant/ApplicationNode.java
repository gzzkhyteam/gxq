package com.hengyunsoft.platform.supervise.constant;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用于应用id于应用名匹配
 */
@Data
@ApiModel(value = "ApplicationNode",description = "权限查询名称实体")
public class ApplicationNode {
    private Long id;
    @ApiModelProperty(value = "appId")
    private String appId;
    @ApiModelProperty(value = "应用名称")
    private String appName;
    @ApiModelProperty(value = "责任人")
    private String dutyUserName;
    @ApiModelProperty(value = "确认人")
    private String confirmUserName;
    @ApiModelProperty(value = "抄送人")
    private String copyUserName;
    @ApiModelProperty(value = "责任人id")
    private String dutyUser;
    @ApiModelProperty(value = "确认人id")
    private String confirmUser;
    @ApiModelProperty(value = "抄送人id")
    private String copyUser;
    @ApiModelProperty(value = "应用类型")
    private String appType;
    @ApiModelProperty(value = "应用分类")
    private String type;
    @ApiModelProperty(value = "级别")
    private Integer level;
}

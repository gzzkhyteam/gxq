package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplyQueryDetailDTO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "应用名称")
    private String appName;

    @ApiModelProperty(value = "应用/功能 名字")
	private String name;

	@ApiModelProperty(value = "应用/功能 编码")
	private String code;

    @ApiModelProperty(value = "申请状态")
    private String status;

    @ApiModelProperty(value = "任务标记  应用申请  功能申请   调用申请    应用审批  功能审批  调用审批")
    private String taskType;

	@ApiModelProperty(value = "应用/功能描述")
    private String desc;

    @ApiModelProperty(value = "应用appid")
    private String appId;
    
    @ApiModelProperty(value = "审核状态： 1  待审核     2 审核通过    3 审核不通过 ")
    private Short auditStatus;

    @ApiModelProperty(value = "审核备注")
    private String auditDesc;

    @ApiModelProperty(value = "申请备注")
    private String applyDesc;

    @ApiModelProperty(value = "审批人")
    private String auditUser;

    @ApiModelProperty(value = "申请人")
    private String applyUser;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "申请人名称")
    private String applyUserName;

    @ApiModelProperty(value = "审批人名称")
    private String auditUserName;
}

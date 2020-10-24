package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplyDTO {



    @ApiModelProperty(value = "id")
    private String id;
    
    
    
    
    /**
     * 任务标记  应用申请  功能申请   调用申请    应用审批  功能审批  调用审批
     */
    @ApiModelProperty(value = "任务标记  应用申请  功能申请   调用申请    应用审批  功能审批  调用审批")
    private String taskType;
    /**
     * 功能id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能id")
    private String moduleId;

    /**
     * 应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用appid")
    private String appId;
    
    /**
     * 应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;

    /**
     * 审核状态： 1  待审核     2 审核通过    3 审核不通过    
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核状态： 1  待审核     2 审核通过    3 审核不通过 ")
    private Short auditStatus;

    /**
     * 审核描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核描述")
    private String auditDesc;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请描述")
    private String applyDesc;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人")
    private String auditUser;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人")
    private String applyUser;


    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private String createTime;


    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请人名称")
    private String applyUserName;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批人名称")
    private String auditUserName;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能名称")
    private String moduleName;

}

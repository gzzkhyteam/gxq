package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @param moduleId     模块Id   过滤条件     null标示不限制
 * @param auditStatus  审批状态   过滤条件  1、待审核     2、已通过      3、被拒绝    null标示不限制
 * @param appId       查询人管理的应用appid     允许null
 * @param taskType     任务类型：   新增应用申请appApply    新增功能申请 moduleApply   功能调用申请assignApply  null标示不限制
 * @param taskRole     任务角色 ： 申请类任务apply    审批类任务 audit   其他标示不限制  
 * @param applyUser    申请人     这里传入查询人即可
 * @return
 */
@Data
public class ApplyQueryDTO {

    /**
     *模块Id
     */
    @ApiModelProperty(value = "模块Id")
	String moduleId;

    /**
     *审批状态   过滤条件  1、待审核     2、已通过      3、被拒绝    null标示不限制
     */
    @ApiModelProperty(value = "审批状态   过滤条件  1、待审核     2、已通过      3、被拒绝    null标示不限制")
	String auditStatus;

    /**
     *任务类型：   新增应用申请appApply    新增功能申请 moduleApply   功能调用申请assignApply  null标示不限制
     */
    @ApiModelProperty(value = "任务类型：   新增应用申请appApply    新增功能申请 moduleApply   功能调用申请assignApply  null标示不限制")
	String taskType;

    /**
     *任务角色 ： 申请类任务apply    审批类任务 audit   其他标示不限制
     */
    @ApiModelProperty(value = "任务角色 ： 申请类任务apply    审批类任务 audit   其他标示不限制  ")
	String taskRole;

    /**
     *查询人管理的应用appid     允许null
     */
    @ApiModelProperty(value = "查询人管理的应用appid     允许null")
	String appId;

    /**
     * 应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;
    /**
     * 功能名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "功能名称")
    private String moduleName;

}

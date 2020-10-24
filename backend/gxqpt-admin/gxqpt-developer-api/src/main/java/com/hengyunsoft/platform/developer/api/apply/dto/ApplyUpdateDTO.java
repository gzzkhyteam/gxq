package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author:madb
 * @time:2018/4/12
 * 我的任务管理对应详情DTO
 */
@Data
@ApiModel(value = "ApplyUpdateDTO", description = "我的任务审批对应DTO")
public class ApplyUpdateDTO {

    @ApiModelProperty(value = "对应任务 id 组件")
    private Long id;

    @ApiModelProperty(value = "任务类型：   新增应用申请appAudit    新增功能申请 moduleAudit   功能调用申请assignAudit ")
    String taskType;

    @ApiModelProperty(value = "审批 通过：true 不通过：false")
    private Boolean passornot;

    @ApiModelProperty(value = "审批批注")
    private String auditDesc;
}

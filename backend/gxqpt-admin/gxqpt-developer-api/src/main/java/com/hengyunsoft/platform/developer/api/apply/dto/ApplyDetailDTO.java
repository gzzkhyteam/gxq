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
@ApiModel(value = "ApplyDetailDTO", description = "我的任务管理对应详情DTO")
public class ApplyDetailDTO {

    @ApiModelProperty(value = "对应任务 id 组件")
    private Long id;

    @ApiModelProperty(value = "任务类型：   新增应用申请appApply    新增功能申请 moduleApply   功能调用申请assignApply ")
    String taskType;
}

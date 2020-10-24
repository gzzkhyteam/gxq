package com.hengyunsoft.platform.developer.api.screen.dto.module;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 应用集成大屏数据
 * 获取单位组件调用信息
 */
@Data
public class ModuleUserInfosDTO {
    @ApiModelProperty(value = "单位名称")
    private String deptName;

    @ApiModelProperty(value = "组件名称")
    private String moduleName;

    @ApiModelProperty(value = "调用时间")
    private String time;
}

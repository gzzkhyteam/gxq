package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-05 15:49
 * @desc
 * @Version 1.0
 **/
@Data
public class AppAssignDTO extends ApplyQueryDetailDTO{

    @ApiModelProperty(value = "功能id")
    private Long moduleId;

    @ApiModelProperty(value = "服务分配模块id（表示这条审批通过后，关联的分配id）")
    private Long serviceAssignModuleId;

    @ApiModelProperty(value = "模块类型")
    private ModuleType moduleTypeMap;

    @ApiModelProperty(value = "功能名称")
    private String moduleName;
}

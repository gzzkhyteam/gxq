package com.hengyunsoft.platform.developer.api.service.dto.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-04-30 21:17
 * @desc 模块名称DTO
 **/
@Data
@ApiModel(value = "Module", description = "模块名称获取")
public class FindModuleNameDTO {
    @ApiModelProperty(value = "模块名称")
    private String name;
}
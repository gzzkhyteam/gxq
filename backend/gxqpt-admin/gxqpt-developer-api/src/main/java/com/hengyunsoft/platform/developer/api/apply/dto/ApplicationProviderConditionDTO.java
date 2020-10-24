package com.hengyunsoft.platform.developer.api.apply.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2019-02-18 11:53
 * @desc 未删除与启用实体
 **/
@Data
@ApiModel(value = "ApplicationProviderConditionDTO", description = "未删除与启用实体")
public class ApplicationProviderConditionDTO {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "公司名称")
    private String name;
}
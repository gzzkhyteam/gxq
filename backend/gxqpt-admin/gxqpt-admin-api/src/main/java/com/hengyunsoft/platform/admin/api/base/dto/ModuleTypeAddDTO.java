package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 功能类型维护DTO
 * @author madb
 * @createTime 2018/4/10
 */
@Data
public class ModuleTypeAddDTO implements Serializable{

    /**
     * 功能类型名称
     * */
    @ApiModelProperty(value = "功能类型名称")
    private String name;

    /**
     * 功能类型编码
     * */
    @ApiModelProperty(value = "功能类型编码")
    private String Code;

    /**
     * 功能类型描述
     * */
    @ApiModelProperty(value = "功能类型描述")
    private String description;
}

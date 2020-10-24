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
public class ModuleDictionaryModifyDTO implements Serializable{

    /**
     * 功能类型主键：id
     * */
    @ApiModelProperty(value = "功能类型主键：id")
    private Long id;

    /**
     * 功能类型
     * */
    @ApiModelProperty(value = "功能类型")
    private String name;

    /**
     * 功能类型编码
     * */
    @ApiModelProperty(value = "功能类型编码")
    private String code;

    /**
     * 类型描述
     * */
    @ApiModelProperty(value = "类型描述")
    private String description;
}

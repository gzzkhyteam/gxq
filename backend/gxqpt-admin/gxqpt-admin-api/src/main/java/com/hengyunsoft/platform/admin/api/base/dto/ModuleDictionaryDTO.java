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
public class ModuleDictionaryDTO implements Serializable{

    /**
     * 功能类型主键：id
     * */
    @ApiModelProperty(value = "功能类型主键：id")
    private String id;

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

    /**
     * 涵盖的功能
     * */
    @ApiModelProperty(value = "涵盖功能")
    private String orderNum;

    /**
     * 功能类型创建人
     * */
    @ApiModelProperty(value = "创建人")
    private String createUser;
    /**
    * 创建时间
    * */
    @ApiModelProperty(value = "创建时间")
    private String createTime;

    /**
     * 涵盖功能数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "涵盖功能数量")
    private String num;
}

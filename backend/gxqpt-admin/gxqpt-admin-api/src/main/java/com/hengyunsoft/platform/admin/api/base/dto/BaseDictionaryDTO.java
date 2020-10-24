package com.hengyunsoft.platform.admin.api.base.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author tianai
 * @createTime 2018-01-24
 */
@Data
public abstract class BaseDictionaryDTO {


    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典条目名称")
    private String name;

    /**
     * 启用状态
     1：启用
     0：禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "启用状态")
    private Boolean isEnable;

    /**
     * 排序号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序号")
    private Integer orderNum;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String description;




}

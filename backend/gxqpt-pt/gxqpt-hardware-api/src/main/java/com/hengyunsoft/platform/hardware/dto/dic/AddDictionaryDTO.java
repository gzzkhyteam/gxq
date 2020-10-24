package com.hengyunsoft.platform.hardware.dto.dic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AddDictionaryDTO implements Serializable {

    /**
     * 类型id
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型id")
    private Long dictionaryTypeId;

    /**
     * 类型编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value ="类型编码" )
    private String dictionaryTypeCode;

    /**
     * 字典类型名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典类型名称")
    private String dictionaryTypeName;


    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典条目名称")
    private String name;



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
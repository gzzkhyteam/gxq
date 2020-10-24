package com.hengyunsoft.platform.hardware.dto.dic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageDictionaryListDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "字典id")
    private Long id;


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
     * 字典条目编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典条目编码")
    private String code;

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
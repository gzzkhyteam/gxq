package com.hengyunsoft.platform.hardware.dto.dic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SaveDictionaryTypeDTO {

    /**
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value ="父id" )
    private Long parentId;

    /**
     * 编码
     *
     * @mbggenerated
     */
    @ApiModelProperty("编码")
    private String code;

    /**
     * 名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String description;




}
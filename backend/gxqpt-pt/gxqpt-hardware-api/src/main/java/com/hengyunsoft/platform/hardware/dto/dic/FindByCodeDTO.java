package com.hengyunsoft.platform.hardware.dto.dic;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FindByCodeDTO {
    @ApiModelProperty("id")
    String id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    String name;
    /**
     * 编码
     *
     * @mbggenerated
     */
    private String code;


    /**
     * 类型编码
     *
     * @mbggenerated
     */
    private String dictionaryTypeCode;

    /**
     * 字典类型名称
     *
     * @mbggenerated
     */
    private String dictionaryTypeName;
}
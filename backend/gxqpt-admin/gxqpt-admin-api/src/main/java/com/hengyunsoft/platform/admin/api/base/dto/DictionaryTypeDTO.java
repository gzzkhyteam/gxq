package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-1-25
 */
@Data
@ApiModel(value = "DictionaryType", description = "数据字典类型")
public class DictionaryTypeDTO extends BaseDictionaryTypeDTO implements Serializable {
    /**
     * 数据字典类型id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典类型id")
    private Long id;
    /**
     * 数据字典类型编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典类型编码")
    private String code;


}

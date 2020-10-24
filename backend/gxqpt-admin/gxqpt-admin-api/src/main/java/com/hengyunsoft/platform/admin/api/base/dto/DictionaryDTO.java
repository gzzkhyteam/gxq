package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-01-24
 */
@Data
public class DictionaryDTO extends BaseDictionaryDTO implements Serializable {

    /**
     * 数据字典id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典id")
    private Long id;
    /**
     * 字典编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典编码")
    private String code;

}

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
@ApiModel(value = "DictionaryTypeUpdate", description = "数据字典类型")
public class DictionaryTypeUpdateDTO extends BaseDictionaryTypeDTO implements Serializable {
    /**
     * 数据字典类型id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典类型id",required = true)
    private Long id;

    /**
     * 数据字典类型编码
     *
     * @mbggenerated
     */
    /*@ApiModelProperty(value = "数据字典类型编码",required = true)
    private String code;*/

    /**
     * appId
     */
    @ApiModelProperty(value = "appId",required = true)
    private String appId;
}

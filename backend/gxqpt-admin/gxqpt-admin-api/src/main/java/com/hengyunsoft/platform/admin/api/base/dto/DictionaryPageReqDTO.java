package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-1-24
 */
@Data
@ApiModel(value = "DictionaryPageReq", description = "数据字典")
public class DictionaryPageReqDTO implements Serializable {
    /**
     * 类型id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典类型id")
    private Long dictionaryTypeId;

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据字典类型应用id",required = true)
    private String appId;
}

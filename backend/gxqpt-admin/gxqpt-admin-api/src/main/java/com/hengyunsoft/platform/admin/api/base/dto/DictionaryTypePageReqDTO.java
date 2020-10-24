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
@ApiModel(value = "DictionaryTypePageReq", description = "数据字典类型")
public class DictionaryTypePageReqDTO implements Serializable {

    /**
     * 开发者ID，提供给各个应用的设别码
     *
     */
    @ApiModelProperty(value = "开发者ID，提供给各个应用的设别码")
    protected String appId;

}

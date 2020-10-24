package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DictionaryOrgFind", description = "单位所需数据字典")
public class DictionaryOrgFindDTO {
    /**
     * 类型编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型编码")
    private String dictionaryTypeCode;

    /**
     * 字典编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典编码")
    private String code;
}

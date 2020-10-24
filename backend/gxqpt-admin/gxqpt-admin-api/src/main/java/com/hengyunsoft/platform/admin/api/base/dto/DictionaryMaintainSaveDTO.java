package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangbiao
 * @createTime 2018-04-10
 */
@Data
@ApiModel(value = "DictionaryMaintainSave", description = "应用类型维护 保存")
public class DictionaryMaintainSaveDTO {
    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典条目名称")
    private String name;

    /**
     * 字典编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典编码")
    private String code;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "描述")
    private String description;

}

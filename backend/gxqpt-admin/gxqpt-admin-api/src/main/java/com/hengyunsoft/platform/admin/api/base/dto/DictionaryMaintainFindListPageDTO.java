package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangbiao
 * @createTime 2018-04-10
 */
@Data
@ApiModel(value = "DictionaryMaintainPage", description = "应用类型维护 查询")
public class DictionaryMaintainFindListPageDTO {

    /**
     * 字典条目名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字典条目名称")
    private String name;
}

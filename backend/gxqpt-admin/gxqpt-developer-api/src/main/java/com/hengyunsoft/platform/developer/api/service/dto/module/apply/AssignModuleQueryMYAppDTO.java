package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "AssignModuleQueryMYApp", description = "查询功能模块")
public class AssignModuleQueryMYAppDTO implements Serializable {

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块类型")
    private String moduleType;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态： 1启用   2禁用")
    private Boolean status;

    private static final long serialVersionUID = 1L;
}

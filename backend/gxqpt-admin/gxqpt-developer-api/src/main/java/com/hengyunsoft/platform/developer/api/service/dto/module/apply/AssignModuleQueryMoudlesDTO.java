package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "AssignModuleQueryMoudles", description = "查询功能模块")
public class AssignModuleQueryMoudlesDTO implements Serializable {
    /**
     * 功能名称
     */
    @ApiModelProperty(value = "功能名称")
    private String name;

    /**
     * 功能编码
     *
     */
    @ApiModelProperty(value = "功能编码")
    private String code;

    /**
     * 模块类型
     */
    @ApiModelProperty(value = "模块类型")
    private String moduleType;

    /**
     *状态： 1、正常使用中   10、已过时（有新版本取代）   20、停止使用
     */
    @ApiModelProperty(value = "状态： 1、正常使用中   10、已过时（有新版本取代）   20、停止使用")
    private Short status;

    private static final long serialVersionUID = 1L;
}

package com.hengyunsoft.platform.developer.api.service.dto.module.apply;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel(value = "AssignModuleQueryMy", description = "查询功能模块")
public class AssignModuleQueryMyDTO implements Serializable {

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 模块类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块类型")
    private String moduleType;


    private static final long serialVersionUID = 1L;
}

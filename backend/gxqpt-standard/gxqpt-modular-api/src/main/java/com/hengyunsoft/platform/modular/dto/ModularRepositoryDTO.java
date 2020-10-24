package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularRepository", description = "仓库展示对象")
public class ModularRepositoryDTO {

    /**
     * 仓库名称
     */
    @ApiModelProperty(value = "仓库名称")
    private String name;

    /**
     * 仓库类型
     */
    @ApiModelProperty(value = "仓库类型")
    private String type;

    /**
     * 仓库格式
     */
    @ApiModelProperty(value = "仓库格式")
    private String format;

    /**
     * 仓库地址
     */
    @ApiModelProperty(value = "仓库地址")
    private String url;
}

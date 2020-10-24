package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularDownloadTop", description = "仓库模块数量排行操作对象")
public class ModularRepertoriesTopDTO {

    /**
     * 仓库名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "仓库名称")
    private String repName;

    /**
     * 模块数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块数量")
    private Integer modularCount;

}

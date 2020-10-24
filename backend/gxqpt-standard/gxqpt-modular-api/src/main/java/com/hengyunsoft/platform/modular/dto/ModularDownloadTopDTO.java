package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularDownloadTop", description = "模块使用排行操作对象")
public class ModularDownloadTopDTO {

    /**
     * 模块主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块主键id")
    private Long id;

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块名称")
    private String modularName;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下载次数")
    private String downloadCount;

}

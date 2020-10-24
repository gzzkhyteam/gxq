package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularAnalysisCategoryTop", description = "类别下载排行操作对象")
public class ModularAnalysisCategoryTopDTO {

    /**
     * 分类主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分类主键id")
    private Long id;

    /**
     * 模块分类名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块分类名称")
    private String name;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下载次数")
    private String downloadCount;

}

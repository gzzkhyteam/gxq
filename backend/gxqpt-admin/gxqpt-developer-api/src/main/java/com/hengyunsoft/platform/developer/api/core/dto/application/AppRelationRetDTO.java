package com.hengyunsoft.platform.developer.api.core.dto.application;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AppRelationRetDTO", description = "查询应用依赖关系接口")
public class AppRelationRetDTO extends ApplicationBaseDTO {

    /**
     * 是否依赖
     */
    @ApiModelProperty(value = "是否依赖 1 是 0 否")
    private Integer idRely;

    /**
     * 依赖应用Id
     */
    @ApiModelProperty(value = "依赖应用Id")
    private Long target;

    /**
     * 依赖应用名称
     */
    @ApiModelProperty(value = "依赖应用名称")
    private String targetName;

    /**
     * 关系表主键
     */
    @ApiModelProperty(value = "关系表主键")
    private Long relationId;

}

package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "StandardClassify", description = "标准分类")
public class StandardClassifyDTO extends StandardClassifyBaseDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 是否启用
     1：启用
     0：禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用，1：启用；0：禁用")
    private Boolean isEnable;

}

package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardClassifyUpdate", description = "更新分类信息参数对象")
public class StandardClassifyUpdateDTO extends  StandardClassifyBaseDTO {

    @ApiModelProperty(value = "主键id")
    private Long id;

}

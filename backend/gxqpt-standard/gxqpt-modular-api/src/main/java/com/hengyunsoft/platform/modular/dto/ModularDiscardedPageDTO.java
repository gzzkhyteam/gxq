package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularDiscardedPageDTO", description = "废弃模块参数")
public class ModularDiscardedPageDTO {
    @ApiModelProperty(value = "查询参数")
    private String param;
}

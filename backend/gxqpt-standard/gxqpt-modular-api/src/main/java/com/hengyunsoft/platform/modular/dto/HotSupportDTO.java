package com.hengyunsoft.platform.modular.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "HotSupport", description = "热力图top10")
public class HotSupportDTO {

    /**
     * 模块名称
     */
    @ApiModelProperty(value = "名称")
    private String name;


    @ApiModelProperty(value = "次数")
    private Integer hotCount;

}

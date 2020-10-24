package com.hengyunsoft.platform.exchange.api.overview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgDTO {
    @ApiModelProperty(value = "单位id")
    private String unitId;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = "单位图标")
    private String iconUrl;
}

package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * api实时调用
 */
@Data
public class ScreenApiRealDTO {
    @ApiModelProperty(value = "部门名称",required = true)
    private String unitName;
    @ApiModelProperty(value = "API名称",required = true)
    private String apiName;
    @ApiModelProperty(value = "访问时间",required = true)
    private Date visitTime;

}

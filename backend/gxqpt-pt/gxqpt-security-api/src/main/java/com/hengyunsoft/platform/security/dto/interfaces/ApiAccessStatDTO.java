package com.hengyunsoft.platform.security.dto.interfaces;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ApiAccessStatDTO {
    @ApiModelProperty(value = "统计时段")
    private Integer statHour;
    @ApiModelProperty(value = "访问量")
    private Integer statSum;
}

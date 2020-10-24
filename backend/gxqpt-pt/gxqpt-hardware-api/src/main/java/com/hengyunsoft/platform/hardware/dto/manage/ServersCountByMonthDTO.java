package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServersCountByMonthDTO", description = "查询各月服务器数量")
public class ServersCountByMonthDTO {

    /**
     * 服务器数量
     */
    @ApiModelProperty("服务器数量")
    private int serverCount;

    /**
     * 月份
     */
    @ApiModelProperty("月份")
    private String mon;

}

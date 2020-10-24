package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServersCountByMonthDTO", description = "查询各月服务器数量")
public class ServersResCountByMonthDTO {


    /**
     * 月份
     */
    @ApiModelProperty("月份")
    private String mon;


    /**
     * cpu数量
     */
    @ApiModelProperty("cpu数量")
    private int cpuCount;

    /**
     * 内存大小
     */
    @ApiModelProperty("内存大小")
    private int memorySize;

    /**
     * 磁盘大小
     */
    @ApiModelProperty("磁盘大小")
    private long diskSize;

}

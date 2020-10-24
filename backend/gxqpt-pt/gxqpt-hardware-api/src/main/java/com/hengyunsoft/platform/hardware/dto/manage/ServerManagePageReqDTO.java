package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServerManagePageReq", description = "服务分配管理分页模糊查询")
public class ServerManagePageReqDTO {
    @ApiModelProperty(value = "cpu核数")
    private Integer cpuCount;
    @ApiModelProperty(value = "内存大小")
    private Integer memorySize;
    @ApiModelProperty(value = "所属系统")
    private String system;
    @ApiModelProperty(value = "所属网络")
    private String netScope;
}

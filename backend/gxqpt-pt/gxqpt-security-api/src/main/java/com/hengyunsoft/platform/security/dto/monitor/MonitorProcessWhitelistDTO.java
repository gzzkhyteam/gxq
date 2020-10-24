package com.hengyunsoft.platform.security.dto.monitor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class MonitorProcessWhitelistDTO implements Serializable {

    @ApiModelProperty(value = "主键，(新增操作忽略)")
    private Long id;

    @ApiModelProperty(value = "服务器ip")
    private String serverIp;

    @ApiModelProperty(value = "进程id")
    private Long processId;

    @ApiModelProperty(value = "进程名称")
    private String processName;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态（0：有效，1：无效）")
    private Integer status;


}

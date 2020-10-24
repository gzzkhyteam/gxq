package com.hengyunsoft.platform.security.dto.monitor;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class MonitorProcessWhitelistSaveDTO implements Serializable {
    @ApiModelProperty(value = "服务器ip")
    private String serverIp;

    @ApiModelProperty(value = "进程id")
    private Long processId;

    @ApiModelProperty(value = "进程名称")
    private String processName;

    @ApiModelProperty(value = "创建时间（新增可忽略不填）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "备注")
    private String remarks;
}

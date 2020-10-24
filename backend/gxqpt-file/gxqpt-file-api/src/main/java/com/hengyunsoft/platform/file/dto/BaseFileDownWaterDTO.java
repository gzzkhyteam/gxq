package com.hengyunsoft.platform.file.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class BaseFileDownWaterDTO {

    @ApiModelProperty(value = "应用id")
    private String appId;
    @ApiModelProperty(value = "下载时间")
    private String createTime;
    @ApiModelProperty(value = "创建人")
    private Long createUser;
}

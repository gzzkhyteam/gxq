package com.hengyunsoft.platform.file.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "FileDownWater", description = "文件下载流水对象")
public class FileDownWaterDTO {
    @ApiModelProperty(value = "文件id")
    private Long fileId;
    @ApiModelProperty(value = "应用id")
    private String appId;
    @ApiModelProperty(value = "下载时间")
    private String createTime;
}

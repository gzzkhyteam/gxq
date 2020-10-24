package com.hengyunsoft.platform.file.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "FileDownWaterPageReq", description = "文件下载流水对象")
public class FileDownWaterPageReqDTO implements Serializable {
    @ApiModelProperty(value = "文件id", required = false)
    private Long[] fileId;
    @ApiModelProperty(value = "开始时间 格式：  yyyy-MM-dd HH:mm:ss", required = false)
    private String startTime;
    @ApiModelProperty(value = "截止时间 格式：  yyyy-MM-dd HH:mm:ss", required = false)
    private String endTime;
}

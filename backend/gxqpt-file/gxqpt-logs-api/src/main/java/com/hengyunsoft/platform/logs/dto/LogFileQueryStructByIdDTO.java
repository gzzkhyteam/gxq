package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogFileQueryStructById", description = "根据docuemntId查询结构化数据表中的数据")
public class LogFileQueryStructByIdDTO {
    @ApiModelProperty(value = "主键id")
    private String documentId;
    /**
     *排序字段
     */
    @ApiModelProperty(value = "排序字段")
    private String sidx;

    /**
     *排序方式，可选值：asc、desc
     */
    @ApiModelProperty(value = "排序方式，可选值：asc、desc")
    private String sord;
}

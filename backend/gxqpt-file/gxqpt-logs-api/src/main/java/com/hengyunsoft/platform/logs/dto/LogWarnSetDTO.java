package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "LogWarnSet", description = "文件保留设置")
public class LogWarnSetDTO {
    /**
     * 主键 id
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 结构化日志保留天数
     */
    @ApiModelProperty(value = "日志保留天数")
    private Long structSaveDays;
    /**
     * 文件保留天数
     */
    @ApiModelProperty(value = "文件保留天数")
    private Long fileSaveDays;
    /**
     * 告警信息保留天数
     */
    @ApiModelProperty(value = "告警信息保留天数")
    private Long warnSaveDays;

}

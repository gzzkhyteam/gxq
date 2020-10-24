package com.hengyunsoft.platform.logs.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LogNumberAnalysisBaseDTO {
    /**
     * 时间显示
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "横轴时间显示")
    private String time;
    /**
     * 日志类型名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志类型名称")
    private String logTypeName;
    /**
     * 数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数量")
    private String number;
}

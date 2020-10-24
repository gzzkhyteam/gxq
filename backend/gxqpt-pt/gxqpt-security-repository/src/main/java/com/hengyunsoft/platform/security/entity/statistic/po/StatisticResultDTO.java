package com.hengyunsoft.platform.security.entity.statistic.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel
public class StatisticResultDTO {
    @ApiModelProperty(value = "统计项")
    private String name;

    @ApiModelProperty(value = "统计结果值")
    private Long num;

    @ApiModelProperty(value = "统计日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date statDate;
}

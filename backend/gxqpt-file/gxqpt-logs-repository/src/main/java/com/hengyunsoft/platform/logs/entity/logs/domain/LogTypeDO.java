package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-08-31 15:47
 * @desc 日志类型
 **/
@ApiModel
public class LogTypeDO {
    @ApiModelProperty(value = "月")
    private Integer month;
    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value = "年")
    private Integer year;
    @ApiModelProperty("日志类别")
    private String logType;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
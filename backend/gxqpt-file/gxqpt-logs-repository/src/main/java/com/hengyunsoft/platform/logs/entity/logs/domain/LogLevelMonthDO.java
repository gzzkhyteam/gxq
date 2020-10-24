package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-09-04 17:00
 * @desc 日志级别数量
 **/
@ApiModel
public class LogLevelMonthDO {
    @ApiModelProperty(value = "月")
    private Integer month;
    @ApiModelProperty(value = "年")
    private Integer year;
    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value ="级别" )
    private String level;

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
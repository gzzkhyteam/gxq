package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-08-31 15:30
 * @desc 每月日志统计数量
 **/
@ApiModel
public class LogMonthErrorDO {
    @ApiModelProperty(value = "月")
    private Integer month;
    @ApiModelProperty(value = "年")
    private Integer year;
    @ApiModelProperty(value = "数量")
    private Integer count;


    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

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
}
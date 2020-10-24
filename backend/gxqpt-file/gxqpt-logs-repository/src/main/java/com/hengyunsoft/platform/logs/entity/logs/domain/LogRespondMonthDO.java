package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-09-05 11:37
 * @desc 日志响应时间
 **/
@ApiModel
public class LogRespondMonthDO {
    @ApiModelProperty(value = "响应时间")
    private Integer respondTime;
    @ApiModelProperty(value = "月")
    private Integer month;
    @ApiModelProperty(value = "年")
    private Integer year;

    public Integer getRespondTime() {
        return respondTime;
    }

    public void setRespondTime(Integer respondTime) {
        this.respondTime = respondTime;
    }

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
}
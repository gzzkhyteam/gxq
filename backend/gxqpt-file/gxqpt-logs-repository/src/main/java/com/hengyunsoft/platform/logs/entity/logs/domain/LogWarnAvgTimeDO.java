package com.hengyunsoft.platform.logs.entity.logs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author luchanghong
 * @create 2018-09-04 10:05
 * @desc 告警处理平均时间
 **/
@ApiModel
public class LogWarnAvgTimeDO {
    @ApiModelProperty(value = "数量")
    private Integer count;
    @ApiModelProperty(value = "处理时间")
    private Integer dealTime;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDealTime() {
        return dealTime;
    }

    public void setDealTime(Integer dealTime) {
        this.dealTime = dealTime;
    }
}
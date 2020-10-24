package com.hengyunsoft.platform.developer.entity.core.po.domain;


import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-05-01 16:50
 * @desc 全天模块统计调用总数
 **/
public class ModuleUseDayDataDO {
    private Integer sumTotalNum;
    private Integer nowDayHour;
    private Date useDay;

    public Integer getSumTotalNum() {
        return sumTotalNum;
    }

    public void setSumTotalNum(Integer sumTotalNum) {
        this.sumTotalNum = sumTotalNum;
    }

    public Integer getNowDayHour() {
        return nowDayHour;
    }

    public void setNowDayHour(Integer nowDayHour) {
        this.nowDayHour = nowDayHour;
    }

    public Date getUseDay() {
        return useDay;
    }

    public void setUseDay(Date useDay) {
        this.useDay = useDay;
    }
}
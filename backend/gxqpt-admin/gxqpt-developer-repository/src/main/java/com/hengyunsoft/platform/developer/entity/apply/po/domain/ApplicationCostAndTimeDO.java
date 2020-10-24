package com.hengyunsoft.platform.developer.entity.apply.po.domain;

import com.hengyunsoft.platform.developer.entity.apply.po.Application;

/**
 * @author luchanghong
 * @create 2018-05-01 10:20
 * @desc 统计应用可降低成本与时间
 **/
public class ApplicationCostAndTimeDO extends Application {
    /**
     * 类型统计数量
     */
    private Integer typeNum;

    /**
     * 可降低总成本
     *
     */
    private Integer sumReduceCost;
    /**
     * 缩短总时间
     */
    private  Double sumReduceTime;

    public Integer getSumReduceCost() {
        return sumReduceCost;
    }

    public void setSumReduceCost(Integer sumReduceCost) {
        this.sumReduceCost = sumReduceCost;
    }

    public Double getSumReduceTime() {
        return sumReduceTime;
    }

    public void setSumReduceTime(Double sumReduceTime) {
        this.sumReduceTime = sumReduceTime;
    }

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }
}
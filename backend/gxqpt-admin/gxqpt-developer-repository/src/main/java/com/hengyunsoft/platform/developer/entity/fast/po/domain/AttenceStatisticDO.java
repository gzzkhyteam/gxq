package com.hengyunsoft.platform.developer.entity.fast.po.domain;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.platform.developer.entity.fast.po.attence.AttenceStatistic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 扩展
 */
@Data
public class AttenceStatisticDO extends AttenceStatistic {

    /**
     * 姓名
     */
    private String userName;

    /**
     * 姓名
     */
    private Date startDate;

    /**
     * 姓名
     */
    private Date endDate;

    /**
     * 加班小时
     */
    private Float extraworkHour;

    /**
     * 请假小时
     */
    private Float leaveHour;

    /**
     * //迟到小时
     */
    private Float lateHour;

    /**
     * //早退小时
     */
    private Float earlyHour;

    /**
     * //加班条件 （1：> ,2:=,3:<）
     */
    private Integer extraworkCondition;

    /**
     * //迟到条件 （1：> ,2:=,3:<）
     */
    private Integer lateCondition;

    /**
     * //早退条件 （1：> ,2:=,3:<）
     */
    private Integer earlyCondition;

    /**
     * //请假条件 （1：> ,2:=,3:<）
     */
    private Integer leaveCondition;

    /**
     * 应出勤天数
     */
    private Integer ycqDay;

    /**
     * 正常出勤天数
     */
    private Integer sjcqDay;
}
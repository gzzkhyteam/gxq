package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 考勤统计接收参数
 **/
@Data
@ApiModel(value = "RequestAttenceStatisticDTO",description = "考勤统计接收参数")
public class RequestAttenceStatisticDTO implements Serializable{
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String userName;

    /**
     * 应用ID
     */
    @ApiModelProperty(value = "姓名")
    private String appId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private String startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private String endDate;

    /**
     * 加班小时
     */
    @ApiModelProperty(value = "加班小时")
    private Float extraworkHour;

    /**
     * 请假小时
     */
    @ApiModelProperty(value = "请假小时")
    private Float leaveHour;

    /**
     * //迟到小时
     */
    @ApiModelProperty(value = "迟到小时")
    private Float lateHour;

    /**
     * //早退小时
     */
    @ApiModelProperty(value = "早退小时")
    private Float earlyHour;

    /**
     * //加班条件 （1：> ,2:=,3:<）
     */
    @ApiModelProperty(value = "加班条件 （1：> ,2:=,3:<）")
    private Integer extraworkCondition;

    /**
     * //迟到条件 （1：> ,2:=,3:<）
     */
    @ApiModelProperty(value = "迟到条件 （1：> ,2:=,3:<）")
    private Integer lateCondition;

    /**
     * //早退条件 （1：> ,2:=,3:<）
     */
    @ApiModelProperty(value = "早退条件 （1：> ,2:=,3:<）")
    private Integer earlyCondition;

    /**
     * //请假条件 （1：> ,2:=,3:<）
     */
    @ApiModelProperty(value = "请假条件 （1：> ,2:=,3:<）")
    private Integer leaveCondition;



    private static final long serialVersionUID = 1L;

}
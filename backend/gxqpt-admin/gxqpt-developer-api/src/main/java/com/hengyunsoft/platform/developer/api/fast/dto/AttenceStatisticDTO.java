package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 考勤统计
 **/
@Data
@ApiModel(value = "AttenceStatisticDTO",description = "考勤统计")
public class AttenceStatisticDTO implements Serializable{
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private String id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String userName;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date workDate;

    /**
     * 应出勤天数
     */
    @ApiModelProperty(value = "应出勤天数")
    private Integer ycqDay;

    /**
     * 正常出勤天数
     */
    @ApiModelProperty(value = "正常出勤天数")
    private Integer sjcqDay;

    /**
     * 外勤小时
     */
    @ApiModelProperty(value = "外勤小时")
    private Float outsideHour;

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
     * 迟到小时
     */
    @ApiModelProperty(value = "迟到小时")
    private Float lateHour;
    /**
     * 早退小时
     */
    @ApiModelProperty(value = "早退小时")

    private Float earlyHour;

    /**
     * 旷工小时
     */
    @ApiModelProperty(value = "旷工小时")
    private Float neglectHour;

    /**
     * 实际工作小时
     */
    @ApiModelProperty(value = "实际工作小时")
    private Float actualHour;

    /**
     * 实际工作小时
     */
    @ApiModelProperty(value = "实际工作小时")
    private Float businessHour;




    private static final long serialVersionUID = 1L;

}
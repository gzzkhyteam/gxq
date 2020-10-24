package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wt
 * @create 2018-05-08
 * @desc 考勤规则表
 **/
@Data
@ApiModel(value = "AttenceRuleDTO",description = "考勤规则表")
public class AttenceRuleDTO implements Serializable{
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 上班签到时间
     */
    @ApiModelProperty(value = "上班签到时间")
    private String inTime;

    /**
     * 下班签到时间
     */
    @ApiModelProperty(value = "下班签到时间")
    private String outTime;

    /**
     * 迟到界定开始
     */
    @ApiModelProperty(value = "迟到界定开始")
    private String laterStartTime;

    /**
     * 迟到界定结束
     */
    @ApiModelProperty(value = "迟到界定结束")
    private String laterEndTime;

    /**
     * 午休开始时间
     */
    @ApiModelProperty(value = "午休开始时间")
    private String lunchStartTime;

    /**
     * 午休结束时间
     */
    @ApiModelProperty(value = "午休结束时间")
    private String lunchEndTime;

    /**
     * 矿工界定范围
     */
    @ApiModelProperty(value = "矿工界定范围")
    private String absentTimeRange;

    /**
     * 早退界定范围
     */
    @ApiModelProperty(value = "早退界定范围")
    private String leaveTimeRange;

    /**
     * 上班签到距离范围
     */
    @ApiModelProperty(value = "上班签到距离范围")
    private String distanceRange;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double latitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double longtude;

    /**
     * 签到位置
     */
    @ApiModelProperty(value = "签到位置")
    private String location;

    /**
     * 工作日加班计算起始时间
     */
    @ApiModelProperty(value = "工作日加班计算起始时间")
    private String startTime;

    /**
     * 节假日加班计算系数
     */
    @ApiModelProperty(value = "节假日加班计算系数")
    private Float coefficient;




    private static final long serialVersionUID = 1L;

}
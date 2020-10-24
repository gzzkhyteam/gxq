package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Data
public class HolidayDataDTO implements Serializable {


    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称")
    private String name;

    /**
     * 类型（放假、调休加班）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型（1放假、0调休加班）")
    private String type;

    /**
     * 编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号")
    private String number;

    /**
     * 是否启用：1是，0否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用：1是，0否")
    private Integer status;


    /**
     * 故事
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "故事")
    private String story;

    /**
     * 开始日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日从哪年开始时间")
    private String startTime;
    /**
     * 节假日从哪年截止时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日从哪年截止时间")
    private String endTime;

    /**
     * 开始月
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始月")
    private String month;

    /**
     * 日
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日")
    private String day;

    /**
     * 节假日天数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日天数")
    private String holidayDays;

    /**
     * 日历类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日历类型")
    private String calendarType;
}

package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：一条统计数据dto
 * 修改人：gbl
 * 修改时间：2018/7/24
 * 修改内容：
 */
@Data
@ApiModel(value = "PunchAttendanceStaticsDTO", description = "：一条统计数据dto")
public class PunchAttendanceStaticsDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 用户姓名")
    private String userName;

    /**
     * 用户部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户部门名称")
    private String deptName;

    /**
     * 用户职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 用户职务名称")
    private String maindutyName;
    /**
     * 统计日(yyyy-MM-dd)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "统计日(yyyy-MM-dd)")
    private String attDay;
    /***
     * 星期(星期天是1，星期六是7)
     */
    @ApiModelProperty(value = " 星期(星期天是1，星期六是7)")
    private Integer weekDay;
    /***
     *今天是否应出勤(0和1)
     */
    @ApiModelProperty(value = "今天是否应出勤(0和1)")
    private Integer isWorkDay;
    /***
     *今天是否放假
     */
    @ApiModelProperty(value = "今天是否放假0和1")
    private Integer isHolidays;
    /***
     *今天是否出勤了
     */
    @ApiModelProperty(value = "今天是否出勤了")
    private Integer isToWork;
    /***
     *应出勤天数
     */
    @ApiModelProperty(value = "应出勤天数")
    private Integer needDays;
    /***
     *正常出勤天数
     */
    @ApiModelProperty(value = "正常出勤天数")
    private Integer normalDays;
    /***
     * 总出勤天数
     */
    private Integer allIsToWork;
    /***
     *节假日天数
     */
    @ApiModelProperty(value = "节假日天数")
    private Integer holidays;
    /**
     * 外勤（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 外勤（单位小时）")
    private Double outHous;
    /***
     *外勤次数"
     */
    @ApiModelProperty(value = "外勤次数")
    private Integer outHousTime;

    /**
     * 加班（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班（单位小时）")
    private Double workHous;
    /**
     * 加班次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班次数")
    private Integer workHousTime;
    /**
     * 请假（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假（单位小时）")
    private Double leaveHous;
    /**
     * 请假次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假次数")
    private Integer leaveHousTime;
    /**
     * 出差（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差（单位小时）")
    private Double travelHous;
    /**
     * 出差次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差次数")
    private Integer travelHousTime;
    /**
     * 迟到（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "迟到（单位小时）")
    private Double lateHour;
    /***
     * 迟到次数
     */
    @ApiModelProperty(value = "迟到次数")
    private Integer lateHourTime;

    /**
     * 早退（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "早退（单位小时）")
    private Double earlyHour;
    /***
     * 早退次数
     */
    @ApiModelProperty(value = "早退次数")
    private Integer earlyHourTime;

    /**
     * 矿工(单位次数)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "矿工(单位次数)")
    private Integer minerCount;


}

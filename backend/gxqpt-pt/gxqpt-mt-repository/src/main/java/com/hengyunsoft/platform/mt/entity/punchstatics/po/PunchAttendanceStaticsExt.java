package com.hengyunsoft.platform.mt.entity.punchstatics.po;

import lombok.Data;

@Data
public class PunchAttendanceStaticsExt extends PunchAttendanceStatics {
    /***
     * 迟到次数
     */
    private Integer lateHourTime;
    /***
     * 早退次数
     */
    private Integer earlyHourTime;
    /***
     * 星期(星期天是1，星期六是7)
     */
    private Integer weekDay;
    /***
     * 正常考勤天数
     */
    private Integer normalDays;
    /***
     *今天是否应出勤(0和1)
     */
    private Integer isWorkDay;
    /***
     *今天是否出勤了
     */
    private Integer isToWork;
    /***
     *今天是否放假
     */
    private Integer isHolidays;
    /**
     * 用户姓名
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * 用户部门名称
     *
     * @mbggenerated
     */
    private String deptName;

    /**
     * 用户职务名称
     *
     * @mbggenerated
     */
    private String maindutyName;

    private String yearMonth;
    /***
     * 外勤次数
     */
    private Integer outHousTime;
    /***
     * 加班次数
     */
    private Integer workHousTime;
    /***
     * 请假次数
     */
    private Integer leaveHousTime;
    /***
     * 出差次数
     */
    private Integer travelHousTime;

    /***
     * 总出勤天数
     */
    private Integer allIsToWork;
    /***
     *总应出勤天数
     */
    private Integer needDays;
    /***
     * 异常天数
     */
    private Integer extDays;

    private static final long serialVersionUID = 1L;

}
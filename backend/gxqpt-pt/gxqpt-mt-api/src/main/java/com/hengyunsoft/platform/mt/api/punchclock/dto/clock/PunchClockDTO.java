package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：打卡信息
 * 修改人：gbl
 * 修改时间：2018/7/4
 * 修改内容：
 */
@Data
@ApiModel(value = "PunchClockDTO", description = "打卡")
public class PunchClockDTO {
    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 打卡日期
     *
     * @mbggenerated
     */
    private Date clockDate;

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    private Date signInTime;

    /**
     * 签退时间
     *
     * @mbggenerated
     */
    private Date signOffTime;

    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    private Integer adceType;

    /**
     * 签到状态:1,正常；2，迟到；3，早退
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 签到经度
     *
     * @mbggenerated
     */
    private String signInLng;

    /**
     * 签到纬度
     *
     * @mbggenerated
     */
    private String signInLat;

    /**
     * 签到地点
     *
     * @mbggenerated
     */
    private String signLocation;

    /**
     * 签退经度
     *
     * @mbggenerated
     */
    private String signOffLng;

    /**
     * 签退纬度
     *
     * @mbggenerated
     */
    private String signOffLat;

    /**
     * 签退地点
     *
     * @mbggenerated
     */
    private String signOffLocation;
}

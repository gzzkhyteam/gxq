package com.hengyunsoft.platform.mt.api.punchclock.dto.clock;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.punchclock.dto.clock
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：打卡历史记录
 * 修改人：gbl
 * 修改时间：2018/7/9
 * 修改内容：
 */
@Data
@ApiModel(value = "PunchClockHisDTO", description = "打卡历史记录")
public class PunchClockHisDTO {
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
     * 打卡类型:1,签到；2，签退
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打卡类型:1,签到；2，签退")
    private Integer clockType;

    /**
     * 打卡时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打卡时间")
    private Date clockTime;

    /**
     * 考勤类型:1,内勤；2，外勤
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "考勤类型:1,内勤；2，外勤")
    private Integer adceType;

    /**
     * 迟到（早退）说明
     *
     * @mbggenerated
     */
    private String lateReason;

    /**
     * 签到状态:1,正常；2，迟到；3，早退
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 签到状态:1,正常；2，迟到；3，早退")
    private Integer status;

    /**
     * 外勤事由
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "外勤事由")
    private String outterReason;

    /**
     * 是否自动打卡:1,手动；2，自动
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 是否自动打卡:1,手动；2，自动")
    private Integer autoFlag;

    /**
     * 经度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "经度")
    private String lng;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "纬度")
    private String lat;

    /**
     * 打卡地点
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "打卡地点")
    private String location;

}

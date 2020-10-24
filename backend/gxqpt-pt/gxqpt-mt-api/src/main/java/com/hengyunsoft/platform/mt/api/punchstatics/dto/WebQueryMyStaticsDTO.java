package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：web端查询我的考勤统计
 * 修改人：gbl
 * 修改时间：2018/7/24
 * 修改内容：
 */
@Data
@ApiModel(value = "WebQueryMyStaticsDTO", description = "web端查询我的考勤统计")
public class WebQueryMyStaticsDTO {
    /***
     * 每天统计数据
     */
    @ApiModelProperty(value = "每天统计数据")
    List<PunchAttendanceStaticsDTO> statics;
    /**
     * 总计外勤（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 总计外勤（单位小时）")
    private Double outHous;

    /**
     * 总计加班（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班（单位小时）")
    private Double workHous;

    /**
     * 请假（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "总计请假（单位小时）")
    private Double leaveHous;

    /**
     * 总计出差（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "总计出差（单位小时）")
    private Double travelHous;

    /**
     * 总计迟到（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "总计迟到（单位小时）")
    private Double lateHour;

    /**
     * 总计早退（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "总计早退（单位小时）")
    private Double earlyHour;

    /**
     * 总计矿工(单位次数)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "总计矿工(单位次数)")
    private Integer minerCount;

}

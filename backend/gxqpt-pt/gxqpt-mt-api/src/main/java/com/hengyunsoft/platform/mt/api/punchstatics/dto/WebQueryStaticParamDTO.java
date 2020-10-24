package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：web端考勤统计
 * 修改人：gbl
 * 修改时间：2018/7/25
 * 修改内容：
 */
@Data
@ApiModel(value = "WebQueryStaticParamDTO", description = "web端考勤统计")
public class WebQueryStaticParamDTO {
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
     * 外勤（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 外勤（单位小时）")
    private String outHous;

    /**
     * 加班（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "加班（单位小时）")
    private String workHous;

    /**
     * 请假（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请假（单位小时）")
    private String leaveHous;

    /**
     * 出差（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "出差（单位小时）")
    private String travelHous;

    /**
     * 迟到（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "迟到（单位小时）")
    private String lateHour;

    /**
     * 早退（单位小时）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "早退（单位小时）")
    private String earlyHour;

    /**
     * 矿工(单位次数)参数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "矿工(单位次数)")
    private String minerCount;
    /***
     * 开始日期
     */
    @ApiModelProperty(value = "开始日期")
    private Date startAttDay;
    /***
     * 结束日期
     */
    @ApiModelProperty(value = "结束日期")
    private Date endAttDay;
}

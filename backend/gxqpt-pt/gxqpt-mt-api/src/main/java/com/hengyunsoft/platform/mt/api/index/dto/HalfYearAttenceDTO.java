package com.hengyunsoft.platform.mt.api.index.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.index.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：首页近半年考勤
 * 修改人：zhaopengfei
 * 修改时间：2018/8/28
 * 修改内容：
 */
@Data
@ApiModel(value = "HalfYearAttenceDTO", description = "首页近半年考勤")
public class HalfYearAttenceDTO {
    @ApiModelProperty(value = "年月")
    private List<String> yearMonths;

    @ApiModelProperty(value = "正常出勤（天数）")
    private List<Integer> normalDays;

    @ApiModelProperty(value = "加班（小时）")
    private List<Double> workHous;

    @ApiModelProperty(value = "请假（小时）")
    private List<Double> leaveHous;

    @ApiModelProperty(value = "出差（小时）")
    private List<Double> travelHous;

    @ApiModelProperty(value = "迟到（小时）")
    private List<Double> lateHour;

    @ApiModelProperty(value = "早退（小时）")
    private List<Double> earlyHour;


    @ApiModelProperty(value = "旷工（次数）")
    private List<Integer> minerCounts;




}

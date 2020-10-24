package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：app考勤统计
 * 修改人：gbl
 * 修改时间：2019/7/2
 * 修改内容：
 */
@Data
@ApiModel(value = "AppStaticsDTO", description = "app考勤统计")
public class AppStaticsDTO {
    @ApiModelProperty(value = "昨天的考勤统计 k:类型(normal:正常打卡人数,miner:旷工人数 " +
            "late:迟到人数 early:早退人数 travel:请假人数 out:外勤人数 work:加班人数) v1:值")
    private List<StaticsKVDTO> yes;
    @ApiModelProperty(value = "本月异常考勤排名 k:人员姓名 v1:异常值")
    private List<StaticsKVDTO> exs;
    @ApiModelProperty(value = "本月分类占比统计 k:类型名称  v1:类型值")
    private List<StaticsKVDTO> classify;
    @ApiModelProperty(value = "本年统计 K:月份 v1:正常值  v2:异常值")
    private List<StaticsKVDTO> year;
}

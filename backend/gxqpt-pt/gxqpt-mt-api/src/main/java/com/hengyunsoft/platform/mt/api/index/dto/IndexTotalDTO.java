package com.hengyunsoft.platform.mt.api.index.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
/**
 * com.hengyunsoft.platform.mt.api.index.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：首页整体数据
 * 修改人：zhaopengfei
 * 修改时间：2018/8/28
 * 修改内容：
 */
@Data
@ApiModel(value = "IndexTotalDTO", description = "首页整体数据")
public class IndexTotalDTO {
    @ApiModelProperty(value = "APP版本总数")
    private Integer appNum;

    @ApiModelProperty(value = "最新APP版本升级数量")
    private Integer appLastUpdateNum;

    @ApiModelProperty(value = "应用程序数量")
    private Integer applNum;

    @ApiModelProperty(value = "基础应用程序数量")
    private Integer baseApplNum;

    @ApiModelProperty(value = "本月应出勤天数")
    private Integer nowMonthDayNum;

    @ApiModelProperty(value = "本月正常出勤天数")
    private Integer nowNormalDayNum;

    @ApiModelProperty(value = "考勤待审批条数")
    private Integer aprNum;

    @ApiModelProperty(value = "日志待查看条数")
    private Integer workLogNum;

}

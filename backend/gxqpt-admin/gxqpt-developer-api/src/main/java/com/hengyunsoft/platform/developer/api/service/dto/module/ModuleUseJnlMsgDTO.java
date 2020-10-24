package com.hengyunsoft.platform.developer.api.service.dto.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.developer.api.service.dto.module
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：模块调用日志dto
 * 修改人：sunxiaoya
 * 修改时间：2018/4/19
 * 修改内容：
 */
@Data
@ApiModel(value = "ModuleUseJnlMsg", description = "模块调用日志")
public class ModuleUseJnlMsgDTO {

    /*@ApiModelProperty(value = "主键:day+hour+appId+moduleId")
    private String combineId;*/

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "功能id")
    private String moduleId;

    /*@ApiModelProperty(value = "调用总数")
    private int totalNum;

    @ApiModelProperty(value = "调用失败数")
    private int errorNum;*/

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "年")
    private String useYear;

    @ApiModelProperty(value = "月")
    private String useMonth;

    @ApiModelProperty(value = "日")
    private String useDay;

    @ApiModelProperty(value = "时")
    private String useHour;

    @ApiModelProperty(value = "周")
    private String useWeekend;

    @ApiModelProperty(value = "季度")
    private String useQuarter;

    @ApiModelProperty(value = "调用总数")
    private Integer newTotalNum;

    @ApiModelProperty(value = "调用失败数")
    private Integer newErrorNum;

}

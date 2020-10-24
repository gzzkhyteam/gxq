package com.hengyunsoft.platform.developer.api.service.dto.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author luchanghong
 * @create 2018-05-01 16:43
 * @desc 统计全天每小时模块调用总量
 **/
@Data
@ApiModel(value = "统计全天每小时模块调用总量",description = "统计全天每小时模块调用总量")
public class ModuleUseDayDataDTO {
    @ApiModelProperty(value = "模块调用总数")
    private Integer sumTotalNum;
    @ApiModelProperty(value = "小时")
    private Integer nowDayHour;
    @ApiModelProperty(value = "天")
    private Date useDay;
}
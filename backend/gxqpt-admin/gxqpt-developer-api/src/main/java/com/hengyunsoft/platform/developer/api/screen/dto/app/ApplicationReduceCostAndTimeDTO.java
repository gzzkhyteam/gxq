package com.hengyunsoft.platform.developer.api.screen.dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author luchanghong
 * @create 2018-05-01 10:41
 * @desc 可降低成本与时间DTO
 **/
@Data
@ApiModel(value = "ApplicationReduceCostAndTime",description = "大屏应用统计可降低成本与时间")
public class ApplicationReduceCostAndTimeDTO {
    /**
     * 应用名称
     */
    @ApiModelProperty(value = "应用名称")
    private String name;
    /**
     * 应用类型
     */
    @ApiModelProperty(value = "应用类型")
    private  String type;
    /**
     * 类型统计数量
     */
    @ApiModelProperty(value ="类型统计数量" )
    private Integer typeNum;

    /**
     * 可降低总成本
     *
     */
    @ApiModelProperty(value = "可降低总成本")
    private Integer sumReduceCost;
    /**
     * 缩短总时间
     */
    @ApiModelProperty(value = "缩短总时间")
    private  Double sumReduceTime;
}
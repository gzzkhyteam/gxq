package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2019-05-06 16:49
 * @desc LevelNum
 * @Version 1.0
 **/
@Data
@ApiModel(value = "LevelNum", description = "预警级别对应的数量")
public class LevelNum {
    //预警级别
    @ApiModelProperty(value = "预警数量")
    private Integer count;

    @ApiModelProperty(value = "预警级别")
    private Integer level;
}

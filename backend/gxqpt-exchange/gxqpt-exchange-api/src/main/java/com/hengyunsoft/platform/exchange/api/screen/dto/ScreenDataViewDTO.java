package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 大屏平台数据使用情况
 */
@Data
@ApiModel(value = "ScreenDataViewDTO", description = "数据使用情况")
public class ScreenDataViewDTO {
    @ApiModelProperty(value = "月份集合",required = true)
    List<String> busTitle= new ArrayList<String>();
    @ApiModelProperty(value = "数据目录",required = true)
    List<Integer>   dirList = new ArrayList<Integer>();
    @ApiModelProperty(value = "数据集",required = true)
    List<Integer>   setList = new ArrayList<Integer>();
    @ApiModelProperty(value = "API",required = true)
    List<Integer>   apiList = new ArrayList<Integer>();


}

package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 大屏数据趋势
 */
@Data
@ApiModel(value = "DataTrendDTO", description = "数据趋势")
public class DataTrendDTO {
    @ApiModelProperty(value = "api调用次数",required = true)
    List<Integer> apiCallList = new ArrayList<Integer>();
    @ApiModelProperty(value = "月数组",required = true)
    List<String> busTitle= new ArrayList<String>();
    @ApiModelProperty(value = "数据量",required = true)
    List<Integer>   dataList = new ArrayList<Integer>();
}

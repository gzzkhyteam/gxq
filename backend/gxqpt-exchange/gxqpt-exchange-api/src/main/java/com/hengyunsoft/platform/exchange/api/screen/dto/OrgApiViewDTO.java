package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 大屏部门使用情况
 */
@Data
@ApiModel(value = "OrgApiViewDTO", description = "部门使用情况")
public class OrgApiViewDTO {
    @ApiModelProperty(value = "部门名称",required = true)
    List<String> busTitle= new ArrayList<String>();
    @ApiModelProperty(value = "api数量",required = true)
    List<Integer>   apiList = new ArrayList<Integer>();
    @ApiModelProperty(value = "api调用次数",required = true)
    List<Integer>   apiCallList = new ArrayList<Integer>();
    @ApiModelProperty(value = "top10",required = true)
    List<Map<String,Object>> returnList= new ArrayList<Map<String,Object>>();
    @ApiModelProperty(value = "目录数",required = true)
    List<Integer>   dirList = new ArrayList<Integer>();

}

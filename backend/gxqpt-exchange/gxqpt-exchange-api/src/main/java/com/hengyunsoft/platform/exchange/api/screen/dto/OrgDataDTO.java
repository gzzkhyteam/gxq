package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
@Data
public class OrgDataDTO {
    @ApiModelProperty(value = "目录数量",required = true)
    private List<Integer> dirList;
    @ApiModelProperty(value = "api数量",required = true)
    private List<Integer> apiList;
    @ApiModelProperty(value = "单位名称",required = true)
    private List<String> orgList;


}

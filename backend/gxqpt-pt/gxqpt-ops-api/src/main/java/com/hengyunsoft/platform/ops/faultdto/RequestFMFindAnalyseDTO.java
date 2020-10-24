package com.hengyunsoft.platform.ops.faultdto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * @author wt
 * @createTime 2018-07-27
 */
@Data
@ApiModel(value = "RequestFMFindAnalyse", description = "应用分析查询接收信息")
public class RequestFMFindAnalyseDTO implements Serializable{

    @ApiModelProperty(value = "应用ID")
    private String appId;

    @ApiModelProperty(value = "时间类别 天-1、周-2、月-3、年-4")
    private Integer timeType;
}

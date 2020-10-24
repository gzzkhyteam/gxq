package com.hengyunsoft.platform.exchange.entity.directory.po.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ShareDataDirecoryUnitNumDO  implements Serializable {

    @ApiModelProperty(value = "单位名称")
    private String unitName;

    @ApiModelProperty(value = "总数")
    private Integer totalNum;

    @ApiModelProperty(value = "开放数量")
    private Integer openNum;

    @ApiModelProperty(value = "共享数量")
    private Integer shareNum;


    @ApiModelProperty(value = "有条件共享量")
    private Integer condShareNum;

    @ApiModelProperty(value = "无条件共享量")
    private Integer noShareNum;

    @ApiModelProperty(value = "创建年月")
    private String createMonth;


}
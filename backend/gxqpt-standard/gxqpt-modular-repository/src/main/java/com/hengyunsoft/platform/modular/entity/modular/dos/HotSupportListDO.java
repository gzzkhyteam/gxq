package com.hengyunsoft.platform.modular.entity.modular.dos;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "HotSupport", description = "热力图top10")
public class HotSupportListDO {

    @ApiModelProperty(value = "单位名称")
    private String name;
    @ApiModelProperty(value = "模块数")
    private Integer count;
    @ApiModelProperty(value = "最近更新时间")
    private Date updateTime;
    @ApiModelProperty(value = "平均更新时间(天)")
    private Integer avgTime;
}

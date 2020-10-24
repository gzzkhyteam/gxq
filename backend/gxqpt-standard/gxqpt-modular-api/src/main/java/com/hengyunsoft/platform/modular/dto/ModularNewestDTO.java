package com.hengyunsoft.platform.modular.dto;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ModularNewestDTO", description = "最新模块榜")
public class ModularNewestDTO {
    @ApiModelProperty(value = "模块id")
    private Long id;
    @ApiModelProperty(value = "模块名称")
    private String name;
    @ApiModelProperty(value = "发布时间")
    private Date date;
    @ApiModelProperty(value = "标签")
    private String tag;
    @ApiModelProperty(value = "下载量")
    private Integer downloadNum;
}

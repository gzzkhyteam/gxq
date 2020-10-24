package com.hengyunsoft.platform.exchange.entity.system.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JoinOrgDO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "单位Id")
    private String unitId;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = "目录数量")
    private Integer dirCount;

}

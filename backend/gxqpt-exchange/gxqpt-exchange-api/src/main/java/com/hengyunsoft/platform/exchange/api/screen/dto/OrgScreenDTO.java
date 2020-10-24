package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrgScreenDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "单位id")
    private String unitId;
    @ApiModelProperty(value = "数量")
    private int dataCount;

}

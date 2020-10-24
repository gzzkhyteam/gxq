package com.hengyunsoft.platform.exchange.entity.screen.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrgScreenDO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "单位id")
    private String unitId;
    @ApiModelProperty(value = "数量")
    private int dataCount;

}

package com.hengyunsoft.platform.exchange.entity.screen.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class OrgDO implements Serializable{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "单位id")
    private String unitId;
    @ApiModelProperty(value = "单位名称")
    private String unitName;
    @ApiModelProperty(value = "单位图标")
    private String iconUrl;

}

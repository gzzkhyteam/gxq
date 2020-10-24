package com.hengyunsoft.platform.exchange.entity.api.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ShareDataApiUnitDO {
    @ApiModelProperty(value = "单位Id")
    private String unitId;
    @ApiModelProperty(value = "操作类型:1:新增，2：修改，3：删除")
    private Integer optType;
}

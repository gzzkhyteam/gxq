package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgPolyRes", description = "单位聚合返回")
public class GxqptOrgPolyResDTO extends GxqptOrgResDTO{
    /**
     * 所属体系
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属体系")
    private String systemCode;
}

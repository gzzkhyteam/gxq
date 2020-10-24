package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgAndSys", description = "对外-体系编码和单位id的model")
public class GxqptOrgAndSysDTO {

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String orgId;

    /**
     * 体系编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "体系编码")
    private String systemCode;
}

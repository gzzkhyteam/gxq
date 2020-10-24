package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgByUser", description = "单位+体系返回")
public class GxqptOrgByUserDTO {
    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String id;
    /**
     * 单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位名称")
    private String name;
    /**
     * 所属体系
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属体系")
    private String systemCode;
}

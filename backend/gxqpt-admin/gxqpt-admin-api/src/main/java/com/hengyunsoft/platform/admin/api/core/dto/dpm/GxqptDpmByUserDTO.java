package com.hengyunsoft.platform.admin.api.core.dto.dpm;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GxqptDpmByUserDTO {
    /**
     * 部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门id")
    private String id;
    /**
     * 部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门名称")
    private String name;
    /**
     * 部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属单位id")
    private String orgId;
    /**
     * 体系
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "部门名称")
    private String systemCode;
}

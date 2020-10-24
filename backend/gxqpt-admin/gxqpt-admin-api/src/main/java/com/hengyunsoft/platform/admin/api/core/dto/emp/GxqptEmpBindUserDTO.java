package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 高新区一体化平台用户绑定DTO
 */
@Data
public class GxqptEmpBindUserDTO {
    /**
     * 系统编码
     */
    @ApiModelProperty(value = "系统编码")
    private String systemCode;

    /**
     * 人员ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "人员id")
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

}

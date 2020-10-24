package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "MsgsMessageMobileDTO", description = "移动终端")
public class MsgsMessageMobileDTO {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
}

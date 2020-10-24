package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptEmpEmailLikeResDTO", description = "邮件系统专用人员模糊查询出参")
public class GxqptEmpEmailLikeResDTO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * 人员名
     */
    @ApiModelProperty(value = "人员名")
    private String name;
    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登录账号")
    private String nickname;
    /**
     * 手机1
     */
    @ApiModelProperty(value = "手机1")
    private String mainmobile;
}

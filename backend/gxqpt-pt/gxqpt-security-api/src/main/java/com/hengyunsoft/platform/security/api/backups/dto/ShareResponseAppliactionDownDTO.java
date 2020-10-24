package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareResponseAppliactionDown", description = "备份系统名称下拉框返回信息")
public class ShareResponseAppliactionDownDTO implements Serializable {

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份系统名称")
    private String applicationName;
}

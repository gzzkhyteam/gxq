package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareResponseBackupsDownName", description = "备份系统名称下拉框返回信息")
public class ShareResponseBackupsDownNameDTO implements Serializable {

    /**
     * 备份名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份名称")
    private String name;
}

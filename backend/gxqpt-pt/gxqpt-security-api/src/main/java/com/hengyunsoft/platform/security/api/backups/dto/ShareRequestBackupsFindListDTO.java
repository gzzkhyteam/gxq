package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareRequestBackupsFindList", description = "备份数据列表接收信息")
public class ShareRequestBackupsFindListDTO implements Serializable {

    /**
     * 数据库类型 mysql oracle sqlserver mongodb hbase
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型")
    private Integer dbType;


    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份系统名称")
    private String applicationName;
}

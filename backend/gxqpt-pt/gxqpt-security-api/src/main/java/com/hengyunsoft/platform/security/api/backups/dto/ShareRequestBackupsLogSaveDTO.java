package com.hengyunsoft.platform.security.api.backups.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareRequestBackupsLogSave", description = "保存备份日志数据接收信息")
public class ShareRequestBackupsLogSaveDTO implements Serializable {


    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 备份日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
}

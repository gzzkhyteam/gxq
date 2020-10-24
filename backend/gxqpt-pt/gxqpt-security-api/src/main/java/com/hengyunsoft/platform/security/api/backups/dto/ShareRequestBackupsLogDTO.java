package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareRequestBackupsLog", description = "备份查询监控数据接收信息")
public class ShareRequestBackupsLogDTO implements Serializable {


    /**
     * 备份名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份名称")
    private String name;

    /**
     * 备份系统名称 查b_application表
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份系统名称")
    private String applicationName;

    /**
     * 日期yyyy-mm
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日期-年月")
    private String yearMonth;
}

package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseBackupsLog", description = "备份监控数据查询返回信息")
public class ShareResponseBackupsLogDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 备份表主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份表主键id")
    private Long backupsId;

    /**
     * 创建日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建日期")
    private Date createTime;

}

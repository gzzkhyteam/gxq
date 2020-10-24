package com.hengyunsoft.platform.security.api.backups.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareResponseBackupsFindList", description = "备份数据列表返回信息")
public class ShareResponseBackupsFindListDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

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
     * 备份路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份路径")
    private String path;

    /**
     * 文件后缀
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件后缀")
    private String fileExt;


    /**
     * 备份频率(定时表达式) 直接填
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备份频率")
    private String backupFrequency;

    /**
     * 检查标示
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "检查标示")
    private Boolean checkMark;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
}

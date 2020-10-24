package com.hengyunsoft.platform.security.api.assessment.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "ShareRequestProgramUpdate", description = "程序发布修改接收信息")
public class ShareRequestProgramUpdateDTO implements Serializable {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String name;

    /**
     * 版本名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "版本名称")
    private String versionName;

    /**
     * 版本号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "版本号")
    private String versionId;

    /**
     * 服务ip
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务ip")
    private String serverIp;

    /**
     * 发布文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布文件id")
    private Long upgradeFileId;

    /**
     * 发布文件链接
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布文件链接")
    private String upgradeFileUrl;

    /**
     * 发布文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布文件名称")
    private String upgradeFileName;

    /**
     * 升级内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "升级内容")
    private String upgradeConent;
}

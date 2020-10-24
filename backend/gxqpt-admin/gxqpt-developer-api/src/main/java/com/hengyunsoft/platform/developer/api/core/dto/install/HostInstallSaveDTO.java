package com.hengyunsoft.platform.developer.api.core.dto.install;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "HostInstallSave", description = "新建部署实体")
public class HostInstallSaveDTO {
    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 主机id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机id")
    private Long hostId;

    /**
     * 安装部署路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "安装部署路径")
    private String installPath;

    /**
     * 内存（单位M）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内存（单位M）")
    private Integer mem;

    /**
     * 硬盘容量(单位M)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "硬盘容量(单位M)")
    private Integer harddisk;

    /**
     * 首页访问地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "首页访问地址")
    private String indexUrl;

    /**
     * 状态     1、故障中；20、升级中；30、  运行中
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态     1、故障中；20、升级中；30、  运行中")
    private Integer status;

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用版本")
    private String version;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}

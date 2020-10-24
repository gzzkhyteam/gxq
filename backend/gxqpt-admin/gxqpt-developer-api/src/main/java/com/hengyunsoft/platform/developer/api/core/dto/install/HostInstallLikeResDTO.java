package com.hengyunsoft.platform.developer.api.core.dto.install;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "HostInstallLikeRes", description = "模糊查询部署返回实体")
public class HostInstallLikeResDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用appid")
    private String appId;

    /**
     * 所属应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属应用名称")
    private String appName;

    /**
     * 主机id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机id")
    private Long hostId;

    /**
     * 应用版本
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用版本")
    private String version;

    /**
     * 主机名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主机名称")
    private String hostName;

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
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String remark;
}

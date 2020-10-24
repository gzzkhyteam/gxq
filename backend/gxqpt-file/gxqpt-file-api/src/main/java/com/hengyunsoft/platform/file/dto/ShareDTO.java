package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Share", description = "分享根目录")
public class ShareDTO implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 分享目录名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享目录名")
    private String shareName;
    /**
     * 图标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
     * 链接
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "链接")
    private String url;
    /**
     * 分享密码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享密码")
    private String sharePassword;
    /**
     * 下载次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下载次数")
    private Integer downloadTimes;
    /**
     * 浏览次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "浏览次数")
    private Integer browsTimes;
    /**
     * 保存次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "保存次数")
    private Integer saveTimes;
    /**
     * 分享时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享时间")
    private Date createTime;
    /**
     * 分享过期时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享过期时间")
    private Date valid;
}

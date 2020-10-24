package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareFile", description = "分享子文件")
public class ShareFileDTO implements Serializable {
    @ApiModelProperty(value = "分享子文件id")
    private Long id;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名")
    private String submittedFileName;

    /**
     * 大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大小")
    private String size;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 链接
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "链接")
    private String url;

    /**
     * 数据类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据类型")
    private String dataType;

    /**
     * 图标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图标")
    private String icon;
}

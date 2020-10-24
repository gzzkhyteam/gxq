package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ShareUrl", description = "分享链接访问返回")
public class ShareUrlDTO {
    /**
     * 分享id
     */
    @ApiModelProperty(value = "分享id")
    private Long Id;
    /**
     * 分享人id
     */
    @ApiModelProperty(value = "分享人id")
    private String adminId;
    /**
     * 分享人姓名
     */
    @ApiModelProperty(value = "分享人姓名")
    private String adminName;
    /**
     * 是否过期
     */
    @ApiModelProperty(value = "是否过期")
    private Boolean timeTag;
    /**
     * 是否加密
     */
    @ApiModelProperty(value = "是否加密")
    private Boolean passwordTag;
    /**
     * 分享文件名
     */
    @ApiModelProperty(value = "分享文件名")
    private String shareName;
    /**
     * 分享日期
     */
    @ApiModelProperty(value = "分享日期")
    private String createTime;
    /**
     * 返回实体集合
     */
    @ApiModelProperty(value = "返回实体集合")
    private List<ShareFileDTO> shareFiles;
}

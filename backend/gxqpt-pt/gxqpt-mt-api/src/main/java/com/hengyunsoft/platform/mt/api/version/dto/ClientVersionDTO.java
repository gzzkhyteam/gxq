package com.hengyunsoft.platform.mt.api.version.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * com.hengyunsoft.platform.mt.version.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：版本详情
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：
 */
@Data
@ApiModel(value = "ClientVersion", description = "版本详情")
public class ClientVersionDTO {
    @ApiModelProperty(value = "版本id")
    private Long id;

    @ApiModelProperty(value = "版本名称")
    private String verName;

    @ApiModelProperty(value = "版本号")
    private Integer verNumber;

    @ApiModelProperty(value = "状态(1,未发布,2已发布)")
    private Integer state;

    @ApiModelProperty(value = "发布日期")
    private Date publishTime;

    @ApiModelProperty(value = "升级内容")
    private String updateContent;

    @ApiModelProperty(value = "升级数量")
    private Integer updateNum;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "文件大小")
    private String apkFileSize;

    @ApiModelProperty(value = "是否强制更新(1不强制,2强制)")
    private Integer pwUpdate;

    @ApiModelProperty(value = "文件id")
    private String apkFileId;

    @ApiModelProperty(value = "文件名称")
    private String apkFileName;

    @ApiModelProperty(value = "文件路径")
    private String apkFilePath;

    @ApiModelProperty(value = "二维码图片路径")
    private String downQrCode;


}

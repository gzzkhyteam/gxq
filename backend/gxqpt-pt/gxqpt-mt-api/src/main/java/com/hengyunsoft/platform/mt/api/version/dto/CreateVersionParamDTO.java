package com.hengyunsoft.platform.mt.api.version.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.version.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建版本请求参数
 * 修改人：gbl
 * 修改时间：2018/5/27
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateVersionParam", description = "创建版本请求参数")
public class CreateVersionParamDTO {
    @ApiModelProperty(value = "版本id，编辑有id，新增无id")
    private Long id;

    @ApiModelProperty(value = "版本名称")
    private String verName;

    @ApiModelProperty(value = "版本号")
    private Integer verNumber;

    @ApiModelProperty(value = "升级内容")
    private String updateContent;

    @ApiModelProperty(value = "文件id")
    private String apkFileId;

    @ApiModelProperty(value = "文件名称")
    private String apkFileName;

    @ApiModelProperty(value = "文件路径")
    private String apkFilePath;

    @ApiModelProperty(value = "文件大小")
    private String apkFileSize;

    @ApiModelProperty(value = "是否强制更新(1不强制,2强制)")
    private Integer pwUpdate;
}

package com.hengyunsoft.platform.mt.api.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.file.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：创建文件参数
 * 修改人：gbl
 * 修改时间：2018/6/22
 * 修改内容：
 */
@Data
@ApiModel(value = "CreateFile", description = "创建文件参数")
public class CreateFileDTO {
    @ApiModelProperty(value = "文件id")
    private Long fileId;

    @ApiModelProperty(value = " 文件名")
    private String fileName;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "文件类型")
    private String fileType;

    @ApiModelProperty(value = "文件路径")
    private String fileUrl;
}

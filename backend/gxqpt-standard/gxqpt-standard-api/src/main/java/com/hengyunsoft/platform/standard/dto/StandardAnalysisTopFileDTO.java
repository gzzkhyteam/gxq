package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "StandardTopFile", description = "文档下载top10")
public class StandardAnalysisTopFileDTO {
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 文档名称
     */
    @ApiModelProperty(value = "文档名称")
    private String name;

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件服务器文件id")
    private String documentId;

    /**
     *下载次数
     */
    @ApiModelProperty(value = "下载次数")
    private Integer downloadCount;

}

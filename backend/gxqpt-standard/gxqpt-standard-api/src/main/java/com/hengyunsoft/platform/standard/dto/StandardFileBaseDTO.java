package com.hengyunsoft.platform.standard.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "StandardClassifyApply", description = "标准分类申请信息")
public class StandardFileBaseDTO {
    /**
     * 文档名称
     */
    @ApiModelProperty(value = "文档名称")
    private String name;

    /**
     *文档编码
     */
    @ApiModelProperty(value = "文档编码")
    private String code;

    /**
     *文档分类
     */
    @ApiModelProperty(value = "文档分类")
    private String classifyId;
    /**
     *文档类型
     */
    @ApiModelProperty(value = "文档类型")
    private String fileType;

    /**
     *文档描述
     */
    @ApiModelProperty(value = "文档描述")
    private String description;

    /**
     *版本
     */
    @ApiModelProperty(value = "版本")
    private String version;

    /**
     * 文件服务器文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件服务器文件id")
    private String documentId;

}

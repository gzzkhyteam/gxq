package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tyh
 * @createTime 2018-01-27 20:08
 */
@Data
@ApiModel(value = "UploadFile", description = "上传文件返回对象")
public class UploadFileDTO implements Serializable {
    @ApiModelProperty(value = "主键id")
    private Long id;
    @ApiModelProperty(value = "文件url")
    private String url;

    /**
     * 类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件mime类型")
    private String mime;

    /**
     * 原始文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "原始文件名")
    private String submittedFileName;

    /**
     * 文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "唯一文件名")
    private String filename;

    /**
     * 后缀 (没有.)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "后缀")
    private String ext;

    /**
     * 大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大小")
    private String size;

    @ApiModelProperty(value = "文件类型 IMAGE/VIDEO/AUDIO/DOC/OTHER/DIR", example = "IMAGE/VIDEO/AUDIO/DOC/OTHER/DIR")
    private String dataType;
}

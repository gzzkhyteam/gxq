package com.hengyunsoft.platform.file.dto.image;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "BaseFile", description = "文件基础对象")
public class BaseFileDTO implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 文件名
     */
    @ApiModelProperty(value = "文件名")
    private String submittedFileName;
    /**
     * 文件链接
     */
    @ApiModelProperty(value = "文件链接")
    private String url;
    /**
     * 文件尺寸
     */
    @ApiModelProperty(value = "文件尺寸(单位/B)")
    private String size;
    /**
     * 后缀
     */
    @ApiModelProperty(value = "后缀")
    private String ext;
    /**
     * 唯一文件名
     */
    @ApiModelProperty(value = "唯一文件名")
    private String filename;
    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    private String mime;

    public BaseFileDTO(){

    }
    public BaseFileDTO(Long id, String submittedFileName, String url, String size, String ext, String filename, String mime) {
        this.id = id;
        this.submittedFileName = submittedFileName;
        this.url = url;
        this.size = size;
        this.ext = ext;
        this.filename = filename;
        this.mime = mime;
    }
}

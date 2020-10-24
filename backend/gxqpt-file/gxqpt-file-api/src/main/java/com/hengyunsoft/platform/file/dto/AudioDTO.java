package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "Audio", description = "音频文件")
public class AudioDTO implements Serializable {

    /**
     * 链接
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件url")
    private String url;

    /**
     * 语音转文字返回数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "语音转文字返回数据")
    private String characters;

    @ApiModelProperty(value = "原始文件名")
    private String submittedFileName;
    /**
     * 大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大小")
    private String size;

}

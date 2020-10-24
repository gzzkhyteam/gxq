package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 08:42
 * @desc 个人文件类型DTO
 * @Version 1.0
 **/
@Data
@ApiModel(value = "FileTypeViewDTO", description = "云盘个人文件类型大小DTO")
public class FileTypeViewDTO {

    @ApiModelProperty(value = "图片文件大小")
    private String imgSize;

    @ApiModelProperty(value = "文档文件大小")
    private String docSize;

    @ApiModelProperty(value = "视频文件大小")
    private String videoSize;

    @ApiModelProperty(value = "音频文件大小")
    private String audioSize;

    @ApiModelProperty(value = "其他文件大小")
    private String otherSize;

}

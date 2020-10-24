package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 13:37
 * @desc 文件分享数量分析
 * @Version 1.0
 **/
@Data
@ApiModel(value = "FileShareViewDTO", description = "云盘个人文件分享数量概览DTO")
public class FileShareViewDTO {

    @ApiModelProperty(value = "分享总文件数")
    private Integer shareNum;

    @ApiModelProperty(value = "总文件数")
    private Integer allNum;

    @ApiModelProperty(value = "分享doc文件数")
    private Integer shareDocNum;

    @ApiModelProperty(value = "doc文件数")
    private Integer docNum;

    @ApiModelProperty(value = "分享img文件数")
    private Integer shareImgNum;

    @ApiModelProperty(value = "img文件数")
    private Integer imgNum;

    @ApiModelProperty(value = "分享video文件数")
    private Integer shareVideoNum;

    @ApiModelProperty(value = "video文件数")
    private Integer videoNum;

    @ApiModelProperty(value = "分享audio文件数")
    private Integer shareAudioNum;

    @ApiModelProperty(value = "audio文件数")
    private Integer audioNum;

    @ApiModelProperty(value = "分享other文件数")
    private Integer shareOthNum;

    @ApiModelProperty(value = "other文件数")
    private Integer othNum;

}

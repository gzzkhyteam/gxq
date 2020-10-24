package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author madengbo
 * @create 2018-09-06 08:29
 * @desc 云盘首页数据概览
 * @Version 1.0
 **/
@Data
@ApiModel(value = "FileDataViewDTO", description = "云盘个人数量概览DTO")
public class FileDataViewDTO {

    @ApiModelProperty(value = "所有文件数量")
    private Integer fileNum;

    @ApiModelProperty(value = "所有文件大小")
    private String fileSize;

    @ApiModelProperty(value = "图片文件数量")
    private Integer imgNum;

    @ApiModelProperty(value = "文档文件数量")
    private Integer docNum;

    @ApiModelProperty(value = "视频文件数量")
    private Integer videoNum;

    @ApiModelProperty(value = "视音频文件数量")
    private Integer audioNum;

    @ApiModelProperty(value = "其他文件数量")
    private Integer otherNum;

    @ApiModelProperty(value = "个人分享次数")
    private Integer myShareNum;


}

package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "FileSwf", description = "文件")
public class FileSwfDTO implements Serializable {

    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 文件swf路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件swf")
    private String swf;


}

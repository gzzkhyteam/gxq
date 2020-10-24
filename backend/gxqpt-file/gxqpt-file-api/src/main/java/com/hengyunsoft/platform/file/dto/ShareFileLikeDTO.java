package com.hengyunsoft.platform.file.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ShareFileLike", description = "子文件模糊查找")
public class ShareFileLikeDTO {
    @ApiModelProperty(value = "父文件id")
    private Long id;
    @ApiModelProperty(value = "子文件名称")
    private String name;
}

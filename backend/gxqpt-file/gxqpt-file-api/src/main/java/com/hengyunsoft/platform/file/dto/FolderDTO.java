package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "Folder", description = "文件夹")
public class FolderDTO extends BaseFolderDTO implements Serializable {
    @ApiModelProperty(value = "id", notes = "文件夹id", required = true)
    private Long id;
}

package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "FileList", description = "文件列表")
public class FileListDTO implements Serializable {
    @ApiModelProperty(value = "文件列表集合")
    private List<FileDTO> list = new ArrayList<>();
}

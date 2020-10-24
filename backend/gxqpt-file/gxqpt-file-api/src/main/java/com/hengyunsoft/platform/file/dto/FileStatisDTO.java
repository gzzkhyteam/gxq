package com.hengyunsoft.platform.file.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "FileStatis", description = "文件统计对象")
public class FileStatisDTO {
    private Long fileId;
    private Integer downCount;
}

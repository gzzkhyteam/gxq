package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "UploadList", description = "上传文件返回列表对象")
public class UploadListDTO implements Serializable {
    private List<UploadFileDTO> list = new ArrayList<>();
}

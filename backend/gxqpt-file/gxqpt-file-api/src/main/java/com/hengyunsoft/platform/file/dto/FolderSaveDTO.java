package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "FolderSave", description = "文件夹保存")
public class FolderSaveDTO extends BaseFolderDTO implements Serializable {
}

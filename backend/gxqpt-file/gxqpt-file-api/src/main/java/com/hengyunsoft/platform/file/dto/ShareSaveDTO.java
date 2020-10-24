package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ShareSave", description = "保存至我的文件")
public class ShareSaveDTO {
    /**
     * 保存到用户的文件夹id
     */
    @ApiModelProperty(value = "保存到用户的文件夹id")
    private Long folderId;
    /**
     * 需要保存的文件id
     */
    @ApiModelProperty(value = "需要保存的文件id")
    private List<Long> fileIds;
    /**
     * 保存时的分享id(主要用于调用"保存次数接口")
     */
    @ApiModelProperty(value = "保存时的分享id(主要用于调用\"保存次数接口\")")
    private Long shareId;
}

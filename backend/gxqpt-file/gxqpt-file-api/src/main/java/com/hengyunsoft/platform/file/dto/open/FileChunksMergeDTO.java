package com.hengyunsoft.platform.file.dto.open;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/08/28
 */
@Data
@ApiModel(value = "FileChunksMerge", description = "文件合并实体")
public class FileChunksMergeDTO {

    @ApiModelProperty(value = "文件唯一名 md5.js生成的, 与后端生成的一致")
    private String name;
    @ApiModelProperty(value = "原始文件名")
    private String submittedFileName;

    @ApiModelProperty(value = "md5", notes = "webuploader 自带的md5算法值， 与后端生成的不一致")
    private String md5;

    @ApiModelProperty(value = "分片总数")
    private int chunks;
    @ApiModelProperty(value = "后缀")
    private String ext;
    @ApiModelProperty(value = "用户id")
    private Long userId;
}

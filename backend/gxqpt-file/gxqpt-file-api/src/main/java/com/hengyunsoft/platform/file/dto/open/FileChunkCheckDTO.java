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
@ApiModel(value = "FileChunkCheck", description = "文件分片信息")
public class FileChunkCheckDTO {

    @ApiModelProperty(value = "文件大小")
    private Long size;
    @ApiModelProperty(value = "文件唯一名")
    private String name;
    @ApiModelProperty(value = "分片索引")
    private int chunkIndex;
}

package com.hengyunsoft.platform.file.dto.open;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/08/29
 */
@Data
@ApiModel(value = "FileUpload", description = "文件分片上传实体")
public class FileUploadDTO {
    @ApiModelProperty(value = "md5", notes = "webuploader 自带的md5算法值， 与后端生成的不一致")

    private String md5;
    //    private int chunkIndex;
    @ApiModelProperty(value = "大小")
    private String size;
    @ApiModelProperty(value = "文件唯一名 md5.js生成的, 与后端生成的一致")
    private String name;
    //    private String userId;
//    private String id;
    @ApiModelProperty(value = "分片总数")
    private int chunks;
    @ApiModelProperty(value = "当前分片")
    private int chunk;
    @ApiModelProperty(value = "最后更新时间")
    private String lastModifiedDate;
    @ApiModelProperty(value = "类型")
    private String type;
    @ApiModelProperty(value = "后缀")
    private String ext;
    @ApiModelProperty(value = "用户id")
    private Long userId;
}

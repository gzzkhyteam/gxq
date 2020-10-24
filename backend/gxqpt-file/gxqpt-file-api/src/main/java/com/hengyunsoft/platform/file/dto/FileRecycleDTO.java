package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 回收站实体
 */
@Data
@ApiModel(value = "FileRecycle", description = "回收站")
public class FileRecycleDTO {
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 原始文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "原始文件名")
    private String submittedFileName;

    /**
     * 父文件夹名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父文件夹名称")
    private String folderName;

    /**
     * 大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "大小")
    private String size;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 文件夹Id
     */
    @ApiModelProperty(value = "文件夹Id")
    private Long folderId;

    /**
     * 数据类型
     */
    @ApiModelProperty(value = "数据类型 null和''表示查询全部 图片：IMAGE 视频：VIDEO 音频：AUDIO 文档DOC 其他：OTHER", example = "IMAGE,VIDEO,AUDIO,DOC,OTHER")
    private String dataType;

    /**
     * 图标
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "图标")
    private String icon;

    /**
     * 是否为一级删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否为一级删除")
    private Boolean isOneLevelDelete;

    /**
     * 父目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父目录")
    private String treePath;
}

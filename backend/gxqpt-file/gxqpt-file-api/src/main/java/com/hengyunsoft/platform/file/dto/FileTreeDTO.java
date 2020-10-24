package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "FileTree", description = "文件夹树结构")
public class FileTreeDTO {
    @ApiModelProperty(value = "本文件id")
    private Long id;

    /**
     * 文件夹id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件夹id")
    private Long folderId;

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名称")
    private String submittedFileName;

    /**
     * 子文件
     */
    @ApiModelProperty(value = "子文件")
    private List<FileTreeDTO> childFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public String getSubmittedFileName() {
        return submittedFileName;
    }

    public void setSubmittedFileName(String submittedFileName) {
        this.submittedFileName = submittedFileName;
    }

    public List<FileTreeDTO> getChildFile() {
        return childFile;
    }

    public void setChildFile(List<FileTreeDTO> childFile) {
        this.childFile = childFile;
    }
}

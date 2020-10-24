package com.hengyunsoft.platform.standard.entity.standard.domain;

import com.hengyunsoft.platform.standard.entity.standard.po.StandardClassify;

public class StandardClassifyDO extends StandardClassify {
    /**
     * 父分类名称
     */
    private String parentName;

    /**
     * 文档数量
     */
    private Integer fileCount;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getFileCount() {
        return fileCount;
    }

    public void setFileCount(Integer fileCount) {
        this.fileCount = fileCount;
    }
}

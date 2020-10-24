package com.hengyunsoft.platform.standard.entity.standard.domain;

import com.hengyunsoft.platform.standard.entity.standard.po.StandardFile;

public class StandardFileDO extends StandardFile {
    /**
     * 标准分类名称
     */
    private String classifyName;

    /**
     * 文档下载次数
     */
    private Integer downloadCount;

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}

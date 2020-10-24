package com.hengyunsoft.platform.standard.entity.standard.domain;

import com.hengyunsoft.platform.standard.entity.standard.po.StandardFileLog;

public class StandardFileLogDO extends StandardFileLog {

    /**
     * 文档名称
     *
     * @mbggenerated
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }
}

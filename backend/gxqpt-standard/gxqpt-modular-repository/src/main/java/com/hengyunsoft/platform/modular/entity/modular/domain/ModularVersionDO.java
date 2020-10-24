package com.hengyunsoft.platform.modular.entity.modular.domain;


import com.hengyunsoft.platform.modular.entity.modular.po.ModularVersion;

public class ModularVersionDO extends ModularVersion {

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 下载路径
     */
    private String downloadUrl;

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}

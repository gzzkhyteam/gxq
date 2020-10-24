package com.hengyunsoft.platform.modular.entity.modular.domain;


import java.util.List;

public class NexusModularVersionDO {

    /**
     * 主键id
     */
    private String id;

    /**
     * 仓库名称
     */
    private String repository;

    /**
     * 格式
     */
    private String format;
    /**
     * 下载路径
     */
    private String downloadUrl;
    /**
     * 相对路径
     */
    private String path;

    /**
     * 版本号
     */
    private String checksum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

}
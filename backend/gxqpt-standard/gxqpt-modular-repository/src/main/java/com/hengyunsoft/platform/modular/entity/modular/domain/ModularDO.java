package com.hengyunsoft.platform.modular.entity.modular.domain;


import java.util.List;

import com.hengyunsoft.platform.modular.entity.modular.po.Modular;

public class ModularDO extends Modular {

	private static final long serialVersionUID = 1L;

	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 各文档的属性
	 */
	private List<VersionParamsDO> files;

    /**
     * 下载次数
     */
    private Integer downloadCount;

    /**
     * 分类列表
     */
    private List<ModularCategoryAndTagDO> mclist;

    /**
     * 分类列表
     */
    private String modularType;

    /**
     * 标签列表
     */
    private List<ModularCategoryAndTagDO> mtlist;
    
    
    public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}	
	
	public List<VersionParamsDO> getFiles() {
		return files;
	}

	public void setFiles(List<VersionParamsDO> files) {
		this.files = files;
	}

	public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<ModularCategoryAndTagDO> getMclist() {
        return mclist;
    }

    public void setMclist(List<ModularCategoryAndTagDO> mclist) {
        this.mclist = mclist;
    }

    public List<ModularCategoryAndTagDO> getMtlist() {
        return mtlist;
    }

    public void setMtlist(List<ModularCategoryAndTagDO> mtlist) {
        this.mtlist = mtlist;
    }

    public String getModularType() {
        return modularType;
    }

    public void setModularType(String modularType) {
        this.modularType = modularType;
    }
}

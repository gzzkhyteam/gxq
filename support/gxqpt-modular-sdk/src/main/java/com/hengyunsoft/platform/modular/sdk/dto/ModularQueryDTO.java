package com.hengyunsoft.platform.modular.sdk.dto;


/**
 * 模块查询传参的实体类
 *
 * @author zhoukx
 * @createTime 2018-4-16
 */
public class ModularQueryDTO {

    /**
     * 仓库名称
     */
    private String repName;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 模块描述
     */
    private String description;

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

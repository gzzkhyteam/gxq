package com.hengyunsoft.platform.modular.repository.modular.example;


import lombok.Data;

/**
 * 模块查询传参用的实体
 */
@Data
public class ModularQueryEntity {

    /**
     * 仓库名称
     */
    private String repName;

    /**
     * 模块分类
     */
    private String modularType;

    /**
     * 模块标签
     */
    private String modularTag;

    /**
     * 模糊查询参数
     */
    private String mateParam;

    /**
     * groupId
     */
    private String groupId;

    /**
     * artifactId
     */
    private String artifactId;

    /**
     * 创建用户
     */
    private Long createUser;

}

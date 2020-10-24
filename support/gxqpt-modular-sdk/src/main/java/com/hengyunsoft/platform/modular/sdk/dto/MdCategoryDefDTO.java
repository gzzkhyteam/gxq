package com.hengyunsoft.platform.modular.sdk.dto;

/**
 * 模块分类的实体类
 *
 * @author zkx
 * @create_time 2018-4-16
 */
public class MdCategoryDefDTO {

    /**
     * id主键
     */
    private Long id;

    /**
     * 模块分类名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

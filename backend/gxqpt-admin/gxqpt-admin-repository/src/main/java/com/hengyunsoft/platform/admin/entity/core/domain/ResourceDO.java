package com.hengyunsoft.platform.admin.entity.core.domain;

import com.hengyunsoft.platform.admin.entity.core.po.Resource;

import java.util.List;

public class ResourceDO extends Resource {

    private List<Resource> children;

    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }
}

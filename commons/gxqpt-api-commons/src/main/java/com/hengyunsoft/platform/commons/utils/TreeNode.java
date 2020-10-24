package com.hengyunsoft.platform.commons.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tyh
 * @createTime 2017-12-20 11:33
 */
public class TreeNode<T,I extends Serializable> {
    @ApiModelProperty(value = "id")
    protected I id;
    @ApiModelProperty(value = "父id")
    protected I parentId;
    @ApiModelProperty(value = "子tree")
    protected List<T> children = new ArrayList<>();

    @JsonIgnore
    public void add(T node) {
        children.add(node);
    }

    public Serializable getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public Serializable getParentId() {
        return parentId;
    }

    public void setParentId(I parentId) {
        this.parentId = parentId;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}

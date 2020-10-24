package com.hengyunsoft.platform.admin.api.core.dto.org;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ExcelParentDTO {

    /**
     * 上级单位id
     *
     * @mbggenerated
     */
    private String parentId;


    /**
     * 所属类型
     *
     * @mbggenerated
     */
    private String forType;

    /**
     * 所属级别
     *
     * @mbggenerated
     */
    private String forClass;

    /**
     * 所属系统如公安、税务等
     *
     * @mbggenerated
     */
    private String forindustry;

    /**
     * 单位归口是政府、人大、政协等
     *
     * @mbggenerated
     */
    private String forgk;

    /**
     * 单位节点类型 1为实体单位 0为分类
     *
     * @mbggenerated
     */
    private String fornodetype;
    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    private String isdelete;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getForType() {
        return forType;
    }

    public void setForType(String forType) {
        this.forType = forType;
    }

    public String getForClass() {
        return forClass;
    }

    public void setForClass(String forClass) {
        this.forClass = forClass;
    }

    public String getForindustry() {
        return forindustry;
    }

    public void setForindustry(String forindustry) {
        this.forindustry = forindustry;
    }

    public String getForgk() {
        return forgk;
    }

    public void setForgk(String forgk) {
        this.forgk = forgk;
    }

    public String getFornodetype() {
        return fornodetype;
    }

    public void setFornodetype(String fornodetype) {
        this.fornodetype = fornodetype;
    }
}

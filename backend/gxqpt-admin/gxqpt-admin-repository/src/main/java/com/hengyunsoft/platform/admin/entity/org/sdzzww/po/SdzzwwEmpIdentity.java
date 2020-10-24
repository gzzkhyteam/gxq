package com.hengyunsoft.platform.admin.entity.org.sdzzww.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class SdzzwwEmpIdentity extends BaseEntity<String> implements Serializable {
    /**
     * ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * 单位ID
     *
     * @mbggenerated
     */
    private String orgId;

    /**
     * 部门ID
     *
     * @mbggenerated
     */
    private String deptId;

    /**
     * 岗位ID
     *
     * @mbggenerated
     */
    private String postId;

    /**
     * 职务ID
     *
     * @mbggenerated
     */
    private String dutyId;

    /**
     * 说明
     *
     * @mbggenerated
     */
    private String description;

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    private String isheader;

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    private String isleader;

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    private String userduty;

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    private String isdelete;

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    private String isenable;

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    private String logid;

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
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 单位ID
     *
     * @mbggenerated
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 单位ID
     *
     * @mbggenerated
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    /**
     * 部门ID
     *
     * @mbggenerated
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 部门ID
     *
     * @mbggenerated
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * 岗位ID
     *
     * @mbggenerated
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 岗位ID
     *
     * @mbggenerated
     */
    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    /**
     * 职务ID
     *
     * @mbggenerated
     */
    public String getDutyId() {
        return dutyId;
    }

    /**
     * 职务ID
     *
     * @mbggenerated
     */
    public void setDutyId(String dutyId) {
        this.dutyId = dutyId == null ? null : dutyId.trim();
    }

    /**
     * 说明
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * 说明
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    public String getIsheader() {
        return isheader;
    }

    /**
     * 是否单位一把手
     *
     * @mbggenerated
     */
    public void setIsheader(String isheader) {
        this.isheader = isheader == null ? null : isheader.trim();
    }

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    public String getIsleader() {
        return isleader;
    }

    /**
     * 是否单位领导
     *
     * @mbggenerated
     */
    public void setIsleader(String isleader) {
        this.isleader = isleader == null ? null : isleader.trim();
    }

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    public String getUserduty() {
        return userduty;
    }

    /**
     * 人员职责
     *
     * @mbggenerated
     */
    public void setUserduty(String userduty) {
        this.userduty = userduty == null ? null : userduty.trim();
    }

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    public String getIsdelete() {
        return isdelete;
    }

    /**
     * 删除标记
     *
     * @mbggenerated
     */
    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    public String getIsenable() {
        return isenable;
    }

    /**
     * 启用标记
     *
     * @mbggenerated
     */
    public void setIsenable(String isenable) {
        this.isenable = isenable == null ? null : isenable.trim();
    }

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public String getLogid() {
        return logid;
    }

    /**
     * 同步人员明细记录的日志id， 供回写日志状态接口（见第五大点）调用
     *
     * @mbggenerated
     */
    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
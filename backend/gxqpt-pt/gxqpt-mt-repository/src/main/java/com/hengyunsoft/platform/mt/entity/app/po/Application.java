package com.hengyunsoft.platform.mt.entity.app.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class Application extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 应用类型(0:安卓,1:h5)
     *
     * @mbggenerated
     */
    private Integer appType;

    /**
     * 功能的话属于某一个应用，大于-1标识功能，-1表明该数据是应用
     *
     * @mbggenerated
     */
    private Long parentId;

    /**
     * 显示该功能的名称和提示的数量数据的接口
     *
     * @mbggenerated
     */
    private String showUrl;

    /**
     * 应用图标
     *
     * @mbggenerated
     */
    private String iconPath;

    /**
     * 审核状态(1暂存,2审核中,3通过,4驳回)
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * 应用路径
     *
     * @mbggenerated
     */
    private String appPath;

    /**
     * 应用说明
     *
     * @mbggenerated
     */
    private String appDesc;

    /**
     * Android的包名
     *
     * @mbggenerated
     */
    private String appPackageName;

    /**
     * Android的启动画面
     *
     * @mbggenerated
     */
    private String appStartAct;

    /**
     * 是否显示(1:不显示 ,2:显示)
     *
     * @mbggenerated
     */
    private Integer isShow;

    /**
     * 排序
     *
     * @mbggenerated
     */
    private Integer appOrder;

    /**
     * 创建类型(0:内部1:外部)
     *
     * @mbggenerated
     */
    private Integer createType;

    /**
     * 创建单位
     *
     * @mbggenerated
     */
    private String createEmp;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    private Long auditUser;

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    private Date auditTime;

    /**
     * 审批内容
     *
     * @mbggenerated
     */
    private String auditContent;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 应用类型(0:安卓,1:h5)
     *
     * @mbggenerated
     */
    public Integer getAppType() {
        return appType;
    }

    /**
     * 应用类型(0:安卓,1:h5)
     *
     * @mbggenerated
     */
    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    /**
     * 功能的话属于某一个应用，大于-1标识功能，-1表明该数据是应用
     *
     * @mbggenerated
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 功能的话属于某一个应用，大于-1标识功能，-1表明该数据是应用
     *
     * @mbggenerated
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 显示该功能的名称和提示的数量数据的接口
     *
     * @mbggenerated
     */
    public String getShowUrl() {
        return showUrl;
    }

    /**
     * 显示该功能的名称和提示的数量数据的接口
     *
     * @mbggenerated
     */
    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl == null ? null : showUrl.trim();
    }

    /**
     * 应用图标
     *
     * @mbggenerated
     */
    public String getIconPath() {
        return iconPath;
    }

    /**
     * 应用图标
     *
     * @mbggenerated
     */
    public void setIconPath(String iconPath) {
        this.iconPath = iconPath == null ? null : iconPath.trim();
    }

    /**
     * 审核状态(1暂存,2审核中,3通过,4驳回)
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * 审核状态(1暂存,2审核中,3通过,4驳回)
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 应用路径
     *
     * @mbggenerated
     */
    public String getAppPath() {
        return appPath;
    }

    /**
     * 应用路径
     *
     * @mbggenerated
     */
    public void setAppPath(String appPath) {
        this.appPath = appPath == null ? null : appPath.trim();
    }

    /**
     * 应用说明
     *
     * @mbggenerated
     */
    public String getAppDesc() {
        return appDesc;
    }

    /**
     * 应用说明
     *
     * @mbggenerated
     */
    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc == null ? null : appDesc.trim();
    }

    /**
     * Android的包名
     *
     * @mbggenerated
     */
    public String getAppPackageName() {
        return appPackageName;
    }

    /**
     * Android的包名
     *
     * @mbggenerated
     */
    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName == null ? null : appPackageName.trim();
    }

    /**
     * Android的启动画面
     *
     * @mbggenerated
     */
    public String getAppStartAct() {
        return appStartAct;
    }

    /**
     * Android的启动画面
     *
     * @mbggenerated
     */
    public void setAppStartAct(String appStartAct) {
        this.appStartAct = appStartAct == null ? null : appStartAct.trim();
    }

    /**
     * 是否显示(1:不显示 ,2:显示)
     *
     * @mbggenerated
     */
    public Integer getIsShow() {
        return isShow;
    }

    /**
     * 是否显示(1:不显示 ,2:显示)
     *
     * @mbggenerated
     */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    /**
     * 排序
     *
     * @mbggenerated
     */
    public Integer getAppOrder() {
        return appOrder;
    }

    /**
     * 排序
     *
     * @mbggenerated
     */
    public void setAppOrder(Integer appOrder) {
        this.appOrder = appOrder;
    }

    /**
     * 创建类型(0:内部1:外部)
     *
     * @mbggenerated
     */
    public Integer getCreateType() {
        return createType;
    }

    /**
     * 创建类型(0:内部1:外部)
     *
     * @mbggenerated
     */
    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    /**
     * 创建单位
     *
     * @mbggenerated
     */
    public String getCreateEmp() {
        return createEmp;
    }

    /**
     * 创建单位
     *
     * @mbggenerated
     */
    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp == null ? null : createEmp.trim();
    }

    /**
     * 审批人
     *
     * @mbggenerated
     */
    public Long getAuditUser() {
        return auditUser;
    }

    /**
     * 审批人
     *
     * @mbggenerated
     */
    public void setAuditUser(Long auditUser) {
        this.auditUser = auditUser;
    }

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    public Date getAuditTime() {
        return auditTime;
    }

    /**
     * 审批时间
     *
     * @mbggenerated
     */
    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    /**
     * 审批内容
     *
     * @mbggenerated
     */
    public String getAuditContent() {
        return auditContent;
    }

    /**
     * 审批内容
     *
     * @mbggenerated
     */
    public void setAuditContent(String auditContent) {
        this.auditContent = auditContent == null ? null : auditContent.trim();
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
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }



}
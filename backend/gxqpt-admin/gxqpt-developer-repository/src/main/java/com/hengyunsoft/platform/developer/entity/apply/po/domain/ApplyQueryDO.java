package com.hengyunsoft.platform.developer.entity.apply.po.domain;

import java.util.Date;

public class ApplyQueryDO {


    private Long id;


    /**
     * 任务标记  应用申请  功能申请   调用申请    应用审批  功能审批  调用审批
     */
    private String taskType;
    /**
     * 功能id
     *
     * @mbggenerated
     */
    private Long moduleId;

    /**
     * 应用appid
     *
     * @mbggenerated
     */
    private String appId;
    
    /**
     * 应用名称
     */
    private String appName;

    /**
     * 审核状态： 1  待审核     2 审核通过    3 审核不通过    
     *
     * @mbggenerated
     */
    private Short auditStatus;

    /**
     * 审核描述
     *
     * @mbggenerated
     */
    private String auditDesc;

    /**
     * 申请描述
     *
     * @mbggenerated
     */
    private String applyDesc;

    /**
     * 审批人
     *
     * @mbggenerated
     */
    private Long auditUser;

    /**
     * 申请人
     *
     * @mbggenerated
     */
    private Long applyUser;


    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;


    /**
     * 申请人名称
     *
     * @mbggenerated
     */
    private String applyUserName;

    /**
     * 审批人名称
     *
     * @mbggenerated
     */
    private String auditUserName;

    /**
     * 功能名称
     *
     * @mbggenerated
     */
    private String moduleName;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}


	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}

	public String getApplyDesc() {
		return applyDesc;
	}

	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}

	public Long getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(Long auditUser) {
		this.auditUser = auditUser;
	}

	public Long getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(Long applyUser) {
		this.applyUser = applyUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getApplyUserName() {
		return applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

    public Short getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Short auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

}

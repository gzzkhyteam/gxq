package com.hengyunsoft.rpc.data.po;

import java.util.Date;
public class UserPO{

	/**
     * ID
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 账号
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 密码
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 姓名
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 性别
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * 生日
     *
     * @mbggenerated
     */
    private Date birthday;

    /**
     * 民族
     *
     * @mbggenerated
     */
    private String nation;

    /**
     * 照片
     *
     * @mbggenerated
     */
    private String photo;

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    private String officetel;

    /**
     * 手机
     *
     * @mbggenerated
     */
    private String phone;

    /**
     * 工作描述：  市长、管理员、局长等等   用于登陆展示
     *
     * @mbggenerated
     */
    private String workDesc;

    /**
     * 工作状态
     *
     * @mbggenerated
     */
    private String workStatus;

    /**
     * 是否可登陆  1是 0否  [BooleanStatus]
     *
     * @mbggenerated
     */
    private Boolean loginable;

    /**
     * 存在于哪些体系中，   用0表示不存在  1表示存在   最大支持63个体系
     *
     * @mbggenerated
     */
    private String ownSystem;

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    private String descrption;

    /**
     * 用户类型   根据类型去关联更具体的用户信息   意思可以进行信息扩展
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    private Integer sortValue;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    private Long createUser;

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
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;
    
    private String orgId;
    private String orgName;
    
    private String deptId;
    private String deptName;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Boolean getLoginable() {
		return loginable;
	}

	public void setLoginable(Boolean loginable) {
		this.loginable = loginable;
	}

	public String getOwnSystem() {
		return ownSystem;
	}

	public void setOwnSystem(String ownSystem) {
		this.ownSystem = ownSystem;
	}

	public String getDescrption() {
		return descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSortValue() {
		return sortValue;
	}

	public void setSortValue(Integer sortValue) {
		this.sortValue = sortValue;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "UserPO [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", birthday=" + birthday + ", nation=" + nation + ", photo=" + photo + ", officetel="
				+ officetel + ", phone=" + phone + ", workDesc=" + workDesc + ", workStatus=" + workStatus
				+ ", loginable=" + loginable + ", ownSystem=" + ownSystem + ", descrption=" + descrption + ", type="
				+ type + ", sortValue=" + sortValue + ", createUser=" + createUser + ", createTime=" + createTime
				+ ", updateUser=" + updateUser + ", updateTime=" + updateTime + ", orgId=" + orgId + ", orgName="
				+ orgName + ", deptId=" + deptId + ", deptName=" + deptName + "]";
	}
}

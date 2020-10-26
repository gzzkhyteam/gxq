package com.hengyunsoft.sso.authentication;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable {

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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
     * 状态 1启用   2、冻结
     *
     * @mbggenerated
     */
    private Integer status;

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
     * 是否可登录
     *
     * @mbggenerated
     */
    private String loginable;

    /**
     * 工作状态：1,在职  2,离职
     *
     * @mbggenerated
     */
    private String workStatus;

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    private Integer sortValue;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getLoginable() {
		return loginable;
	}

	public void setLoginable(String loginable) {
		this.loginable = loginable;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public Integer getSortValue() {
		return sortValue;
	}

	public void setSortValue(Integer sortValue) {
		this.sortValue = sortValue;
	}
    
    
}

package com.hengyunsoft.platform.admin.entity.core.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class User extends BaseEntity<Long> implements Serializable {
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

    private static final long serialVersionUID = 1L;

    /**
     * ID
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 密码
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 姓名
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 生日
     *
     * @mbggenerated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @mbggenerated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 民族
     *
     * @mbggenerated
     */
    public String getNation() {
        return nation;
    }

    /**
     * 民族
     *
     * @mbggenerated
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 照片
     *
     * @mbggenerated
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 照片
     *
     * @mbggenerated
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    public String getOfficetel() {
        return officetel;
    }

    /**
     * 办公电话
     *
     * @mbggenerated
     */
    public void setOfficetel(String officetel) {
        this.officetel = officetel == null ? null : officetel.trim();
    }

    /**
     * 手机
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 工作描述：  市长、管理员、局长等等   用于登陆展示
     *
     * @mbggenerated
     */
    public String getWorkDesc() {
        return workDesc;
    }

    /**
     * 工作描述：  市长、管理员、局长等等   用于登陆展示
     *
     * @mbggenerated
     */
    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc == null ? null : workDesc.trim();
    }

    /**
     * 工作状态
     *
     * @mbggenerated
     */
    public String getWorkStatus() {
        return workStatus;
    }

    /**
     * 工作状态
     *
     * @mbggenerated
     */
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus == null ? null : workStatus.trim();
    }

    /**
     * 是否可登陆  1是 0否  [BooleanStatus]
     *
     * @mbggenerated
     */
    public Boolean getLoginable() {
        return loginable;
    }

    /**
     * 是否可登陆  1是 0否  [BooleanStatus]
     *
     * @mbggenerated
     */
    public void setLoginable(Boolean loginable) {
        this.loginable = loginable;
    }

    /**
     * 存在于哪些体系中，   用0表示不存在  1表示存在   最大支持63个体系
     *
     * @mbggenerated
     */
    public String getOwnSystem() {
        return ownSystem;
    }

    /**
     * 存在于哪些体系中，   用0表示不存在  1表示存在   最大支持63个体系
     *
     * @mbggenerated
     */
    public void setOwnSystem(String ownSystem) {
        this.ownSystem = ownSystem == null ? null : ownSystem.trim();
    }

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    public String getDescrption() {
        return descrption;
    }

    /**
     * 个人简介
     *
     * @mbggenerated
     */
    public void setDescrption(String descrption) {
        this.descrption = descrption == null ? null : descrption.trim();
    }

    /**
     * 用户类型   根据类型去关联更具体的用户信息   意思可以进行信息扩展
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 用户类型   根据类型去关联更具体的用户信息   意思可以进行信息扩展
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    public Integer getSortValue() {
        return sortValue;
    }

    /**
     * 排序权重值赿小靠前
     *
     * @mbggenerated
     */
    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
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
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人id
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
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
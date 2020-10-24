package com.hengyunsoft.platform.developer.entity.fast.po.attence;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class AttenceList extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    private Date signTime;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remark;

    /**
     * 签到图片Id，逗号分隔
     *
     * @mbggenerated
     */
    private String picture;

    /**
     * 抄送部门ID拼接字符串
     *
     * @mbggenerated
     */
    private String deptId;

    /**
     * 抄送人员 ID逗号分隔字符串
     *
     * @mbggenerated
     */
    private String empId;

    /**
     * 经度
     *
     * @mbggenerated
     */
    private Double latitude;

    /**
     * 纬度
     *
     * @mbggenerated
     */
    private Double longitude;

    /**
     * 地址
     *
     * @mbggenerated
     */
    private String address;

    /**
     * 是否自动签到（0：否，1:是）
     *
     * @mbggenerated
     */
    private Integer autoSign;

    /**
     * 签到用户ID
     *
     * @mbggenerated
     */
    private String userid;

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    private Integer signType;

    /**
     * 签到或早退小时
     *
     * @mbggenerated
     */
    private Float hours;

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    private Integer handleType;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

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
     * 签到时间
     *
     * @mbggenerated
     */
    public Date getSignTime() {
        return signTime;
    }

    /**
     * 签到时间
     *
     * @mbggenerated
     */
    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 签到图片Id，逗号分隔
     *
     * @mbggenerated
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 签到图片Id，逗号分隔
     *
     * @mbggenerated
     */
    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    /**
     * 抄送部门ID拼接字符串
     *
     * @mbggenerated
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 抄送部门ID拼接字符串
     *
     * @mbggenerated
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    /**
     * 抄送人员 ID逗号分隔字符串
     *
     * @mbggenerated
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * 抄送人员 ID逗号分隔字符串
     *
     * @mbggenerated
     */
    public void setEmpId(String empId) {
        this.empId = empId == null ? null : empId.trim();
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * 经度
     *
     * @mbggenerated
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * 纬度
     *
     * @mbggenerated
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * 地址
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 是否自动签到（0：否，1:是）
     *
     * @mbggenerated
     */
    public Integer getAutoSign() {
        return autoSign;
    }

    /**
     * 是否自动签到（0：否，1:是）
     *
     * @mbggenerated
     */
    public void setAutoSign(Integer autoSign) {
        this.autoSign = autoSign;
    }

    /**
     * 签到用户ID
     *
     * @mbggenerated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 签到用户ID
     *
     * @mbggenerated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    public Integer getSignType() {
        return signType;
    }

    /**
     * 0：签到，1： 签退
     *
     * @mbggenerated
     */
    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    /**
     * 签到或早退小时
     *
     * @mbggenerated
     */
    public Float getHours() {
        return hours;
    }

    /**
     * 签到或早退小时
     *
     * @mbggenerated
     */
    public void setHours(Float hours) {
        this.hours = hours;
    }

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    public Integer getHandleType() {
        return handleType;
    }

    /**
     * 操作类型（0:内勤，1:外勤）
     *
     * @mbggenerated
     */
    public void setHandleType(Integer handleType) {
        this.handleType = handleType;
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
package com.hengyunsoft.platform.mt.entity.apprwork.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ApprBusiness extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 申请Id
     *
     * @mbggenerated
     */
    private Long applyId;

    /**
     * 出差类型（从数据字典中获取name来存放）
     *
     * @mbggenerated
     */
    private String leaveType;

    /**
     * 出差省
     *
     * @mbggenerated
     */
    private String province;

    /**
     * 出差市
     *
     * @mbggenerated
     */
    private String city;

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    private String address;

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    private String vehicle;

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    private String entourage;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    private String entouragePhone;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    private Date startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    private Date endTime;

    /**
     * 出差 小时
     *
     * @mbggenerated
     */
    private Float businessHour;

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    private String businessReason;

    /**
     * 创建人
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
     * 更新人
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
     * 申请Id
     *
     * @mbggenerated
     */
    public Long getApplyId() {
        return applyId;
    }

    /**
     * 申请Id
     *
     * @mbggenerated
     */
    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    /**
     * 出差类型（从数据字典中获取name来存放）
     *
     * @mbggenerated
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * 出差类型（从数据字典中获取name来存放）
     *
     * @mbggenerated
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType == null ? null : leaveType.trim();
    }

    /**
     * 出差省
     *
     * @mbggenerated
     */
    public String getProvince() {
        return province;
    }

    /**
     * 出差省
     *
     * @mbggenerated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 出差市
     *
     * @mbggenerated
     */
    public String getCity() {
        return city;
    }

    /**
     * 出差市
     *
     * @mbggenerated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    public String getVehicle() {
        return vehicle;
    }

    /**
     * 交通工具
     *
     * @mbggenerated
     */
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    public String getEntourage() {
        return entourage;
    }

    /**
     * 随行人员
     *
     * @mbggenerated
     */
    public void setEntourage(String entourage) {
        this.entourage = entourage == null ? null : entourage.trim();
    }

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    public String getEntouragePhone() {
        return entouragePhone;
    }

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    public void setEntouragePhone(String entouragePhone) {
        this.entouragePhone = entouragePhone == null ? null : entouragePhone.trim();
    }

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 出差 小时
     *
     * @mbggenerated
     */
    public Float getBusinessHour() {
        return businessHour;
    }

    /**
     * 出差 小时
     *
     * @mbggenerated
     */
    public void setBusinessHour(Float businessHour) {
        this.businessHour = businessHour;
    }

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    public String getBusinessReason() {
        return businessReason;
    }

    /**
     * 出差事由
     *
     * @mbggenerated
     */
    public void setBusinessReason(String businessReason) {
        this.businessReason = businessReason == null ? null : businessReason.trim();
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
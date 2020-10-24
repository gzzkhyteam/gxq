package com.hengyunsoft.platform.hardware.entity.equipmentMonitor.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hengyunsoft.base.entity.BaseEntity;
import com.hengyunsoft.platform.hardware.entity.apply.po.ApplyDisk;

public class EquipmentMonitorDO extends BaseEntity<Long> implements Serializable {
	/**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 机房编号
     *
     * @mbggenerated
     */
    private String roomNumber;

    /**
     * 管理员
     *
     * @mbggenerated
     */
    private String roomAdmin;

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    private String contactNumber;

    /**
     * 主机数量
     *
     * @mbggenerated
     */
    private Integer hostNum;

    /**
     * 路由器数量
     *
     * @mbggenerated
     */
    private Integer routerNum;

    /**
     * 空调数量
     *
     * @mbggenerated
     */
    private Integer airConNum;

    /**
     * 机柜数量
     *
     * @mbggenerated
     */
    private Integer cabinetNum;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    private Integer isDelete;

    /**
     * 创建人
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
     * 修改人
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * 修改时间
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
     * 机房编号
     *
     * @mbggenerated
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * 机房编号
     *
     * @mbggenerated
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber == null ? null : roomNumber.trim();
    }

    /**
     * 管理员
     *
     * @mbggenerated
     */
    public String getRoomAdmin() {
        return roomAdmin;
    }

    /**
     * 管理员
     *
     * @mbggenerated
     */
    public void setRoomAdmin(String roomAdmin) {
        this.roomAdmin = roomAdmin == null ? null : roomAdmin.trim();
    }

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * 联系电话
     *
     * @mbggenerated
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    /**
     * 主机数量
     *
     * @mbggenerated
     */
    public Integer getHostNum() {
        return hostNum;
    }

    /**
     * 主机数量
     *
     * @mbggenerated
     */
    public void setHostNum(Integer hostNum) {
        this.hostNum = hostNum;
    }

    /**
     * 路由器数量
     *
     * @mbggenerated
     */
    public Integer getRouterNum() {
        return routerNum;
    }

    /**
     * 路由器数量
     *
     * @mbggenerated
     */
    public void setRouterNum(Integer routerNum) {
        this.routerNum = routerNum;
    }

    /**
     * 空调数量
     *
     * @mbggenerated
     */
    public Integer getAirConNum() {
        return airConNum;
    }

    /**
     * 空调数量
     *
     * @mbggenerated
     */
    public void setAirConNum(Integer airConNum) {
        this.airConNum = airConNum;
    }

    /**
     * 机柜数量
     *
     * @mbggenerated
     */
    public Integer getCabinetNum() {
        return cabinetNum;
    }

    /**
     * 机柜数量
     *
     * @mbggenerated
     */
    public void setCabinetNum(Integer cabinetNum) {
        this.cabinetNum = cabinetNum;
    }

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
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
     * 修改人
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
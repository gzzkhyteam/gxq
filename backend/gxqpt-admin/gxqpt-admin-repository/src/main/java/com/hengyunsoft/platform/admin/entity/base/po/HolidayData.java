package com.hengyunsoft.platform.admin.entity.base.po;

import com.hengyunsoft.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class HolidayData extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 编号(节假日元数据编码)
     *
     * @mbggenerated
     */
    private String number;

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 开始日期
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 结束日期
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * 年
     *
     * @mbggenerated
     */
    private String year;

    /**
     * 状态：1启用，禁用
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 类型（放假、调休加班）
     *
     * @mbggenerated
     */
    private String type;

    /**
     * 创建人
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
     * 修改时间
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
     * 编号(节假日元数据编码)
     *
     * @mbggenerated
     */
    public String getNumber() {
        return number;
    }

    /**
     * 编号(节假日元数据编码)
     *
     * @mbggenerated
     */
    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 开始日期
     *
     * @mbggenerated
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 开始日期
     *
     * @mbggenerated
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 结束日期
     *
     * @mbggenerated
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 结束日期
     *
     * @mbggenerated
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 年
     *
     * @mbggenerated
     */
    public String getYear() {
        return year;
    }

    /**
     * 年
     *
     * @mbggenerated
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     * 状态：1启用，禁用
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：1启用，禁用
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 类型（放假、调休加班）
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * 类型（放假、调休加班）
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建人
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
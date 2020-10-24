package com.hengyunsoft.platform.security.entity.interfaces.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class InterfaceAccessStat extends BaseEntity<Long> implements Serializable {
    /**
     * id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 接口ID
     *
     * @mbggenerated
     */
    private Long interfaceConfigId;

    /**
     * 统计时段（0 - 23点）
     *
     * @mbggenerated
     */
    private Integer statHour;

    /**
     * 统计日期
     *
     * @mbggenerated
     */
    private String statDate;

    /**
     * 时段内访问量
     *
     * @mbggenerated
     */
    private Integer statSum;

    /**
     * 统计时间
     *
     * @mbggenerated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 接口ID
     *
     * @mbggenerated
     */
    public Long getInterfaceConfigId() {
        return interfaceConfigId;
    }

    /**
     * 接口ID
     *
     * @mbggenerated
     */
    public void setInterfaceConfigId(Long interfaceConfigId) {
        this.interfaceConfigId = interfaceConfigId;
    }

    /**
     * 统计时段（0 - 23点）
     *
     * @mbggenerated
     */
    public Integer getStatHour() {
        return statHour;
    }

    /**
     * 统计时段（0 - 23点）
     *
     * @mbggenerated
     */
    public void setStatHour(Integer  statHour) {
        this.statHour = statHour;
    }

    /**
     * 统计日期
     *
     * @mbggenerated
     */
    public String getStatDate() {
        return statDate;
    }

    /**
     * 统计日期
     *
     * @mbggenerated
     */
    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    /**
     * 时段内访问量
     *
     * @mbggenerated
     */
    public Integer getStatSum() {
        return statSum;
    }

    /**
     * 时段内访问量
     *
     * @mbggenerated
     */
    public void setStatSum(Integer statSum) {
        this.statSum = statSum;
    }

    /**
     * 统计时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 统计时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
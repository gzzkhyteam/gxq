package com.hengyunsoft.platform.hardware.entity.apply.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class ServerStatistics extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * server的主键
     *
     * @mbggenerated
     */
    private Long serverId;

    /**
     * 生成时间
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * cpu使用率
     *
     * @mbggenerated
     */
    private Byte cpu;

    /**
     * 内存使用率
     *
     * @mbggenerated
     */
    private Byte mem;

    /**
     * 磁盘使用率
     *
     * @mbggenerated
     */
    private Byte disk;

    /**
     * 上行流量
     *
     * @mbggenerated
     */
    private Double wideUp;

    /**
     * 下行流量
     *
     * @mbggenerated
     */
    private Double wideDown;

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
     * server的主键
     *
     * @mbggenerated
     */
    public Long getServerId() {
        return serverId;
    }

    /**
     * server的主键
     *
     * @mbggenerated
     */
    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    /**
     * 生成时间
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * 生成时间
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * cpu使用率
     *
     * @mbggenerated
     */
    public Byte getCpu() {
        return cpu;
    }

    /**
     * cpu使用率
     *
     * @mbggenerated
     */
    public void setCpu(Byte cpu) {
        this.cpu = cpu;
    }

    /**
     * 内存使用率
     *
     * @mbggenerated
     */
    public Byte getMem() {
        return mem;
    }

    /**
     * 内存使用率
     *
     * @mbggenerated
     */
    public void setMem(Byte mem) {
        this.mem = mem;
    }

    /**
     * 磁盘使用率
     *
     * @mbggenerated
     */
    public Byte getDisk() {
        return disk;
    }

    /**
     * 磁盘使用率
     *
     * @mbggenerated
     */
    public void setDisk(Byte disk) {
        this.disk = disk;
    }

    /**
     * 上行流量
     *
     * @mbggenerated
     */
    public Double getWideUp() {
        return wideUp;
    }

    /**
     * 上行流量
     *
     * @mbggenerated
     */
    public void setWideUp(Double wideUp) {
        this.wideUp = wideUp;
    }

    /**
     * 下行流量
     *
     * @mbggenerated
     */
    public Double getWideDown() {
        return wideDown;
    }

    /**
     * 下行流量
     *
     * @mbggenerated
     */
    public void setWideDown(Double wideDown) {
        this.wideDown = wideDown;
    }
}
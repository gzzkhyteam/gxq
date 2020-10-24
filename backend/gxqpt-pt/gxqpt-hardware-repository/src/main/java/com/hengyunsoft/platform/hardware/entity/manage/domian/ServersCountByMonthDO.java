package com.hengyunsoft.platform.hardware.entity.manage.domian;


import lombok.Data;

@Data
public class ServersCountByMonthDO {

    /**
     * 服务器数量
     */
    private int serverCount;

    /**
     * cpu数量
     */
    private int cpuCount;

    /**
     * 内存大小
     */
    private int memorySize;

    /**
     * 磁盘大小
     */
    private long diskSize;

    /**
     * 月份
     */
    private String mon;
}

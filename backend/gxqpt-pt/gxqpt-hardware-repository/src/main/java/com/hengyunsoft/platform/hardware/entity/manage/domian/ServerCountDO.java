package com.hengyunsoft.platform.hardware.entity.manage.domian;

public class ServerCountDO {
    /**
     * cpu数量
     */
    private int cpuCount;

    /**
     * 内存数量
     */
    private int memorySize;

    /**
     * 磁盘数量
     */
    private Long diskSize;

    public int getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(int cpuCount) {
        this.cpuCount = cpuCount;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public Long getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(Long diskSize) {
        this.diskSize = diskSize;
    }
}

package com.hengyunsoft.platform.hardware.entity.manage.domian;

import lombok.Data;

@Data
public class PanelOrgMonthCpuDO {
    /**
     * cpu数量
     */
    private int cpuCount;

    /**
     * 部门名称
     */
    private String orgname;

    /**
     * 部门id
     */
    private String orgid;

    /**
     * 月份
     */
    private String mon;

    /**
     * 序号，月份数2018-09 那么该值为09
     */
    private String num;
}

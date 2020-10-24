package com.hengyunsoft.platform.hardware.entity.manage.domian;

import lombok.Data;

@Data
public class PanelOrgCpuCountDO {
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
}

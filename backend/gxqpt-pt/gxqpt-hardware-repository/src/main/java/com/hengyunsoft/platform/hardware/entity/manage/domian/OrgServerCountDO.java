package com.hengyunsoft.platform.hardware.entity.manage.domian;

import lombok.Data;

/**
 * 查询各单位服务器数量统计
 */
@Data
public class OrgServerCountDO {
    /**
     * 单位id
     */
    private String orgId;

    /**
     * 单位名称
     */
    private String orgName;

    /**
     * 服务器数量
     */
    private int serverCount;
}

package com.hengyunsoft.platform.hardware.dto.apply;

import lombok.Data;

import java.util.Date;
@Data
public class StatisticsDiskTransDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 服务器管理表主键
     *
     * @mbggenerated
     */
    private Long serverId;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    private int diskSize;


    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;
    
    /**
     * 管理单位id
     *
     * @mbggenerated
     */
    private String orgid;

    /**
     * 管理单位名称
     *
     * @mbggenerated
     */
    private String orgname;

}

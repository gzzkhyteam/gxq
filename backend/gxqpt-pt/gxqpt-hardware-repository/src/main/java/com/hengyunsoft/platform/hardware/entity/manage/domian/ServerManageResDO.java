package com.hengyunsoft.platform.hardware.entity.manage.domian;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ServerManageResDO implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 服务器id
     *
     * @mbggenerated
     */
    private String serverId;

    /**
     * 服务器ip
     *
     * @mbggenerated
     */
    private String ip;

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

    /**
     * 管理员id
     *
     * @mbggenerated
     */
    private String manageUid;

    /**
     * 管理员名称
     *
     * @mbggenerated
     */
    private String manageUname;

    /**
     * cpu核数
     *
     * @mbggenerated
     */
    private Integer cpuCount;

    /**
     * 内存大小
     *
     * @mbggenerated
     */
    private Integer memorySize;

    /**
     * 所属网络
     *
     * @mbggenerated
     */
    private String netScope;

    /**
     * 所属网络
     *
     * @mbggenerated
     */
    private String netScopeName;

    /**
     * 网络带宽
     *
     * @mbggenerated
     */
    private Integer netWide;

    /**
     * 磁盘大小
     *
     * @mbggenerated
     */
    private Integer diskSize;


    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;


    /**
     * cpu使用占比
     *
     * @mbggenerated
     */
    private Byte cpuPercent;

    /**
     * 内存使用占比
     *
     * @mbggenerated
     */
    private Byte memoryPercent;

    /**
     * 磁盘使用占比
     *
     * @mbggenerated
     */
    private Byte diskPercent;

    /**
     * 网络上行带宽
     *
     * @mbggenerated
     */
    private Double wideUp;

    /**
     * 网络下行带宽
     *
     * @mbggenerated
     */
    private Double wideDown;

    /**
     * 管理单位id
     *
     * @mbggenerated
     */
    private List<String> orgids;


    private static final long serialVersionUID = 1L;

}

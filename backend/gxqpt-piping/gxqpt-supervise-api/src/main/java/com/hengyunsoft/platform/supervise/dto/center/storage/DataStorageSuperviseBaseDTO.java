package com.hengyunsoft.platform.supervise.dto.center.storage;

import java.util.Date;

public class DataStorageSuperviseBaseDTO {
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用/服务类型： 1 应用   2服务   3既是应用也是服务
     *
     * @mbggenerated
     */
    private Short appType;

    /**
     * 数据库空间数量
     *
     * @mbggenerated
     */
    private Double dbSpaceNum;

    /**
     * 日志空间数量
     *
     * @mbggenerated
     */
    private Double logSpaceNum;

    /**
     * 文件空间数量
     *
     * @mbggenerated
     */
    private Double fileSpaceNum;

    /**
     * 数据库空间阀值
     *
     * @mbggenerated
     */
    private Double dbSpaceLimit;

    /**
     * 日志空间阀值
     *
     * @mbggenerated
     */
    private Double logSpaceLimit;

    /**
     * 文件空间阀值
     *
     * @mbggenerated
     */
    private Double fileSpaceLimit;

    /**
     * 文件空间地址
     *
     * @mbggenerated
     */
    private String fileSpaceUrl;

    /**
     * 日志空间地址
     *
     * @mbggenerated
     */
    private String logSpaceUrl;

    /**
     * 数据库空间地址
     *
     * @mbggenerated
     */
    private String dbSpaceUrl;

    /**
     * 责任人:单个
     *
     * @mbggenerated
     */
    private String dutyUser;

    /**
     * 确认人:多个,逗号隔开
     *
     * @mbggenerated
     */
    private String confirmUser;

    /**
     * 抄送人:多个,逗号隔开
     *
     * @mbggenerated
     */
    private String copyUser;

    /**
     * 执行定时时间
     *
     * @mbggenerated
     */
    private Date scheduledTime;

    /**
     * 监管类型
     *
     * @mbggenerated
     */
    private Short superviseType;

    /**
     * 提醒方式 消息:1,短信:2
     *
     * @mbggenerated
     */
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    private Boolean runStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;
}

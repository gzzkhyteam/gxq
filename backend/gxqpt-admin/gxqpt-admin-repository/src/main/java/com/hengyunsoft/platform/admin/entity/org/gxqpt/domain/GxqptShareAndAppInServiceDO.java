package com.hengyunsoft.platform.admin.entity.org.gxqpt.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GxqptShareAndAppInServiceDO implements Serializable{
    private Long id;

    /**
     * 将用户、部门、单位共享给应用
     *
     * @mbggenerated
     */
    private String bizType;

    private String bizId;

    private String appId;

    /**
     * 创建人id
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
     * app名称
     *
     * @mbggenerated
     */
    private String appName;

    private static final long serialVersionUID = 1L;
}

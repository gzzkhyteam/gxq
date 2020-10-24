package com.hengyunsoft.platform.security.entity.interfaces.domain;


import java.util.Date;

import lombok.Data;

/**
 *
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/16
 */
@Data
public class ServiceResource {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 功能模块id
     *
     * @mbggenerated
     */
    private Long moduleId;

    /**
     * 资源名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 功能描述
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 资源编码
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 路径
     *
     * @mbggenerated
     */
    private String url;

    /**
     * get/post/all
     *
     * @mbggenerated
     */
    private String httpMethod;

    /**
     * 状态： 1启用   2禁用
     *
     * @mbggenerated
     */
    private Short status;

    /**
     * 序号
     *
     * @mbggenerated
     */
    private Integer orderNo;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
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
     * 更新人id
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

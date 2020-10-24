package com.hengyunsoft.platform.developer.entity.service.po.domain;

import lombok.Data;

import java.util.Date;

/**
 * 模块功能申请
 * @author sxy
 * @date 2019-02-15
 */
@Data
public class ServiceAssignModuleDO {

    private Long id;

    /**
     * 是否公有资源
     *
     * @mbggenerated
     */
    private Boolean publicIs;

    /**
     * 功能id
     *
     * @mbggenerated
     */
    private Long moduleId;

    /**
     * 所属应用appid
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 所属应用名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 状态： 1启用   0禁用
     *
     * @mbggenerated
     */
    private Boolean status;

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

    /**
     * 禁用备注
     *
     * @mbggenerated
     */
    private String disableDesc;

    private static final long serialVersionUID = 1L;
}

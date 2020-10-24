package com.hengyunsoft.platform.piping.api.msgs.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 预警责任信息对象
 * @author zjr
 */
@Data
@ApiModel(value = "Duty", description = "预警责任信息对象")
public class DutyDTO implements Serializable {
    /**
     * 业务id
     *
     * @mbggenerated
     */
    private String bizId;

    /**
     * 业务类型  （包括：人员、部门、单位、应用、系统等）
     *
     * @mbggenerated
     */
    private String bizType;

    /**
     * 名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 应用/服务分类（共性应用、统一平台、共性服务、共性模块等等）
     *
     * @mbggenerated
     */
    private String appType;

    /**
     * 人员id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 人员姓名
     *
     * @mbggenerated
     */
    private String empName;

    /**
     * 人员所属部门
     *
     * @mbggenerated
     */
    private String departmentId;

    /**
     * 人员所在部门名称
     *
     * @mbggenerated
     */
    private String departmentName;

    /**
     * 部门所属单位
     *
     * @mbggenerated
     */
    private String orgId;

    /**
     * 部门所在单位名称
     *
     * @mbggenerated
     */
    private String orgName;


    private static final long serialVersionUID = 1L;

}

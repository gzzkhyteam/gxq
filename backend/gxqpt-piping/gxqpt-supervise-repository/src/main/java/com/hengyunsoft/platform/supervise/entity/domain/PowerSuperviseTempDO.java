package com.hengyunsoft.platform.supervise.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.hengyunsoft.validator.annotation.FieldDesc;

/**
 * 权责监管临时数据保存DO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseTempDO",description = "权责监管临时数据保存DO")
public class PowerSuperviseTempDO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;

    /**
     * tempId
     */
    @ApiModelProperty(value = "tempId")
    private Long tempId;

    /**
     * 环节编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节编码")
    private String tempCode;

    /**
     * 环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节名称")
    private String tempName;

    /**
     * 环节描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节描述")
    private String tempDesc;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;




    /**
     * linkId
     */
    @ApiModelProperty(value = "linkId")
    private Long linkId;

    /**
     * 主配置ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主配置ID")
    private Long powerSuperviseId;

    /**
     * 环节编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节编码")
    private String linkCode;

    /**
     * 环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节名称")
    private String linkName;

    /**
     * 时长限制
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "时长限制")
    private Double timeLimit;

    /**
     * 责任人:单个
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "责任人:单个")
    private String dutyUser;

    /**
     * 确认人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "确认人:多个,逗号隔开")
    private String confirmUser;

    /**
     * 抄送人:多个,逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "抄送人:多个,逗号隔开")
    private String copyUser;

    /**
     * 提醒方式 消息:1,短信:2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提醒方式 消息:1,短信:2")
    private Short remindType;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String linkDesc;

    /**
     * 系统ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统ID")
    private String systemId;
    
    /**
     * 系统名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "系统名称")
    private String systemName;
}

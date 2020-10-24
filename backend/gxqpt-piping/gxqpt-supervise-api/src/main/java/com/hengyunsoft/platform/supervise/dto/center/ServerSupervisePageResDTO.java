package com.hengyunsoft.platform.supervise.dto.center;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务监管分页查询响应DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "ServerSuperviseSaveDTO",description = "服务监管分页查询响应DTO")
public class ServerSupervisePageResDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 应用ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用ID")
    private String appId;

    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String appName;

    /**
     * 上限阀值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上限阀值")
    private Integer limit;

    /**
     * 阀值周期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "阀值周期")
    private Integer limitCycle;

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
     * 责任人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "责任人:单个")
    private String dutyUserName;

    /**
     * 确认人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "确认人:多个,逗号隔开")
    private String confirmUserName;

    /**
     * 抄送人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "抄送人:多个,逗号隔开")
    private String copyUserName;

    /**
     * 定时时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "定时时间")
    private Date scheduledTime;

    /**
     * 提醒方式 消息:1,短信:2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "提醒方式 消息:1,短信:2")
    private Short remindType;

    /**
     * 运行状态 启用:true 禁用:false
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "运行状态 启用:true 禁用:false")
    private Boolean runStatus;

    /**
     * 备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "备注")
    private String desc;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称：全部传空即可")
    private Long createUser;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新人")
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "级别")
    private Integer level;
}

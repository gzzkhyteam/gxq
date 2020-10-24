package com.hengyunsoft.platform.supervise.dto.center;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 权责环节监管分页查询响应DTO
 * @author sxy
 * @date 2018-09-12
 */
@Data
@ApiModel(value = "PowerSuperviseLinkPageResDTO",description = "权责环节监管分页查询响应DTO")
public class PowerSuperviseLinkPageResDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 主配置ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主配置ID")
    private Long powerSuperviseId;

    /**
     * 排序编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "排序编号")
    private Integer sortNum;

    /**
     * 环节编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节编码")
    private String code;

    /**
     * 环节名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环节名称")
    private String name;

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
    private String desc;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
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

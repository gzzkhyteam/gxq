package com.hengyunsoft.platform.msgs.dto.msg;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class OfficeDTO implements Serializable {
	/**
     * 主键id
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 是否已读0未读 1已读
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "是否已读0=未读，1=已读")
    private Integer readed;

    /**
     * 原字号
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "原字号")
    private String task;

    /**
     * 主题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息主题")
    private String topic;

    /**
     * 紧急程度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "紧急程度")
    private Integer urgent;

    /**
     * 发布时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布时间")
    private Date sendTime;

    /**
     * 任务发生地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务发生地址")
    private String taskUrl;

    /**
     * 创建人id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人id")
    private Long createUserId;

    /**
     * 任务创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务创建人")
    private String createUser;

    /**
     * 任务创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务创建时间")
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "任务更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
    /**
     * 发布时间
     *
     * @mbggenerated
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getSendTime() {
        return sendTime;
    }
    /**
     * 任务创建时间
     *
     * @mbggenerated
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }
}
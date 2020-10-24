package com.hengyunsoft.platform.msgs.dto.msg;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class BacklogDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 主键id
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 任务事项
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务事项")
    private String task;

    /**
     * 是否已读
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "是否已读0=未读，1=已读")
    private Integer readed;

    /**
     * 任务来源
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务来源")
    private String taskSource;

    /**
     * 任务数量
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务数量")
    private Integer taskNum;

    /**
     * 任务环节
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务环节")
    private String taskLink;

    /**
     * 任务发生地址
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务发生地址")
    private String taskUrl;
    /**
     * 任务创建人id
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务创建人id")
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
     * 任务更新时间
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务更新时间")
    private Date updateTime;
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
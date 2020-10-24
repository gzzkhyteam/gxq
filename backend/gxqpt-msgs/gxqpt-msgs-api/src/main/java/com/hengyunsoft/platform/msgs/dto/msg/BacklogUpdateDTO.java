package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class BacklogUpdateDTO {
	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	private Long id;
	/**
     * 任务事项
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务事项")
    private String task;  

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
     * 任务创建人
     *
     * @mbggenerated
     */
	@ApiModelProperty(value = "任务创建人")
    private String createUser;
}

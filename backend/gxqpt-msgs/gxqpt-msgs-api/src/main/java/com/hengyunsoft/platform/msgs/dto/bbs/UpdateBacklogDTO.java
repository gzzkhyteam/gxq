package com.hengyunsoft.platform.msgs.dto.bbs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新待办DTO
 */
@Data
@ApiModel(value = "UpdateBacklogDTO", description = "更新待办DTO")
public class UpdateBacklogDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 消息id
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "消息id")
	private Long msgId;

	/**
	 * 接收人id
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "接收人id")
	private Long receiveId;

}
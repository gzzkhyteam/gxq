package com.hengyunsoft.platform.msgs.dto.bbs;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 更新待办DTO
 */
@Data
@ApiModel(value = "UpdateBacklogReqDTO", description = "更新待办DTO")
public class UpdateBacklogReqDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 接收人id
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "接收人id:如果传空，将所有人信息标记已读，并处理状态,不为空，即指定更新接收人对应消息处理状态")
	private Long receiveId;

	/**
	 * 业务类型
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业务类型")
	private String bizType;

	/**
	 * 客户端对此消息的唯一标示,   若客户端对此消息进行了存储，这里推荐是那里的存储id
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "客户端标识")
	private String clientFlag;

	/**
	 * 应用id
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "应用id")
	private String appId;

	/**
	 * 业务ID
	 *
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "业务ID")
	private String bizId;

}
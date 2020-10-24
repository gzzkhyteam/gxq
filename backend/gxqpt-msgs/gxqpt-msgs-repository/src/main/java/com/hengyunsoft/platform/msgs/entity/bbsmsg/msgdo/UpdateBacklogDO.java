package com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新待办DTO
 */
@Data
public class UpdateBacklogDO implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 消息id
	 *
	 * @mbggenerated
	 */
	private Long msgId;

	/**
	 * 接收人id
	 *
	 * @mbggenerated
	 */
	private Long receiveId;

}
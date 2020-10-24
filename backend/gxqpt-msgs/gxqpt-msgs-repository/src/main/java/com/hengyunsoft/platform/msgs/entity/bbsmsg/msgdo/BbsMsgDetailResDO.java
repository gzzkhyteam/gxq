package com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo;

import lombok.Data;

import java.io.Serializable;

/**
 * 站内消息详情返回DTO
 */
@Data
public class BbsMsgDetailResDO implements Serializable {

	/**
	 * 主键id
	 *
	 * @mbggenerated
	 */
	private Long id;

	/**
	 * 业务id
	 *
	 * @mbggenerated
	 */
	private String bizId;

	/**
	 * 业务类型
	 *
	 * @mbggenerated
	 */
	private String bizType;

	/**
	 * 客户端对此消息的唯一标示,   若客户端对此消息进行了存储，这里推荐是那里的存储id
	 *
	 * @mbggenerated
	 */
	private String clientFlag;

	/**
	 * 简要类型，粗粒度的类型
	 *
	 * @mbggenerated
	 */
	private String briefTpye;

	/**
	 * 详细类型
	 *
	 * @mbggenerated
	 */
	private String detailedType;

	/**
	 * 详细类型描述
	 *
	 * @mbggenerated
	 */
	private String detailedTypeDesc;

	/**
	 * 标题
	 *
	 * @mbggenerated
	 */
	private String title;

	/**
	 * 内容
	 *
	 * @mbggenerated
	 */
	private String content;

	/**
	 * 作者名称
	 *
	 * @mbggenerated
	 */
	private String senderName;

	/**
	 * 处理地址
	 *
	 * @mbggenerated
	 */
	private String handlerUrl;

	/**
	 * 处理参数
	 *
	 * @mbggenerated
	 */
	private String handlerParams;

	/**
	 * 是否单人处理
	 *
	 * @mbggenerated
	 */
	private Boolean singleHandleIs;

	/**
	 * 是否需要操作
	 *
	 * @mbggenerated
	 */
	private Boolean handlerNeedIs;

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
	 * 已读数量
	 *
	 * @mbggenerated
	 */
	private int readedNum;

	/**
	 * 未读数量
	 *
	 * @mbggenerated
	 */
	private int notReadNum;
}
package com.hengyunsoft.platform.msgs.entity.bbsmsg.msgdo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BbsNotReadMsgResDO implements Serializable {
	private static final long serialVersionUID = 1L;

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
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;


    /**
     * 接收主键id
     *
     * @mbggenerated
     */
    private Long recId;

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

    /**
     * 是否已读
     *
     * @mbggenerated
     */
    private Boolean readIs;

    /**
     * 接收是否需要处理
     *
     * @mbggenerated
     */
    private Boolean recHanderNeedIs;

    /**
     * 接收创建时间
     *
     * @mbggenerated
     */
    private Date recCreateTime;

    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;

    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;
}
package com.hengyunsoft.platform.sms.entity.template.dos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SmsRecordDO implements Serializable {
    /**
     * 短信记录id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 发布信息的id
     *
     * @mbggenerated
     */
    private String msgId;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 模块id
     *
     * @mbggenerated
     */
    private Long moduleId;

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    private String appName;

    /**
     * 发送者id
     *
     * @mbggenerated
     */
    private String sender;

    /**
     * 发送者名称
     *
     * @mbggenerated
     */
    private String senderName;

    /**
     * 接收者手机号
     *
     * @mbggenerated
     */
    private String receiver;

    /**
     * 短信主题
     *
     * @mbggenerated
     */
    private String topic;

    /**
     * 发送渠道id
     *
     * @mbggenerated
     */
    private String channelId;

    /**
     * 是否为草稿,1表示是草稿，0表示不是
     *
     * @mbggenerated
     */
    private Integer draft;

    /**
     * 来源类型
     *
     * @mbggenerated
     */
    private String sourceType;

    /**
     * 短信模板id
     *
     * @mbggenerated
     */
    private Long templateId;

    /**
     * 短信模板参数
     *
     * @mbggenerated
     */
    private String templateParams;

    /**
     * 短信发送时间
     *
     * @mbggenerated
     */
    private Date sendTime;

    /**
     * 是否删除
     *
     * @mbggenerated
     */
    private Boolean deleteIs;

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    private String startTime;

    /**
     * 发送结束时间
     *
     * @mbggenerated
     */
    private String endTime;

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    private String context;

    /**
     * 短信记录创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 短信记录更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    //发送状态 1-发送成功 2-发送失败
    private Integer sendStatus;

    /**
     * 渠道名称
     *
     * @mbggenerated
     */
    private String channelName;

    //------------- 手动新增字段，请写在此后面 -------------
    private static final long serialVersionUID = 1L;
}
package com.hengyunsoft.platform.sms.dto;

import com.hengyunsoft.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "SmsRecordPageResDTO", description = "获取短信记录分页返回列表")
public class SmsRecordPageResDTO extends BaseEntity<Long> implements Serializable {
    /**
     * 短信记录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信记录id")
    private Long id;

    /**
     * 发布信息的id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布信息的id")
    private String msgId;

    /**
     * 应用程序id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序id")
    private String appId;

    /**
     * 应用程序名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序名称")
    private String appName;

    /**
     * 发送者id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送者id")
    private String sender;

    /**
     * 发送者名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送者名称")
    private String senderName;

    /**
     * 接收者手机号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收者手机号")
    private String receiver;

    /**
     * 短信主题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信主题")
    private String topic;

    /**
     * 发送渠道id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送渠道id")
    private String channelId;

    /**
     * 是否为草稿,1表示是草稿，0表示不是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否为草稿,1表示是草稿，0表示不是")
    private Integer draft;

    /**
     * 来源类型APP应用，MODULAR模块，SERVICE服务
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "来源类型APP应用，MODULAR模块，SERVICE服务")
    private String sourceType;

    /**
     * 短信模板id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信模板id")
    private Long templateId;

    /**
     * 短信模板参数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信记录id")
    private String templateParams;

    /**
     * 短信发送时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信发送时间")
    private Date sendTime;

    /**
     * 发送开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送开始时间")
    private String startTime;

    /**
     * 发送结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送结束时间")
    private String endTime;

    /**
     * 发送内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送内容")
    private String context;

    /**
     * 短信记录创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信记录创建时间")
    private Date createTime;

    /**
     * 短信记录更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "短信记录更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}
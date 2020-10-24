package com.hengyunsoft.platform.msgs.dto.msg;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MsgsMessageBaseDTO {

    /**
     * 渠道类型1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道类型1")
    private Long channelType1;

    public Long getChannelType1() {
        return channelType1;
    }

    /**

     * 渠道1
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道1")
    private String channel1;

    /**
     * 渠道类型2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道类型2")
    private Long channelType2;

    /**
     * 渠道2
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道2")
    private String channel2;

    /**
     * 渠道类型3
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道类型3")
    private Long channelType3;

    /**
     * 渠道3
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道3")
    private String channel3;

    /**
     * 渠道类型4
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道类型4")
    private Long channelType4;

    /**
     * 渠道4
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道4")
    private String channel4;

    /**
     * 渠道类型5
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道类型5")
    private Long channelType5;

    /**
     * 渠道5
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "渠道5")
    private String channel5;

    /**
     * 常用联系人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "常用联系人")
    private String contactPerson;

    /**
     * 消息状态
     *发送状态：0=发送；1=存草稿；
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息状态")
    private Long msgStatus;

    /**
     * 消息文本内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息文本内容")
    private String msgTxt;

    /**
     * 消息类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "消息类型")
    private Long msgType;

    /**
     * 多媒体id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "多媒体id")
    private String mediaId;

    /**
     * 多媒体url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "多媒体url")
    private String mediaUrl;

    /**
     * 附件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件id")
    private String attachmentId;

    /**
     * 附件url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件url")
    private String attachmentUrl;

    /**
     * 超文本
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "超文本")
    private String htmlEditid;

    /**
     * 定时发送时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "定时发送时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendJobTime;
    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel1Id;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel2Id;
    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel3Id;

    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel4Id;
    /**
     * 渠道id（,分割）
     *
     * @mbggenerated
     */
    private String channel5Id;

}

package com.hengyunsoft.platform.mail.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@Data
@ApiModel(value = "SendMailInfo", description = "发送邮件的基本信息")
public class SendMailInfoDTO {

    /**
     * 发件人
     */
    @ApiModelProperty(value = "发件人邮箱 eg: admin@ljg.com eg: 名称 <tyh@ljg.com> ")
    private String from;
    /**
     * 收件人
     */
    @ApiModelProperty(value = "收件人 eg: admin@ljg.com ")
    private String to;
    /**
     * 抄送人
     */
    @ApiModelProperty(value = "抄送人 eg: admin@ljg.com ")
    private String cc;
    /**
     * 密送人
     */
    @ApiModelProperty(value = "密送人 eg: admin@ljg.com ")
    private String bcc;
    /**
     * 主题
     */
    @ApiModelProperty(value = "主题")
    private String subject;
    /**
     * 内容
     */
    @ApiModelProperty(value = "内容 支持富文本")
    private String content;
    /**
     * 附件地址
     */
    @ApiModelProperty(value = "附件")
    private List<AttachmentDTO> attachment;
    /**
     * 保存到已发送
     */
    @ApiModelProperty(value = "保存到已发送", example = "true,false")
    private Boolean sended = false;
    /**
     * 紧急邮件
     */
    @ApiModelProperty(value = "紧急邮件", example = "true,false")
    private Boolean exigence = false;
    /**
     * 纯文本
     */
    @ApiModelProperty(value = "纯文本", example = "true,false")
    private Boolean text = false;
    /**
     * 定时发送
     */
    @ApiModelProperty(value = "定时发送", example = "true,false")
    private Boolean time = false;

    /**是否回执*/
    @ApiModelProperty(value = "是否回执")
    private Integer isReplySign;

    @ApiModelProperty(value = "是否回复与回复全部")
    private Boolean isReplyAll = true;

    /**
     * 发件时间（接收时间）
     */
    @ApiModelProperty(value = "发件时间（接收时间）")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date = new Date();
}

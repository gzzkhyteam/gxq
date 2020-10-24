package com.hengyunsoft.platform.mail.dto.open;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 邮件审核规则
 *
 * @auth wt
 * @date 2018/08/27
 */
@Data
@ApiModel(value = "RequestExamine", description = "邮件审核规则")
public class RequestExamineDTO {

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID(保存时非必填，修改时必填)")
    private Long id;

    /**
     * 来源IP
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "来源IP")
    private String sourceIp;

    /**
     * 收件人IP
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收件人IP")
    private String ccIp;

    /**
     * 发件人所属部门
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发件人所属部门")
    private String formDept;

    /**
     * 收件人所属部门
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收件人所属部门")
    private String ccDept;

    /**
     * 发件人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发件人")
    private String mailFrom;

    /**
     * 收件人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "收件人")
    private String mailCc;

    /**
     * 主题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题")
    private String subject;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 附件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件名")
    private String attachmentName;

    /**
     * 邮件长度
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件长度")
    private String mailLength;

    /**
     * 邮件头字段
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件头字段")
    private String mailHead;

    /**
     * 邮件发送时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件发送时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date sendTime;

    /**
     * 邮件接收时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮件接收时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date receiveTime;

    /**
     * 是否包含附件
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否包含附件")
    private String isAttachment;

    /**
     * 邮箱用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "邮箱用户名")
    private String userName;
}

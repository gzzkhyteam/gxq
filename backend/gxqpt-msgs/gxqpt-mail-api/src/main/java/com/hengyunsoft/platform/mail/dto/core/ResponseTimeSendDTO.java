package com.hengyunsoft.platform.mail.dto.core;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 定时发送邮件
 *
 * @auth wt
 * @date 2018/08/24
 */
@Data
@ApiModel(value = "ResponseTimeSend", description = "定时发送邮件请求")
public class ResponseTimeSendDTO {

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID(保存时非必填，修改时必填)")
    private Long id;

    /**
     * 用户
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户")
    private String mailName;

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
    private String mailTo;

    /**
     * 抄送人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "抄送人")
    private String mailCc;

    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String subject;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 是否回执
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否回执")
    private Integer isReplySign;

    /**
     * 定时发送日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "定时发送日期")
    private Date sendTime;

    /**
     * 附件集合
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "附件集合")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private List<RequestTimeAttDTO> attachement;

}

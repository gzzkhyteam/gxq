package com.hengyunsoft.platform.mail.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/25
 */
@Data
@ApiModel(value = "MarkMail", description = "标记邮件")
public class MarkMailDTO {

    @ApiModelProperty(value = "邮件夹的类型 INBOX:收件夹, SENDED:已发送, DRAFT:草稿箱, DELETE:已删除 SPAM:垃圾邮件夹 ABNORMAL: 异常邮件  VIRUSES:病毒邮件  xxxx:自定义文件夹")
    private String folderType;
    @ApiModelProperty(value = "邮件id， 多个id 英文,号分割")
    private String mailId;

    @ApiModelProperty(value = "类型 已读:true, 未读:false", example = "true")
    private Boolean isRead = true;

}

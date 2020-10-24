package com.hengyunsoft.platform.mail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 类说明：搜索邮件DTO
 *
 * @author 作者: tangyh
 * @version 创建时间：2018-07-25
 */
@Data
@ApiModel(value = "SearchMail", description = "搜索邮件")
public class SearchMailDTO {
    @ApiModelProperty(value = "搜索关键字")
    private String keyword = null;// 搜索关键字

    @ApiModelProperty(value = "邮件夹的类型 INBOX:收件夹, SENDED:已发送, DRAFT:草稿箱, DELETE:已删除 SPAM:垃圾邮件夹 ABNORMAL: 异常邮件  VIRUSES:病毒邮件 TRASH:异常邮件  xxxx:自定义文件夹")
    private String folderType ;// 要搜索的邮件夹类型

}

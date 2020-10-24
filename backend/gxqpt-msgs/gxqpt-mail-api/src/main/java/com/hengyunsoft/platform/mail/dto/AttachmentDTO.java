package com.hengyunsoft.platform.mail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 邮件附件
 *
 * @auth tangyh
 * @date 2018/07/27
 */
@Data
@ApiModel(value = "Atta", description = "邮件附件")
public class AttachmentDTO {
    @ApiModelProperty(value = "url")
    private String url;
    @ApiModelProperty(value = "文件原始名")
    private String fileName;
}

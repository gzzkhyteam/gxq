package com.hengyunsoft.platform.mail.dto.open;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Attachment", description = "附件")
public class Attachment {
    @ApiModelProperty(value = "url")
    private String url;
    @ApiModelProperty(value = "文件原始名")
    private String fileName;
}

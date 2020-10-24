package com.hengyunsoft.platform.mail.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 定时发送附件
 *
 * @auth wt
 * @date 2018/08/24
 */
@Data
@ApiModel(value = "RequestTimeAtt", description = "定时发送附件请求")
public class RequestTimeAttDTO {

    /**
     * 主键ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键ID(保存时非必填，修改时必填)")
    private Long id;

    /**
     * 文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    /**
     * 文件url
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件url")
    private String fileUrl;

}

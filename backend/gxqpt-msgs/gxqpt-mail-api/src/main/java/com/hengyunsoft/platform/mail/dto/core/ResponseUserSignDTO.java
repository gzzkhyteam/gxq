package com.hengyunsoft.platform.mail.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户签名
 *
 * @auth wt
 * @date 2018/07/30
 */
@Data
@ApiModel(value = "ResponseUserSign", description = "用户签名返回")
public class ResponseUserSignDTO {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 签名标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签名标题")
    private String signTitle;

    /**
     * 签名内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "签名内容")
    private String signContent;

}

package com.hengyunsoft.platform.msgs.dto.msg;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MsgsChannelBaseDTO {

    /**
     * 渠道
     */
    @ApiModelProperty(value = "渠道")
    private String name;

    /**
     * 应用系统ID
     */
    @ApiModelProperty(value = "应用系统ID")
    private String appId;

    /**
     * 密钥
     */
    @ApiModelProperty(value = "密钥")
    private String appSecret;

    /**
     * 渠道类型
     */
    @ApiModelProperty(value = "渠道类型")
    private String channelType;
    //微博的access_token
    @ApiModelProperty(value = "微博的access_token")
    private String accessToken;
    /**
     *描述
     */
    @ApiModelProperty(value = "描述")
    private String description;


}

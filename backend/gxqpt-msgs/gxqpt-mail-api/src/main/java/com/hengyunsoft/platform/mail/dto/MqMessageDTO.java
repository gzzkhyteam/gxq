package com.hengyunsoft.platform.mail.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This is a Description
 *
 * @auth wt
 * @date 2018/08/14
 */

@Data
@ApiModel(value = "MqMessage", description = "邮件消息队列")
public class MqMessageDTO {

    public MqMessageDTO(SendMailInfoDTO mailInfoFB, String email,String userName) {
        this.mailInfoFB = mailInfoFB;
        this.email = email;
        this.userName = userName;
    }

    @ApiModelProperty(value = "邮件相关信息")
    private SendMailInfoDTO mailInfoFB;

    @ApiModelProperty(value = "当前登录邮件地址")
    private String email;

    @ApiModelProperty(value = "当前登录ID")
    private String userName;
}

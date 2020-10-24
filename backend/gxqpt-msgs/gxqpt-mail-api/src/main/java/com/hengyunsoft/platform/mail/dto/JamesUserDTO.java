package com.hengyunsoft.platform.mail.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@Data
public class JamesUserDTO implements Serializable {
    /**
     * 对应c_user表的 账号 account 字段
     * 用户名（邮件地址名）-- 主键
     */
    @ApiModelProperty(value = "对应c_user表的 账号 account 字段")
    private String name;
    /**
     * 邮箱名
     */
    @ApiModelProperty(value = "邮箱 含有后缀")
    private String userName;
}

package com.hengyunsoft.platform.mail.entity.po;

import java.io.Serializable;

import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/26
 */
@Data
public class JamesUser implements Serializable {
    /**
     * 对应c_user表的 账号 account 字段
     * 用户名（邮件地址名）-- 主键
     */
    private String name;
    /**
     * 邮箱名
     */
    private String userName;
    /** 是否启用 */
    private Boolean enable;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 加密标记
     */
    private String alg = "MD5";
    /**
     * 加密算法
     */
    private String passwordHashAlgorithm = "MD5";

    /**
     * 版本号
     */
    private Integer version;

}

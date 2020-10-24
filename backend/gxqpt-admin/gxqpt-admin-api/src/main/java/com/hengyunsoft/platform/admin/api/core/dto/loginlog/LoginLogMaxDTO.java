package com.hengyunsoft.platform.admin.api.core.dto.loginlog;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@ApiModel(value = "LoginLogMax", description = "用于统计最大同时连接数")
public class LoginLogMaxDTO {
    /**
     * id
     *
     * @mbggenerated
     */
    private String id;

    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginTime;

    /**
     * 退出时间
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logoutTime;

    /**
     * 重复数量
     *
     * @mbggenerated
     */
    private int num = 1;
}

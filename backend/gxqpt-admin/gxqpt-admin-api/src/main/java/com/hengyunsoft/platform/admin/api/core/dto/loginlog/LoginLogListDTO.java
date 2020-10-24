package com.hengyunsoft.platform.admin.api.core.dto.loginlog;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "LoginLogList", description = "查询用户登录日志列表")
public class LoginLogListDTO {

    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录应用id")
    private String appId;

    /**
     * 登录人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录人名称")
    private String userName;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录账号")
    private String account;

    /**
     * 登录时间开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录时间开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startLginTime;

    /**
     * 登录时间结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录时间结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endLginTime;

    /**
     * 退出时间开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "退出时间开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startLogoutTime;

    /**
     * 退出时间结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "退出时间结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endLogoutTime;

}

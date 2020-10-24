package com.hengyunsoft.platform.admin.api.core.dto.loginlog;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value = "ResponseLoginLogList", description = "查询用户登录日志返回列表")
public class ResponseLoginLogListDTO {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 登录应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录应用id")
    private String appId;

    /**
     * 登录应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录应用名称")
    private String appName;

    /**
     * 登录人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录人")
    private Long userId;

    /**
     * 登录人名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录人名称")
    private String userName;

    /**
     * 登录时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date loginTime;

    /**
     * 退出时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "退出时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logoutTime;

    /**
     * 主要登录（进入我们系统需要输入密码那一次，当用户登录其中一个系统后，后续的系统将不再进行登录，除非退出。）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主要登录")
    private Boolean masterLoginIs;

    /**
     * 主要登录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主要登录id")
    private Long masterLoginId;

    /**
     * 登陆ip地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登陆ip地址")
    private String loginIp;

    /**
     * 登录账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登录账号")
    private String account;

}

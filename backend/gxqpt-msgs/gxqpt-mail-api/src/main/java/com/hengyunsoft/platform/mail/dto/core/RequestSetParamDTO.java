package com.hengyunsoft.platform.mail.dto.core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 设置参数
 *
 * @auth wt
 * @date 2018/07/30
 */
@Data
@ApiModel(value = "RequestSetParam", description = "设置参数请求")
public class RequestSetParamDTO {

    /**
     * 是否需要回执
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否需要回执")
    private Integer isReceipt;

    /**
     * 默认编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "默认编码")
    private String defaultCode;

    /**
     * 登陆显示页
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "登陆显示页")
    private String loginPage;

    /**
     * 自动清除垃圾时间间隔 （天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "自动清除垃圾时间间隔 （天）")
    private Integer clearTrashGap;

    /**
     * 自动清除病毒时间间隔 （天）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "自动清除病毒时间间隔 （天）")
    private Integer clearViruseGap;

    /**
     * 是否启用自动转发
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用自动转发")
    private Integer autoForward;

    /**
     * 转发到的邮箱
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "转发到的邮箱")
    private String forwardAddress;

    /**
     * 是否保存副本在本地邮箱
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否保存副本在本地邮箱")
    private Integer saveCopyLocal;

    /**
     * 是否启用自动回复
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用自动回复")
    private Integer autoReply;

    /**
     * 回复内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "回复内容")
    private String replyContent;

    /**
     * 当前签名值
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "当前签名值")
    private Long currSign;

    /**
     * 是否记录日志
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否记录日志")
    private Boolean isLogged;
}

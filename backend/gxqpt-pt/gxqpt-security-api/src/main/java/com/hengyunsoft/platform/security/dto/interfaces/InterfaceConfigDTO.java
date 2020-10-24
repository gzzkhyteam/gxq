package com.hengyunsoft.platform.security.dto.interfaces;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Data
@ApiModel(value = "InterfaceConfig", description = "接口阀值设置对象")
public class InterfaceConfigDTO implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接口名称")
    private String apiName;

    /**
     * 接口id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接口id")
    private Long apiId;

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接口地址")
    private String apiUrl;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用id")
    private String appId;

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块名称")
    private String modularName;

    /**
     * 请求方式 post/get/put/delete..
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求方式 post/get/put/delete..")
    private String method;

    /**
     * 每5分钟错误次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "每5分钟错误次数")
    private Integer errorCountMinute;

    /**
     * 每日上限次数 0表示无上限
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "每日上限次数 0表示无上限")
    private Integer upperLimitCountByDay;

    /**
     * 是否短信通知 0否, 1是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否短信通知 0否, 1是")
    private Boolean isSmsNotify;

    /**
     * 接收通知电话号码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "接收通知电话号码")
    private String mobile;

    /**
     * 是否已通知 0未通知 1已通知
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否已通知 0未通知 1已通知")
    private Boolean isNotify;

    /**
     * 状态 1 已设置 0 未设置
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态 1 已设置 0 未设置")
    private Integer status;
}

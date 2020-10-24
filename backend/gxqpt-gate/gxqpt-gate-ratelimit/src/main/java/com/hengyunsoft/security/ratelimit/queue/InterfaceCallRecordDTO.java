package com.hengyunsoft.security.ratelimit.queue;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is a Description
 *
 * @auth tangyh
 * @date 2018/07/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterfaceCallRecordDTO {
	private Long id;

    /**
     * 接口id
     *
     * @mbggenerated
     */
    private Long interfaceConfigId;

    /**
     * 应用id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    private String modularName;

    /**
     * 调用方应用id
     *
     * @mbggenerated
     */
    private String callerAppId;

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 去掉网关前缀 的uri
     *
     * @mbggenerated
     */
    private String uri;

    /**
     * 网关的uri
     *
     * @mbggenerated
     */
    private String zuulUri;

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    private String url;

    /**
     * 调用方ip
     *
     * @mbggenerated
     */
    private String ip;

    private String cookies;

    /**
     * 请求头
     *
     * @mbggenerated
     */
    private String headers;

    /**
     * 请求参数
     *
     * @mbggenerated
     */
    private String queryString;

    /**
     * 请求参数json格式
     *
     * @mbggenerated
     */
    private String requestQueryParams;

    /**
     * 请求长度
     *
     * @mbggenerated
     */
    private String contentLength;

    /**
     * 请求类型
     *
     * @mbggenerated
     */
    private String contentType;

    /**
     * 方法类型
     *
     * @mbggenerated
     */
    private String method;

    /**
     * 请求参数体
     *
     * @mbggenerated
     */
    private String requestBody;

    /**
     * 响应参数
     *
     * @mbggenerated
     */
    private String responseBody;


    /**
     * 调用状态 0成功 1 是解析json失败 其他是具体的错误码

     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * 失败原因
     *
     * @mbggenerated
     */
    private String errMsg;

    private Long userId;

    private String userName;

    /**
     * 账号
     *
     * @mbggenerated
     */
    private String account;

	private Date createTime;
}

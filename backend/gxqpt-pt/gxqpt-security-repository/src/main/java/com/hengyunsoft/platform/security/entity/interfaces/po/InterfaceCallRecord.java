package com.hengyunsoft.platform.security.entity.interfaces.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class InterfaceCallRecord extends BaseEntity<Long> implements Serializable {
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
     * 调用日期yyyyMMdd
     *
     * @mbggenerated
     */
    private String createDate;

    /**
     * 调用月份yyyyMM
     *
     * @mbggenerated
     */
    private String createMonth;

    /**
     * 调用小时HH
     *
     * @mbggenerated
     */
    private String createHour;

    /**
     * 调用时间
     *
     * @mbggenerated
     */
    private Date createTime;

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

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 接口id
     *
     * @mbggenerated
     */
    public Long getInterfaceConfigId() {
        return interfaceConfigId;
    }

    /**
     * 接口id
     *
     * @mbggenerated
     */
    public void setInterfaceConfigId(Long interfaceConfigId) {
        this.interfaceConfigId = interfaceConfigId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    public String getModularName() {
        return modularName;
    }

    /**
     * 模块名称
     *
     * @mbggenerated
     */
    public void setModularName(String modularName) {
        this.modularName = modularName == null ? null : modularName.trim();
    }

    /**
     * 调用方应用id
     *
     * @mbggenerated
     */
    public String getCallerAppId() {
        return callerAppId;
    }

    /**
     * 调用方应用id
     *
     * @mbggenerated
     */
    public void setCallerAppId(String callerAppId) {
        this.callerAppId = callerAppId == null ? null : callerAppId.trim();
    }

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 接口名称
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 去掉网关前缀 的uri
     *
     * @mbggenerated
     */
    public String getUri() {
        return uri;
    }

    /**
     * 去掉网关前缀 的uri
     *
     * @mbggenerated
     */
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * 网关的uri
     *
     * @mbggenerated
     */
    public String getZuulUri() {
        return zuulUri;
    }

    /**
     * 网关的uri
     *
     * @mbggenerated
     */
    public void setZuulUri(String zuulUri) {
        this.zuulUri = zuulUri == null ? null : zuulUri.trim();
    }

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * 接口地址
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 调用方ip
     *
     * @mbggenerated
     */
    public String getIp() {
        return ip;
    }

    /**
     * 调用方ip
     *
     * @mbggenerated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getCookies() {
        return cookies;
    }

    public void setCookies(String cookies) {
        this.cookies = cookies == null ? null : cookies.trim();
    }

    /**
     * 请求头
     *
     * @mbggenerated
     */
    public String getHeaders() {
        return headers;
    }

    /**
     * 请求头
     *
     * @mbggenerated
     */
    public void setHeaders(String headers) {
        this.headers = headers == null ? null : headers.trim();
    }

    /**
     * 请求参数
     *
     * @mbggenerated
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * 请求参数
     *
     * @mbggenerated
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString == null ? null : queryString.trim();
    }

    /**
     * 请求参数json格式
     *
     * @mbggenerated
     */
    public String getRequestQueryParams() {
        return requestQueryParams;
    }

    /**
     * 请求参数json格式
     *
     * @mbggenerated
     */
    public void setRequestQueryParams(String requestQueryParams) {
        this.requestQueryParams = requestQueryParams == null ? null : requestQueryParams.trim();
    }

    /**
     * 请求长度
     *
     * @mbggenerated
     */
    public String getContentLength() {
        return contentLength;
    }

    /**
     * 请求长度
     *
     * @mbggenerated
     */
    public void setContentLength(String contentLength) {
        this.contentLength = contentLength == null ? null : contentLength.trim();
    }

    /**
     * 请求类型
     *
     * @mbggenerated
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 请求类型
     *
     * @mbggenerated
     */
    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    /**
     * 方法类型
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * 方法类型
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 请求参数体
     *
     * @mbggenerated
     */
    public String getRequestBody() {
        return requestBody;
    }

    /**
     * 请求参数体
     *
     * @mbggenerated
     */
    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody == null ? null : requestBody.trim();
    }

    /**
     * 响应参数
     *
     * @mbggenerated
     */
    public String getResponseBody() {
        return responseBody;
    }

    /**
     * 响应参数
     *
     * @mbggenerated
     */
    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody == null ? null : responseBody.trim();
    }

    /**
     * 调用日期yyyyMMdd
     *
     * @mbggenerated
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 调用日期yyyyMMdd
     *
     * @mbggenerated
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 调用月份yyyyMM
     *
     * @mbggenerated
     */
    public String getCreateMonth() {
        return createMonth;
    }

    /**
     * 调用月份yyyyMM
     *
     * @mbggenerated
     */
    public void setCreateMonth(String createMonth) {
        this.createMonth = createMonth == null ? null : createMonth.trim();
    }

    /**
     * 调用小时HH
     *
     * @mbggenerated
     */
    public String getCreateHour() {
        return createHour;
    }

    /**
     * 调用小时HH
     *
     * @mbggenerated
     */
    public void setCreateHour(String createHour) {
        this.createHour = createHour == null ? null : createHour.trim();
    }

    /**
     * 调用时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 调用时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 调用状态 0成功 1 是解析json失败 其他是具体的错误码

     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 调用状态 0成功 1 是解析json失败 其他是具体的错误码

     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 失败原因
     *
     * @mbggenerated
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * 失败原因
     *
     * @mbggenerated
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }
}
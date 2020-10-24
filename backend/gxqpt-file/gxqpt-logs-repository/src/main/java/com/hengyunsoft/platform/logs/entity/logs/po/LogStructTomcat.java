package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogStructTomcat extends BaseEntity<Long> implements Serializable {
    /**
     * 主键
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 日志文件id
     *
     * @mbggenerated
     */
    private String documentId;

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    private String appId;

    /**
     * 远程IP地址
     *
     * @mbggenerated
     */
    private String remoteIp;

    /**
     * 本地IP地址
     *
     * @mbggenerated
     */
    private String localIp;

    /**
     * 发送的字节数，不包括HTTP头，或“ - ”如果没有发送字节
     *
     * @mbggenerated
     */
    private String sendByteLittleb;

    /**
     * 发送的字节数，不包括HTTP头
     *
     * @mbggenerated
     */
    private String sendByteBigb;

    /**
     * 远程主机名
     *
     * @mbggenerated
     */
    private String remoteHost;

    /**
     * 请求协议
     *
     * @mbggenerated
     */
    private String requestAgreement;

    /**
     * (小写的L)- 远程逻辑从identd的用户名（总是返回 “-” ）
     *
     * @mbggenerated
     */
    private String identdUser;

    /**
     * 请求方法
     *
     * @mbggenerated
     */
    private String method;

    /**
     * 本地端口
     *
     * @mbggenerated
     */
    private String port;

    /**
     * 查询字符串（在前面加上一个“？”如果它存在，否则是一个空字符串
     *
     * @mbggenerated
     */
    private String queryStr;

    /**
     * 第一行的要求
     *
     * @mbggenerated
     */
    private String firstLine;

    /**
     * 响应的HTTP状态代码
     *
     * @mbggenerated
     */
    private String status;

    /**
     * 用户会话ID
     *
     * @mbggenerated
     */
    private String sessionId;

    /**
     * 日期和时间，在通用日志格式
     *
     * @mbggenerated
     */
    private Date logTime;

    /**
     * 远程用户身份验证
     *
     * @mbggenerated
     */
    private String remoteCheckUser;

    /**
     * 请求的URL路径
     *
     * @mbggenerated
     */
    private String requestUrl;

    /**
     * 本地服务器名
     *
     * @mbggenerated
     */
    private String localHost;

    /**
     * 处理请求的时间（以毫秒为单位）
     *
     * @mbggenerated
     */
    private Long dealRequestMillisecond;

    /**
     * 处理请求的时间（以秒为单位）   整个请求的总时间（消耗时间）
     *
     * @mbggenerated
     */
    private Long timeConsum;

    /**
     * （大写的i） - 当前请求的线程名称
     *
     * @mbggenerated
     */
    private String currentLine;

    /**
     * 浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    private String accept;

    /**
     * 浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    private String acceptEncoding;

    /**
     * 浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    private String acceptLanguage;

    /**
     * 浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    private String connectionI;

    /**
     * 浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    private String cookie;

    /**
     * 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    private String host;

    /**
     * 浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    private String referer;

    /**
     * 浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    private String userAgent;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String allowCredential;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String accessControlAllowOrigin;

    /**
     * 服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    private String transferEncoding;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String vary;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String xApplicationContext;

    /**
     * 服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    private Date dateO;

    /**
     * 服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    private String server;

    /**
     * 服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    private String connectionO;

    /**
     * 服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    private String contentType;

    /**
     * 服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    private String cacheControl;

    /**
     * xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    private String xxxC;

    /**
     * xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    private String xxxR;

    /**
     * xxx代表HttpSession中的属性名
     *
     * @mbggenerated
     */
    private String xxxS;

    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    private String dataChannel;

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    private Long createUser;

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * 修改人
     *
     * @mbggenerated
     */
    private Long updateUser;

    private String createUserName;

    private String updateUserName;

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 日志文件id
     *
     * @mbggenerated
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * 日志文件id
     *
     * @mbggenerated
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId == null ? null : documentId.trim();
    }

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    /**
     * 远程IP地址
     *
     * @mbggenerated
     */
    public String getRemoteIp() {
        return remoteIp;
    }

    /**
     * 远程IP地址
     *
     * @mbggenerated
     */
    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp == null ? null : remoteIp.trim();
    }

    /**
     * 本地IP地址
     *
     * @mbggenerated
     */
    public String getLocalIp() {
        return localIp;
    }

    /**
     * 本地IP地址
     *
     * @mbggenerated
     */
    public void setLocalIp(String localIp) {
        this.localIp = localIp == null ? null : localIp.trim();
    }

    /**
     * 发送的字节数，不包括HTTP头，或“ - ”如果没有发送字节
     *
     * @mbggenerated
     */
    public String getSendByteLittleb() {
        return sendByteLittleb;
    }

    /**
     * 发送的字节数，不包括HTTP头，或“ - ”如果没有发送字节
     *
     * @mbggenerated
     */
    public void setSendByteLittleb(String sendByteLittleb) {
        this.sendByteLittleb = sendByteLittleb == null ? null : sendByteLittleb.trim();
    }

    /**
     * 发送的字节数，不包括HTTP头
     *
     * @mbggenerated
     */
    public String getSendByteBigb() {
        return sendByteBigb;
    }

    /**
     * 发送的字节数，不包括HTTP头
     *
     * @mbggenerated
     */
    public void setSendByteBigb(String sendByteBigb) {
        this.sendByteBigb = sendByteBigb == null ? null : sendByteBigb.trim();
    }

    /**
     * 远程主机名
     *
     * @mbggenerated
     */
    public String getRemoteHost() {
        return remoteHost;
    }

    /**
     * 远程主机名
     *
     * @mbggenerated
     */
    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost == null ? null : remoteHost.trim();
    }

    /**
     * 请求协议
     *
     * @mbggenerated
     */
    public String getRequestAgreement() {
        return requestAgreement;
    }

    /**
     * 请求协议
     *
     * @mbggenerated
     */
    public void setRequestAgreement(String requestAgreement) {
        this.requestAgreement = requestAgreement == null ? null : requestAgreement.trim();
    }

    /**
     * (小写的L)- 远程逻辑从identd的用户名（总是返回 “-” ）
     *
     * @mbggenerated
     */
    public String getIdentdUser() {
        return identdUser;
    }

    /**
     * (小写的L)- 远程逻辑从identd的用户名（总是返回 “-” ）
     *
     * @mbggenerated
     */
    public void setIdentdUser(String identdUser) {
        this.identdUser = identdUser == null ? null : identdUser.trim();
    }

    /**
     * 请求方法
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * 请求方法
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * 本地端口
     *
     * @mbggenerated
     */
    public String getPort() {
        return port;
    }

    /**
     * 本地端口
     *
     * @mbggenerated
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * 查询字符串（在前面加上一个“？”如果它存在，否则是一个空字符串
     *
     * @mbggenerated
     */
    public String getQueryStr() {
        return queryStr;
    }

    /**
     * 查询字符串（在前面加上一个“？”如果它存在，否则是一个空字符串
     *
     * @mbggenerated
     */
    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr == null ? null : queryStr.trim();
    }

    /**
     * 第一行的要求
     *
     * @mbggenerated
     */
    public String getFirstLine() {
        return firstLine;
    }

    /**
     * 第一行的要求
     *
     * @mbggenerated
     */
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine == null ? null : firstLine.trim();
    }

    /**
     * 响应的HTTP状态代码
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * 响应的HTTP状态代码
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 用户会话ID
     *
     * @mbggenerated
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 用户会话ID
     *
     * @mbggenerated
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    /**
     * 日期和时间，在通用日志格式
     *
     * @mbggenerated
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * 日期和时间，在通用日志格式
     *
     * @mbggenerated
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * 远程用户身份验证
     *
     * @mbggenerated
     */
    public String getRemoteCheckUser() {
        return remoteCheckUser;
    }

    /**
     * 远程用户身份验证
     *
     * @mbggenerated
     */
    public void setRemoteCheckUser(String remoteCheckUser) {
        this.remoteCheckUser = remoteCheckUser == null ? null : remoteCheckUser.trim();
    }

    /**
     * 请求的URL路径
     *
     * @mbggenerated
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 请求的URL路径
     *
     * @mbggenerated
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    /**
     * 本地服务器名
     *
     * @mbggenerated
     */
    public String getLocalHost() {
        return localHost;
    }

    /**
     * 本地服务器名
     *
     * @mbggenerated
     */
    public void setLocalHost(String localHost) {
        this.localHost = localHost == null ? null : localHost.trim();
    }

    /**
     * 处理请求的时间（以毫秒为单位）
     *
     * @mbggenerated
     */
    public Long getDealRequestMillisecond() {
        return dealRequestMillisecond;
    }

    /**
     * 处理请求的时间（以毫秒为单位）
     *
     * @mbggenerated
     */
    public void setDealRequestMillisecond(Long dealRequestMillisecond) {
        this.dealRequestMillisecond = dealRequestMillisecond;
    }

    /**
     * 处理请求的时间（以秒为单位）   整个请求的总时间（消耗时间）
     *
     * @mbggenerated
     */
    public Long getTimeConsum() {
        return timeConsum;
    }

    /**
     * 处理请求的时间（以秒为单位）   整个请求的总时间（消耗时间）
     *
     * @mbggenerated
     */
    public void setTimeConsum(Long timeConsum) {
        this.timeConsum = timeConsum;
    }

    /**
     * （大写的i） - 当前请求的线程名称
     *
     * @mbggenerated
     */
    public String getCurrentLine() {
        return currentLine;
    }

    /**
     * （大写的i） - 当前请求的线程名称
     *
     * @mbggenerated
     */
    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine == null ? null : currentLine.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    public String getAccept() {
        return accept;
    }

    /**
     * 浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    public void setAccept(String accept) {
        this.accept = accept == null ? null : accept.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * 浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding == null ? null : acceptEncoding.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    /**
     * 浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage == null ? null : acceptLanguage.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    public String getConnectionI() {
        return connectionI;
    }

    /**
     * 浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    public void setConnectionI(String connectionI) {
        this.connectionI = connectionI == null ? null : connectionI.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * 浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    public String getHost() {
        return host;
    }

    /**
     * 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    public String getReferer() {
        return referer;
    }

    /**
     * 浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    /**
     * 浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getAllowCredential() {
        return allowCredential;
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setAllowCredential(String allowCredential) {
        this.allowCredential = allowCredential == null ? null : allowCredential.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getAccessControlAllowOrigin() {
        return accessControlAllowOrigin;
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
        this.accessControlAllowOrigin = accessControlAllowOrigin == null ? null : accessControlAllowOrigin.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    public String getTransferEncoding() {
        return transferEncoding;
    }

    /**
     * 服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding == null ? null : transferEncoding.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getVary() {
        return vary;
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setVary(String vary) {
        this.vary = vary == null ? null : vary.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getxApplicationContext() {
        return xApplicationContext;
    }

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setxApplicationContext(String xApplicationContext) {
        this.xApplicationContext = xApplicationContext == null ? null : xApplicationContext.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    public Date getDateO() {
        return dateO;
    }

    /**
     * 服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    public void setDateO(Date dateO) {
        this.dateO = dateO;
    }

    /**
     * 服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    public String getServer() {
        return server;
    }

    /**
     * 服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    public void setServer(String server) {
        this.server = server == null ? null : server.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    public String getConnectionO() {
        return connectionO;
    }

    /**
     * 服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    public void setConnectionO(String connectionO) {
        this.connectionO = connectionO == null ? null : connectionO.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * 服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    /**
     * 服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    public String getCacheControl() {
        return cacheControl;
    }

    /**
     * 服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl == null ? null : cacheControl.trim();
    }

    /**
     * xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    public String getXxxC() {
        return xxxC;
    }

    /**
     * xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    public void setXxxC(String xxxC) {
        this.xxxC = xxxC == null ? null : xxxC.trim();
    }

    /**
     * xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    public String getXxxR() {
        return xxxR;
    }

    /**
     * xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    public void setXxxR(String xxxR) {
        this.xxxR = xxxR == null ? null : xxxR.trim();
    }

    /**
     * xxx代表HttpSession中的属性名
     *
     * @mbggenerated
     */
    public String getXxxS() {
        return xxxS;
    }

    /**
     * xxx代表HttpSession中的属性名
     *
     * @mbggenerated
     */
    public void setXxxS(String xxxS) {
        this.xxxS = xxxS == null ? null : xxxS.trim();
    }

    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    public String getDataChannel() {
        return dataChannel;
    }

    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    public void setDataChannel(String dataChannel) {
        this.dataChannel = dataChannel == null ? null : dataChannel.trim();
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     *
     * @mbggenerated
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     *
     * @mbggenerated
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }
}
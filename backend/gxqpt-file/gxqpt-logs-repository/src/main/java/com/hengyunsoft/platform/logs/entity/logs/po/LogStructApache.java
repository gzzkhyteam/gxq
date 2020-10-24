package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogStructApache extends BaseEntity<Long> implements Serializable {
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
     * %…a: 远程IP地址
     *
     * @mbggenerated
     */
    private String remoteIp;

    /**
     * %…A: 本地IP地址
     *
     * @mbggenerated
     */
    private String localIp;

    /**
     * %…B: 已发送的字节数，不包含HTTP头
     *
     * @mbggenerated
     */
    private String sendByte;

    /**
     * %…{FOOBAR}e: 环境变量FOOBAR的内容
     *
     * @mbggenerated
     */
    private String foobarE;

    /**
     * %…{Foobar}i: Foobar的内容，发送给服务器的请求的标头行。
     *
     * @mbggenerated
     */
    private String foobarI;

    /**
     * %…{Foobar}n: 来自另外一个模块的注解“Foobar”的内容
     *
     * @mbggenerated
     */
    private String foobarN;

    /**
     * %…{Foobar}o: Foobar的内容，应答的标头行
     *
     * @mbggenerated
     */
    private String foobarO;

    /**
     * %…b: CLF格式的已发送字节数量，不包含HTTP头。例如当没有发送数据时，写入‘-’而不是0。
     *
     * @mbggenerated
     */
    private String clfByteCount;

    /**
     * %…f: 文件名字
     *
     * @mbggenerated
     */
    private String fileName;

    /**
     * %…h: 远程主机
     *
     * @mbggenerated
     */
    private String host;

    /**
     * %…H 请求的协议
     *
     * @mbggenerated
     */
    private String requestAgreement;

    /**
     * %…l: 远程登录名字（来自identd，如提供的话）
     *
     * @mbggenerated
     */
    private String remoteLoginName;

    /**
     * %…m 请求的方法
     *
     * @mbggenerated
     */
    private String method;

    /**
     * %…p: 服务器响应请求时使用的端口
     *
     * @mbggenerated
     */
    private String port;

    /**
     * %…P: 响应请求的子进程ID
     *
     * @mbggenerated
     */
    private String threadId;

    /**
     * %…q 查询字符串（如果存在查询字符串，则包含“?”后面的部分；否则，它是一个空字符串。）
     *
     * @mbggenerated
     */
    private String queryStr;

    /**
     * %…r: 请求的第一行
     *
     * @mbggenerated
     */
    private String reqFirstLine;

    /**
     * %…s: 状态。对于进行内部重定向的请求，这是指*原来*请求的状态。如果用%…>s，则是指后来的请求。
     *
     * @mbggenerated
     */
    private String status;

    /**
     * %…t: 以公共日志时间格式表示的时间（或称为标准英文格式）
     *
     * @mbggenerated
     */
    private Date logTime;

    /**
     * %…T: 为响应请求而耗费的时间，以秒计
     *
     * @mbggenerated
     */
    private Long timeConsum;

    /**
     * %…u: 远程用户（来自auth；如果返回状态（%s）是401则可能是伪造的）
     *
     * @mbggenerated
     */
    private String remoteUser;

    /**
     * %…U: 用户所请求的URL路径
     *
     * @mbggenerated
     */
    private String requestUrl;

    /**
     * %…v: 响应请求的服务器的ServerName
     *
     * @mbggenerated
     */
    private String rspServerName;

    /**
     * %…V: 依照UseCanonicalName设置得到的服务器名字
     *
     * @mbggenerated
     */
    private String ucnServerName;

    /**
     * %% :The percent sign
     *
     * @mbggenerated
     */
    private String percentSign;

    /**
     * %D :The time taken to serve the request, in microseconds.(为请求服务的时间，以微秒为单位)
     *
     * @mbggenerated
     */
    private Long microseconds;

    /**
     * %k:Number of keepalive requests handled on this connection. Interesting if KeepAlive is being used, so that, for example, a '1' means the first keepalive request after the initial one, '2' the second, etc...; otherwise this is always 0 (indicating the initial request). Available in versions 2.2.11 and later.
     *
     * @mbggenerated
     */
    private String keepAlive;

    /**
     * %R :The handler generating the response (if any).
     *
     * @mbggenerated
     */
    private String responseGenerate;

    /**
     * %v :The canonical ServerName of the server serving the request.
     *
     * @mbggenerated
     */
    private String serving;

    /**
     * %X:Connection status when response is completed:
     *
     * @mbggenerated
     */
    private String responseCompleted;

    /**
     * %I:Bytes received, including request and headers, cannot be zero. You need to enable mod_logio to use this.
     *
     * @mbggenerated
     */
    private String bytesReceived;

    /**
     * %O:Bytes sent, including headers, cannot be zero. You need to enable mod_logio to use this.
     *
     * @mbggenerated
     */
    private String bytesSent;

    /**
     * %{VARNAME}^ti:The contents of VARNAME: trailer line(s) in the request sent to the server.
     *
     * @mbggenerated
     */
    private String varnameTi;

    /**
     * %{VARNAME}^to:The contents of VARNAME: trailer line(s) in the response sent from the server. 
     *
     * @mbggenerated
     */
    private String varnameTo;

    /**
     * %{UNIT}T:The time taken to serve the request, in a time unit given by UNIT. Valid units are ms for milliseconds, us for microseconds, and s for seconds. Using s gives the same result as %T without any format; using us gives the same result as %D. Combining %T with a unit is available in 2.2.30 and later.
     *
     * @mbggenerated
     */
    private String unitT;

    /**
     * %{format}p:The canonical port of the server serving the request or the server's actual port or the client's actual port. Valid formats are canonical, local, or remote.
     *
     * @mbggenerated
     */
    private String formatP;

    /**
     * %{format}P:The process ID or thread id of the child that serviced the request. Valid formats are pid, tid, and hextid. hextid requires APR 1.2.0 or higher.
     *
     * @mbggenerated
     */
    private String formatBigp;

    /**
     * %{Foobar}C:The contents of cookie Foobar in the request sent to the server. Only version 0 cookies are fully 
     *
     * @mbggenerated
     */
    private String foobarC;

    /**
     * %{format}t:The time, in the form given by format, which should be in an extended strftime(3) format (potentially localized). If the format starts with begin: (default) the time is taken at the beginning of the request processing. If it starts with end: it is the time when the log entry gets written, close to the end of the request processing. In addition to the formats supported by strftime(3), the following format tokens are supported:
     *
     * @mbggenerated
     */
    private String foobarT;

    /**
     * %{Accept}i:浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    private String accept;

    /**
     * %{Accept-Encoding}i:浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    private String acceptEncoding;

    /**
     * %{Accept-Language}i:浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    private String acceptLanguage;

    /**
     * %{Connection}i:浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    private String connectionI;

    /**
     * %{Cookie}i :浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    private String cookie;

    /**
     * %{Host}i 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    private String hostName;

    /**
     * %{Referer}i:浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    private String referer;

    /**
     * %{User-Agent}i:浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    private String userAgent;

    /**
     * %{Allow-Credentials}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String allowCredentials;

    /**
     * %{Access-Control-Allow-Origin}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String accessControlAllowOrigin;

    /**
     * %{Transfer-Encoding}o:服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    private String transferEncoding;

    /**
     * %{Vary}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String vary;

    /**
     * %{X-Application-Context}o :服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    private String xApplicationContext;

    /**
     * %{Date}o:服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    private Date dateO;

    /**
     * %{server}o:服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    private String server;

    /**
     * %{Connection}o:服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    private String connectionO;

    /**
     * %{content-type}o :服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    private String contentType;

    /**
     * %{Cache-Control}o:服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    private String cacheControl;

    /**
     * %{XXX}c :xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    private String xxxC;

    /**
     * %{XXX}r:xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    private String xxxR;

    /**
     * %{XXX}s:xxx代表HttpSession中的属性名
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
     * %…a: 远程IP地址
     *
     * @mbggenerated
     */
    public String getRemoteIp() {
        return remoteIp;
    }

    /**
     * %…a: 远程IP地址
     *
     * @mbggenerated
     */
    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp == null ? null : remoteIp.trim();
    }

    /**
     * %…A: 本地IP地址
     *
     * @mbggenerated
     */
    public String getLocalIp() {
        return localIp;
    }

    /**
     * %…A: 本地IP地址
     *
     * @mbggenerated
     */
    public void setLocalIp(String localIp) {
        this.localIp = localIp == null ? null : localIp.trim();
    }

    /**
     * %…B: 已发送的字节数，不包含HTTP头
     *
     * @mbggenerated
     */
    public String getSendByte() {
        return sendByte;
    }

    /**
     * %…B: 已发送的字节数，不包含HTTP头
     *
     * @mbggenerated
     */
    public void setSendByte(String sendByte) {
        this.sendByte = sendByte == null ? null : sendByte.trim();
    }

    /**
     * %…{FOOBAR}e: 环境变量FOOBAR的内容
     *
     * @mbggenerated
     */
    public String getFoobarE() {
        return foobarE;
    }

    /**
     * %…{FOOBAR}e: 环境变量FOOBAR的内容
     *
     * @mbggenerated
     */
    public void setFoobarE(String foobarE) {
        this.foobarE = foobarE == null ? null : foobarE.trim();
    }

    /**
     * %…{Foobar}i: Foobar的内容，发送给服务器的请求的标头行。
     *
     * @mbggenerated
     */
    public String getFoobarI() {
        return foobarI;
    }

    /**
     * %…{Foobar}i: Foobar的内容，发送给服务器的请求的标头行。
     *
     * @mbggenerated
     */
    public void setFoobarI(String foobarI) {
        this.foobarI = foobarI == null ? null : foobarI.trim();
    }

    /**
     * %…{Foobar}n: 来自另外一个模块的注解“Foobar”的内容
     *
     * @mbggenerated
     */
    public String getFoobarN() {
        return foobarN;
    }

    /**
     * %…{Foobar}n: 来自另外一个模块的注解“Foobar”的内容
     *
     * @mbggenerated
     */
    public void setFoobarN(String foobarN) {
        this.foobarN = foobarN == null ? null : foobarN.trim();
    }

    /**
     * %…{Foobar}o: Foobar的内容，应答的标头行
     *
     * @mbggenerated
     */
    public String getFoobarO() {
        return foobarO;
    }

    /**
     * %…{Foobar}o: Foobar的内容，应答的标头行
     *
     * @mbggenerated
     */
    public void setFoobarO(String foobarO) {
        this.foobarO = foobarO == null ? null : foobarO.trim();
    }

    /**
     * %…b: CLF格式的已发送字节数量，不包含HTTP头。例如当没有发送数据时，写入‘-’而不是0。
     *
     * @mbggenerated
     */
    public String getClfByteCount() {
        return clfByteCount;
    }

    /**
     * %…b: CLF格式的已发送字节数量，不包含HTTP头。例如当没有发送数据时，写入‘-’而不是0。
     *
     * @mbggenerated
     */
    public void setClfByteCount(String clfByteCount) {
        this.clfByteCount = clfByteCount == null ? null : clfByteCount.trim();
    }

    /**
     * %…f: 文件名字
     *
     * @mbggenerated
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * %…f: 文件名字
     *
     * @mbggenerated
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * %…h: 远程主机
     *
     * @mbggenerated
     */
    public String getHost() {
        return host;
    }

    /**
     * %…h: 远程主机
     *
     * @mbggenerated
     */
    public void setHost(String host) {
        this.host = host == null ? null : host.trim();
    }

    /**
     * %…H 请求的协议
     *
     * @mbggenerated
     */
    public String getRequestAgreement() {
        return requestAgreement;
    }

    /**
     * %…H 请求的协议
     *
     * @mbggenerated
     */
    public void setRequestAgreement(String requestAgreement) {
        this.requestAgreement = requestAgreement == null ? null : requestAgreement.trim();
    }

    /**
     * %…l: 远程登录名字（来自identd，如提供的话）
     *
     * @mbggenerated
     */
    public String getRemoteLoginName() {
        return remoteLoginName;
    }

    /**
     * %…l: 远程登录名字（来自identd，如提供的话）
     *
     * @mbggenerated
     */
    public void setRemoteLoginName(String remoteLoginName) {
        this.remoteLoginName = remoteLoginName == null ? null : remoteLoginName.trim();
    }

    /**
     * %…m 请求的方法
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * %…m 请求的方法
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    /**
     * %…p: 服务器响应请求时使用的端口
     *
     * @mbggenerated
     */
    public String getPort() {
        return port;
    }

    /**
     * %…p: 服务器响应请求时使用的端口
     *
     * @mbggenerated
     */
    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    /**
     * %…P: 响应请求的子进程ID
     *
     * @mbggenerated
     */
    public String getThreadId() {
        return threadId;
    }

    /**
     * %…P: 响应请求的子进程ID
     *
     * @mbggenerated
     */
    public void setThreadId(String threadId) {
        this.threadId = threadId == null ? null : threadId.trim();
    }

    /**
     * %…q 查询字符串（如果存在查询字符串，则包含“?”后面的部分；否则，它是一个空字符串。）
     *
     * @mbggenerated
     */
    public String getQueryStr() {
        return queryStr;
    }

    /**
     * %…q 查询字符串（如果存在查询字符串，则包含“?”后面的部分；否则，它是一个空字符串。）
     *
     * @mbggenerated
     */
    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr == null ? null : queryStr.trim();
    }

    /**
     * %…r: 请求的第一行
     *
     * @mbggenerated
     */
    public String getReqFirstLine() {
        return reqFirstLine;
    }

    /**
     * %…r: 请求的第一行
     *
     * @mbggenerated
     */
    public void setReqFirstLine(String reqFirstLine) {
        this.reqFirstLine = reqFirstLine == null ? null : reqFirstLine.trim();
    }

    /**
     * %…s: 状态。对于进行内部重定向的请求，这是指*原来*请求的状态。如果用%…>s，则是指后来的请求。
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * %…s: 状态。对于进行内部重定向的请求，这是指*原来*请求的状态。如果用%…>s，则是指后来的请求。
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * %…t: 以公共日志时间格式表示的时间（或称为标准英文格式）
     *
     * @mbggenerated
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * %…t: 以公共日志时间格式表示的时间（或称为标准英文格式）
     *
     * @mbggenerated
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * %…T: 为响应请求而耗费的时间，以秒计
     *
     * @mbggenerated
     */
    public Long getTimeConsum() {
        return timeConsum;
    }

    /**
     * %…T: 为响应请求而耗费的时间，以秒计
     *
     * @mbggenerated
     */
    public void setTimeConsum(Long timeConsum) {
        this.timeConsum = timeConsum;
    }

    /**
     * %…u: 远程用户（来自auth；如果返回状态（%s）是401则可能是伪造的）
     *
     * @mbggenerated
     */
    public String getRemoteUser() {
        return remoteUser;
    }

    /**
     * %…u: 远程用户（来自auth；如果返回状态（%s）是401则可能是伪造的）
     *
     * @mbggenerated
     */
    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser == null ? null : remoteUser.trim();
    }

    /**
     * %…U: 用户所请求的URL路径
     *
     * @mbggenerated
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * %…U: 用户所请求的URL路径
     *
     * @mbggenerated
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    /**
     * %…v: 响应请求的服务器的ServerName
     *
     * @mbggenerated
     */
    public String getRspServerName() {
        return rspServerName;
    }

    /**
     * %…v: 响应请求的服务器的ServerName
     *
     * @mbggenerated
     */
    public void setRspServerName(String rspServerName) {
        this.rspServerName = rspServerName == null ? null : rspServerName.trim();
    }

    /**
     * %…V: 依照UseCanonicalName设置得到的服务器名字
     *
     * @mbggenerated
     */
    public String getUcnServerName() {
        return ucnServerName;
    }

    /**
     * %…V: 依照UseCanonicalName设置得到的服务器名字
     *
     * @mbggenerated
     */
    public void setUcnServerName(String ucnServerName) {
        this.ucnServerName = ucnServerName == null ? null : ucnServerName.trim();
    }

    /**
     * %% :The percent sign
     *
     * @mbggenerated
     */
    public String getPercentSign() {
        return percentSign;
    }

    /**
     * %% :The percent sign
     *
     * @mbggenerated
     */
    public void setPercentSign(String percentSign) {
        this.percentSign = percentSign == null ? null : percentSign.trim();
    }

    /**
     * %D :The time taken to serve the request, in microseconds.(为请求服务的时间，以微秒为单位)
     *
     * @mbggenerated
     */
    public Long getMicroseconds() {
        return microseconds;
    }

    /**
     * %D :The time taken to serve the request, in microseconds.(为请求服务的时间，以微秒为单位)
     *
     * @mbggenerated
     */
    public void setMicroseconds(Long microseconds) {
        this.microseconds = microseconds;
    }

    /**
     * %k:Number of keepalive requests handled on this connection. Interesting if KeepAlive is being used, so that, for example, a '1' means the first keepalive request after the initial one, '2' the second, etc...; otherwise this is always 0 (indicating the initial request). Available in versions 2.2.11 and later.
     *
     * @mbggenerated
     */
    public String getKeepAlive() {
        return keepAlive;
    }

    /**
     * %k:Number of keepalive requests handled on this connection. Interesting if KeepAlive is being used, so that, for example, a '1' means the first keepalive request after the initial one, '2' the second, etc...; otherwise this is always 0 (indicating the initial request). Available in versions 2.2.11 and later.
     *
     * @mbggenerated
     */
    public void setKeepAlive(String keepAlive) {
        this.keepAlive = keepAlive == null ? null : keepAlive.trim();
    }

    /**
     * %R :The handler generating the response (if any).
     *
     * @mbggenerated
     */
    public String getResponseGenerate() {
        return responseGenerate;
    }

    /**
     * %R :The handler generating the response (if any).
     *
     * @mbggenerated
     */
    public void setResponseGenerate(String responseGenerate) {
        this.responseGenerate = responseGenerate == null ? null : responseGenerate.trim();
    }

    /**
     * %v :The canonical ServerName of the server serving the request.
     *
     * @mbggenerated
     */
    public String getServing() {
        return serving;
    }

    /**
     * %v :The canonical ServerName of the server serving the request.
     *
     * @mbggenerated
     */
    public void setServing(String serving) {
        this.serving = serving == null ? null : serving.trim();
    }

    /**
     * %X:Connection status when response is completed:
     *
     * @mbggenerated
     */
    public String getResponseCompleted() {
        return responseCompleted;
    }

    /**
     * %X:Connection status when response is completed:
     *
     * @mbggenerated
     */
    public void setResponseCompleted(String responseCompleted) {
        this.responseCompleted = responseCompleted == null ? null : responseCompleted.trim();
    }

    /**
     * %I:Bytes received, including request and headers, cannot be zero. You need to enable mod_logio to use this.
     *
     * @mbggenerated
     */
    public String getBytesReceived() {
        return bytesReceived;
    }

    /**
     * %I:Bytes received, including request and headers, cannot be zero. You need to enable mod_logio to use this.
     *
     * @mbggenerated
     */
    public void setBytesReceived(String bytesReceived) {
        this.bytesReceived = bytesReceived == null ? null : bytesReceived.trim();
    }

    /**
     * %O:Bytes sent, including headers, cannot be zero. You need to enable mod_logio to use this.
     *
     * @mbggenerated
     */
    public String getBytesSent() {
        return bytesSent;
    }

    /**
     * %O:Bytes sent, including headers, cannot be zero. You need to enable mod_logio to use this.
     *
     * @mbggenerated
     */
    public void setBytesSent(String bytesSent) {
        this.bytesSent = bytesSent == null ? null : bytesSent.trim();
    }

    /**
     * %{VARNAME}^ti:The contents of VARNAME: trailer line(s) in the request sent to the server.
     *
     * @mbggenerated
     */
    public String getVarnameTi() {
        return varnameTi;
    }

    /**
     * %{VARNAME}^ti:The contents of VARNAME: trailer line(s) in the request sent to the server.
     *
     * @mbggenerated
     */
    public void setVarnameTi(String varnameTi) {
        this.varnameTi = varnameTi == null ? null : varnameTi.trim();
    }

    /**
     * %{VARNAME}^to:The contents of VARNAME: trailer line(s) in the response sent from the server. 
     *
     * @mbggenerated
     */
    public String getVarnameTo() {
        return varnameTo;
    }

    /**
     * %{VARNAME}^to:The contents of VARNAME: trailer line(s) in the response sent from the server. 
     *
     * @mbggenerated
     */
    public void setVarnameTo(String varnameTo) {
        this.varnameTo = varnameTo == null ? null : varnameTo.trim();
    }

    /**
     * %{UNIT}T:The time taken to serve the request, in a time unit given by UNIT. Valid units are ms for milliseconds, us for microseconds, and s for seconds. Using s gives the same result as %T without any format; using us gives the same result as %D. Combining %T with a unit is available in 2.2.30 and later.
     *
     * @mbggenerated
     */
    public String getUnitT() {
        return unitT;
    }

    /**
     * %{UNIT}T:The time taken to serve the request, in a time unit given by UNIT. Valid units are ms for milliseconds, us for microseconds, and s for seconds. Using s gives the same result as %T without any format; using us gives the same result as %D. Combining %T with a unit is available in 2.2.30 and later.
     *
     * @mbggenerated
     */
    public void setUnitT(String unitT) {
        this.unitT = unitT == null ? null : unitT.trim();
    }

    /**
     * %{format}p:The canonical port of the server serving the request or the server's actual port or the client's actual port. Valid formats are canonical, local, or remote.
     *
     * @mbggenerated
     */
    public String getFormatP() {
        return formatP;
    }

    /**
     * %{format}p:The canonical port of the server serving the request or the server's actual port or the client's actual port. Valid formats are canonical, local, or remote.
     *
     * @mbggenerated
     */
    public void setFormatP(String formatP) {
        this.formatP = formatP == null ? null : formatP.trim();
    }

    /**
     * %{format}P:The process ID or thread id of the child that serviced the request. Valid formats are pid, tid, and hextid. hextid requires APR 1.2.0 or higher.
     *
     * @mbggenerated
     */
    public String getFormatBigp() {
        return formatBigp;
    }

    /**
     * %{format}P:The process ID or thread id of the child that serviced the request. Valid formats are pid, tid, and hextid. hextid requires APR 1.2.0 or higher.
     *
     * @mbggenerated
     */
    public void setFormatBigp(String formatBigp) {
        this.formatBigp = formatBigp == null ? null : formatBigp.trim();
    }

    /**
     * %{Foobar}C:The contents of cookie Foobar in the request sent to the server. Only version 0 cookies are fully 
     *
     * @mbggenerated
     */
    public String getFoobarC() {
        return foobarC;
    }

    /**
     * %{Foobar}C:The contents of cookie Foobar in the request sent to the server. Only version 0 cookies are fully 
     *
     * @mbggenerated
     */
    public void setFoobarC(String foobarC) {
        this.foobarC = foobarC == null ? null : foobarC.trim();
    }

    /**
     * %{format}t:The time, in the form given by format, which should be in an extended strftime(3) format (potentially localized). If the format starts with begin: (default) the time is taken at the beginning of the request processing. If it starts with end: it is the time when the log entry gets written, close to the end of the request processing. In addition to the formats supported by strftime(3), the following format tokens are supported:
     *
     * @mbggenerated
     */
    public String getFoobarT() {
        return foobarT;
    }

    /**
     * %{format}t:The time, in the form given by format, which should be in an extended strftime(3) format (potentially localized). If the format starts with begin: (default) the time is taken at the beginning of the request processing. If it starts with end: it is the time when the log entry gets written, close to the end of the request processing. In addition to the formats supported by strftime(3), the following format tokens are supported:
     *
     * @mbggenerated
     */
    public void setFoobarT(String foobarT) {
        this.foobarT = foobarT == null ? null : foobarT.trim();
    }

    /**
     * %{Accept}i:浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    public String getAccept() {
        return accept;
    }

    /**
     * %{Accept}i:浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    public void setAccept(String accept) {
        this.accept = accept == null ? null : accept.trim();
    }

    /**
     * %{Accept-Encoding}i:浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    /**
     * %{Accept-Encoding}i:浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding == null ? null : acceptEncoding.trim();
    }

    /**
     * %{Accept-Language}i:浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    /**
     * %{Accept-Language}i:浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    public void setAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage == null ? null : acceptLanguage.trim();
    }

    /**
     * %{Connection}i:浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    public String getConnectionI() {
        return connectionI;
    }

    /**
     * %{Connection}i:浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    public void setConnectionI(String connectionI) {
        this.connectionI = connectionI == null ? null : connectionI.trim();
    }

    /**
     * %{Cookie}i :浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * %{Cookie}i :浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    /**
     * %{Host}i 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * %{Host}i 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    public void setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();
    }

    /**
     * %{Referer}i:浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    public String getReferer() {
        return referer;
    }

    /**
     * %{Referer}i:浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    /**
     * %{User-Agent}i:浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * %{User-Agent}i:浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    /**
     * %{Allow-Credentials}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getAllowCredentials() {
        return allowCredentials;
    }

    /**
     * %{Allow-Credentials}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setAllowCredentials(String allowCredentials) {
        this.allowCredentials = allowCredentials == null ? null : allowCredentials.trim();
    }

    /**
     * %{Access-Control-Allow-Origin}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getAccessControlAllowOrigin() {
        return accessControlAllowOrigin;
    }

    /**
     * %{Access-Control-Allow-Origin}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setAccessControlAllowOrigin(String accessControlAllowOrigin) {
        this.accessControlAllowOrigin = accessControlAllowOrigin == null ? null : accessControlAllowOrigin.trim();
    }

    /**
     * %{Transfer-Encoding}o:服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    public String getTransferEncoding() {
        return transferEncoding;
    }

    /**
     * %{Transfer-Encoding}o:服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    public void setTransferEncoding(String transferEncoding) {
        this.transferEncoding = transferEncoding == null ? null : transferEncoding.trim();
    }

    /**
     * %{Vary}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getVary() {
        return vary;
    }

    /**
     * %{Vary}o:服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setVary(String vary) {
        this.vary = vary == null ? null : vary.trim();
    }

    /**
     * %{X-Application-Context}o :服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public String getxApplicationContext() {
        return xApplicationContext;
    }

    /**
     * %{X-Application-Context}o :服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    public void setxApplicationContext(String xApplicationContext) {
        this.xApplicationContext = xApplicationContext == null ? null : xApplicationContext.trim();
    }

    /**
     * %{Date}o:服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    public Date getDateO() {
        return dateO;
    }

    /**
     * %{Date}o:服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    public void setDateO(Date dateO) {
        this.dateO = dateO;
    }

    /**
     * %{server}o:服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    public String getServer() {
        return server;
    }

    /**
     * %{server}o:服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    public void setServer(String server) {
        this.server = server == null ? null : server.trim();
    }

    /**
     * %{Connection}o:服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    public String getConnectionO() {
        return connectionO;
    }

    /**
     * %{Connection}o:服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    public void setConnectionO(String connectionO) {
        this.connectionO = connectionO == null ? null : connectionO.trim();
    }

    /**
     * %{content-type}o :服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * %{content-type}o :服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    /**
     * %{Cache-Control}o:服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    public String getCacheControl() {
        return cacheControl;
    }

    /**
     * %{Cache-Control}o:服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl == null ? null : cacheControl.trim();
    }

    /**
     * %{XXX}c :xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    public String getXxxC() {
        return xxxC;
    }

    /**
     * %{XXX}c :xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    public void setXxxC(String xxxC) {
        this.xxxC = xxxC == null ? null : xxxC.trim();
    }

    /**
     * %{XXX}r:xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    public String getXxxR() {
        return xxxR;
    }

    /**
     * %{XXX}r:xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    public void setXxxR(String xxxR) {
        this.xxxR = xxxR == null ? null : xxxR.trim();
    }

    /**
     * %{XXX}s:xxx代表HttpSession中的属性名
     *
     * @mbggenerated
     */
    public String getXxxS() {
        return xxxS;
    }

    /**
     * %{XXX}s:xxx代表HttpSession中的属性名
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
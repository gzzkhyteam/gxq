package com.hengyunsoft.platform.logs.entity.logs.po;

import com.hengyunsoft.base.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class LogStructNginx extends BaseEntity<Long> implements Serializable {
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
     * 客户端地址
     *
     * @mbggenerated
     */
    private String remoteAddr;

    /**
     * 客户端用户名称
     *
     * @mbggenerated
     */
    private String remoteUser;

    /**
     * 访问时间和时区
     *
     * @mbggenerated
     */
    private Date localTime;

    /**
     * 请求的URI和HTTP协议
     *
     * @mbggenerated
     */
    private String requestAgreen;

    /**
     * 请求地址，即浏览器中你输入的地址（IP或域名）
     *
     * @mbggenerated
     */
    private String requestUrl;

    /**
     * HTTP请求状态
     *
     * @mbggenerated
     */
    private String status;

    /**
     * upstream状态
     *
     * @mbggenerated
     */
    private String upstreamStatus;

    /**
     * 发送给客户端文件内容大小
     *
     * @mbggenerated
     */
    private String bodyBytesSent;

    /**
     * url跳转来源
     *
     * @mbggenerated
     */
    private String httpReferer;

    /**
     * 用户终端浏览器等信息
     *
     * @mbggenerated
     */
    private String httpUserAgent;

    /**
     * SSL协议版本
     *
     * @mbggenerated
     */
    private String sslProtocol;

    /**
     * 交换数据中的算法
     *
     * @mbggenerated
     */
    private String sslCipher;

    /**
     * 后台upstream的地址，即真正提供服务的主机地址
     *
     * @mbggenerated
     */
    private String upstreamAddr;

    /**
     * 整个请求的总时间（消耗时间）
     *
     * @mbggenerated
     */
    private Long timeConsum;

    /**
     * 请求过程中，upstream响应时间
     *
     * @mbggenerated
     */
    private Date upstreamResponseTime;

    /**
     * the number of bytes sent to a client （发送给客户端的字节数。）
     *
     * @mbggenerated
     */
    private Long bytesSent;

    /**
     * connection serial number （连接数）
     *
     * @mbggenerated
     */
    private Long connection;

    /**
     * the current number of requests made through a connection (1.1.18) （目前通过一个连接请求数（1.1.18））
     *
     * @mbggenerated
     */
    private Long connectionRequests;

    /**
     * time in seconds with a milliseconds resolution at the time of the log write 
     *
     * @mbggenerated
     */
    private String msec;

    /**
     * “p” if request was pipelined, “.” otherwise 
     *
     * @mbggenerated
     */
    private String pipe;

    /**
     * request length (including request line, header, and request body) (请求长度（包括请求行、标头和请求正文）)
     *
     * @mbggenerated
     */
    private Long requestLength;

    /**
     * local time in the ISO 8601 standard format
     *
     * @mbggenerated
     */
    private Date timeIso8601;

    /**
     * local time in the Common Log Format
     *
     * @mbggenerated
     */
    private Date timeLocal;

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
     * 客户端地址
     *
     * @mbggenerated
     */
    public String getRemoteAddr() {
        return remoteAddr;
    }

    /**
     * 客户端地址
     *
     * @mbggenerated
     */
    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr == null ? null : remoteAddr.trim();
    }

    /**
     * 客户端用户名称
     *
     * @mbggenerated
     */
    public String getRemoteUser() {
        return remoteUser;
    }

    /**
     * 客户端用户名称
     *
     * @mbggenerated
     */
    public void setRemoteUser(String remoteUser) {
        this.remoteUser = remoteUser == null ? null : remoteUser.trim();
    }

    /**
     * 访问时间和时区
     *
     * @mbggenerated
     */
    public Date getLocalTime() {
        return localTime;
    }

    /**
     * 访问时间和时区
     *
     * @mbggenerated
     */
    public void setLocalTime(Date localTime) {
        this.localTime = localTime;
    }

    /**
     * 请求的URI和HTTP协议
     *
     * @mbggenerated
     */
    public String getRequestAgreen() {
        return requestAgreen;
    }

    /**
     * 请求的URI和HTTP协议
     *
     * @mbggenerated
     */
    public void setRequestAgreen(String requestAgreen) {
        this.requestAgreen = requestAgreen == null ? null : requestAgreen.trim();
    }

    /**
     * 请求地址，即浏览器中你输入的地址（IP或域名）
     *
     * @mbggenerated
     */
    public String getRequestUrl() {
        return requestUrl;
    }

    /**
     * 请求地址，即浏览器中你输入的地址（IP或域名）
     *
     * @mbggenerated
     */
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    /**
     * HTTP请求状态
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * HTTP请求状态
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * upstream状态
     *
     * @mbggenerated
     */
    public String getUpstreamStatus() {
        return upstreamStatus;
    }

    /**
     * upstream状态
     *
     * @mbggenerated
     */
    public void setUpstreamStatus(String upstreamStatus) {
        this.upstreamStatus = upstreamStatus == null ? null : upstreamStatus.trim();
    }

    /**
     * 发送给客户端文件内容大小
     *
     * @mbggenerated
     */
    public String getBodyBytesSent() {
        return bodyBytesSent;
    }

    /**
     * 发送给客户端文件内容大小
     *
     * @mbggenerated
     */
    public void setBodyBytesSent(String bodyBytesSent) {
        this.bodyBytesSent = bodyBytesSent == null ? null : bodyBytesSent.trim();
    }

    /**
     * url跳转来源
     *
     * @mbggenerated
     */
    public String getHttpReferer() {
        return httpReferer;
    }

    /**
     * url跳转来源
     *
     * @mbggenerated
     */
    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer == null ? null : httpReferer.trim();
    }

    /**
     * 用户终端浏览器等信息
     *
     * @mbggenerated
     */
    public String getHttpUserAgent() {
        return httpUserAgent;
    }

    /**
     * 用户终端浏览器等信息
     *
     * @mbggenerated
     */
    public void setHttpUserAgent(String httpUserAgent) {
        this.httpUserAgent = httpUserAgent == null ? null : httpUserAgent.trim();
    }

    /**
     * SSL协议版本
     *
     * @mbggenerated
     */
    public String getSslProtocol() {
        return sslProtocol;
    }

    /**
     * SSL协议版本
     *
     * @mbggenerated
     */
    public void setSslProtocol(String sslProtocol) {
        this.sslProtocol = sslProtocol == null ? null : sslProtocol.trim();
    }

    /**
     * 交换数据中的算法
     *
     * @mbggenerated
     */
    public String getSslCipher() {
        return sslCipher;
    }

    /**
     * 交换数据中的算法
     *
     * @mbggenerated
     */
    public void setSslCipher(String sslCipher) {
        this.sslCipher = sslCipher == null ? null : sslCipher.trim();
    }

    /**
     * 后台upstream的地址，即真正提供服务的主机地址
     *
     * @mbggenerated
     */
    public String getUpstreamAddr() {
        return upstreamAddr;
    }

    /**
     * 后台upstream的地址，即真正提供服务的主机地址
     *
     * @mbggenerated
     */
    public void setUpstreamAddr(String upstreamAddr) {
        this.upstreamAddr = upstreamAddr == null ? null : upstreamAddr.trim();
    }

    /**
     * 整个请求的总时间（消耗时间）
     *
     * @mbggenerated
     */
    public Long getTimeConsum() {
        return timeConsum;
    }

    /**
     * 整个请求的总时间（消耗时间）
     *
     * @mbggenerated
     */
    public void setTimeConsum(Long timeConsum) {
        this.timeConsum = timeConsum;
    }

    /**
     * 请求过程中，upstream响应时间
     *
     * @mbggenerated
     */
    public Date getUpstreamResponseTime() {
        return upstreamResponseTime;
    }

    /**
     * 请求过程中，upstream响应时间
     *
     * @mbggenerated
     */
    public void setUpstreamResponseTime(Date upstreamResponseTime) {
        this.upstreamResponseTime = upstreamResponseTime;
    }

    /**
     * the number of bytes sent to a client （发送给客户端的字节数。）
     *
     * @mbggenerated
     */
    public Long getBytesSent() {
        return bytesSent;
    }

    /**
     * the number of bytes sent to a client （发送给客户端的字节数。）
     *
     * @mbggenerated
     */
    public void setBytesSent(Long bytesSent) {
        this.bytesSent = bytesSent;
    }

    /**
     * connection serial number （连接数）
     *
     * @mbggenerated
     */
    public Long getConnection() {
        return connection;
    }

    /**
     * connection serial number （连接数）
     *
     * @mbggenerated
     */
    public void setConnection(Long connection) {
        this.connection = connection;
    }

    /**
     * the current number of requests made through a connection (1.1.18) （目前通过一个连接请求数（1.1.18））
     *
     * @mbggenerated
     */
    public Long getConnectionRequests() {
        return connectionRequests;
    }

    /**
     * the current number of requests made through a connection (1.1.18) （目前通过一个连接请求数（1.1.18））
     *
     * @mbggenerated
     */
    public void setConnectionRequests(Long connectionRequests) {
        this.connectionRequests = connectionRequests;
    }

    /**
     * time in seconds with a milliseconds resolution at the time of the log write 
     *
     * @mbggenerated
     */
    public String getMsec() {
        return msec;
    }

    /**
     * time in seconds with a milliseconds resolution at the time of the log write 
     *
     * @mbggenerated
     */
    public void setMsec(String msec) {
        this.msec = msec == null ? null : msec.trim();
    }

    /**
     * “p” if request was pipelined, “.” otherwise 
     *
     * @mbggenerated
     */
    public String getPipe() {
        return pipe;
    }

    /**
     * “p” if request was pipelined, “.” otherwise 
     *
     * @mbggenerated
     */
    public void setPipe(String pipe) {
        this.pipe = pipe == null ? null : pipe.trim();
    }

    /**
     * request length (including request line, header, and request body) (请求长度（包括请求行、标头和请求正文）)
     *
     * @mbggenerated
     */
    public Long getRequestLength() {
        return requestLength;
    }

    /**
     * request length (including request line, header, and request body) (请求长度（包括请求行、标头和请求正文）)
     *
     * @mbggenerated
     */
    public void setRequestLength(Long requestLength) {
        this.requestLength = requestLength;
    }

    /**
     * local time in the ISO 8601 standard format
     *
     * @mbggenerated
     */
    public Date getTimeIso8601() {
        return timeIso8601;
    }

    /**
     * local time in the ISO 8601 standard format
     *
     * @mbggenerated
     */
    public void setTimeIso8601(Date timeIso8601) {
        this.timeIso8601 = timeIso8601;
    }

    /**
     * local time in the Common Log Format
     *
     * @mbggenerated
     */
    public Date getTimeLocal() {
        return timeLocal;
    }

    /**
     * local time in the Common Log Format
     *
     * @mbggenerated
     */
    public void setTimeLocal(Date timeLocal) {
        this.timeLocal = timeLocal;
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
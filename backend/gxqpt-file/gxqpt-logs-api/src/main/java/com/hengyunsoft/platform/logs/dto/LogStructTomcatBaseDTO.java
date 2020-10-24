package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * tomcat结构化
 */
@Data
public class LogStructTomcatBaseDTO {
    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统id")
    private String appId;
    /**
     * 文件服务器返回的文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件服务器返回文件ID")
    private String documentId;
    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统id")
    private String getAppId;
    /** 远程IP地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "远程IP地址")
    private String remoteIp;
    /**
     * 本地IP地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "本地IP地址")
    private String localIp;
    /**
     * 发送的字节数，不包括HTTP头，或“ - ”如果没有发送字节
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送的字节数，不包括HTTP头，或“ - ”如果没有发送字节")
    private String sendByteLittleb;
    /**
     * 发送的字节数，不包括HTTP头
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送的字节数，不包括HTTP头")
    private String sendByteBigb;
    /**
     * 远程主机名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "远程主机名")
    private String remoteHost;
    /**
     * 请求协议
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求协议")
    private String requestAgreement;
    /**
     * (小写的L)- 远程逻辑从identd的用户名（总是返回 “-” ）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "(小写的L)- 远程逻辑从identd的用户名（总是返回 “-” ）")
    private String identdUser;
    /**
     * 请求方法
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求方法")
    private String method;
    /**
     * 本地端口
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "本地端口")
    private String port;
    /**
     * 查询字符串（在前面加上一个“？”如果它存在，否则是一个空字符串
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查询字符串（在前面加上一个“？”如果它存在，否则是一个空字符串")
    private String queryStr;
    /**
     * 第一行的要求
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "第一行的要求")
    private String firstLine;
    /**
     * 响应的HTTP状态代码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "响应的HTTP状态代码")
    private String status;
    /**
     * 用户会话ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户会话ID")
    private String sessionId;
    /**
     * 日期和时间，在通用日志格式
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日期和时间，在通用日志格式")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String logTime;
    /**
     * 远程用户身份验证
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "远程用户身份验证")
    private String remoteCheckUser;
    /**
     * 请求的URL路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求的URL路径")
    private String requestUrl;
    /**
     * 本地服务器名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "本地服务器名")
    private String localHost;
    /**
     * 处理请求的时间（以毫秒为单位）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理请求的时间（以毫秒为单位）")
    private Long dealRequestMillisecond;
    /**
     * 处理请求的时间（以毫秒为单位）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理请求的时间（以毫秒为单位）")
    private Long timeConsum;
    /**
     * （大写的i） - 当前请求的线程名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "（大写的i） - 当前请求的线程名称")
    private String currentLine;

    /**
     * 浏览器通过这个头告诉服务器，它所支持的数据类型。如：text/html, image/jpeg
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String accept;

    /**
     * 浏览器通过这个头告诉服务器，它支持哪种压缩格式。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String acceptEncoding;

    /**
     * 浏览器通过这个头告诉服务器，它的语言环境。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String acceptLanguage;

    /**
     * 浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String connectionI;

    /**
     * 浏览器通过这个头告诉服务器请求的cookie内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String cookie;

    /**
     * 浏览器通过这个头告诉服务器，它想访问哪台主机。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String host;

    /**
     * 浏览器通过这个头告诉服务器，客户机是哪个页面来的。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String referer;

    /**
     * 浏览器通过这个头告诉服务器浏览器类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String userAgent;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String allowCredentials;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String accessControlAllowOrigin;

    /**
     * 服务器通过这个头告诉浏览器数据是以分块方式回送的
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String transferEncoding;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String vary;

    /**
     * 服务器通过这个头告诉浏览器数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String xApplicationContext;

    /**
     * 服务器通过这个头告诉浏览器数据时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private Date dateO;

    /**
     * 服务器通过这个头告诉浏览器服务器的型号。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String server;

    /**
     * 服务器通过这个头告诉浏览器浏览器与服务器之间连接的类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String connectionO;

    /**
     * 服务器通过这个头告诉浏览器回送数据的类型。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String contentType;

    /**
     * 服务器通过这个头告诉浏览器缓存状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String cacheControl;

    /**
     * xxx代表特定的Cookie名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String xxxC;

    /**
     * xxx代表ServletRequest属性名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String xxxR;

    /**
     * xxx代表HttpSession中的属性名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "")
    private String xxxS;


    /**
     * 采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入")
    private String dataChannel;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人主键id")
    private Long createUser;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    /**
     * 修改人
     */
    @ApiModelProperty(value = "修改人主键id")
    private Long updateUser;
    /**
     * 创建人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人姓名")
    private String createUserName;
    /**
     * 修改人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "修改人姓名")
    private String updateUserName;



}

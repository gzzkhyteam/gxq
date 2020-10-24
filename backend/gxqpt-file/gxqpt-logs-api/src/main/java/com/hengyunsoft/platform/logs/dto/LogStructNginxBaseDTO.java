package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * nginx结构化
 */
@Data
public class LogStructNginxBaseDTO {
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
     * 客户端地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端地址")
    private String remoteAddr;
    /**
     * 客户端用户名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "客户端用户名称")
    private String remoteUser;
    /**
     * 访问时间和时区
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "访问时间和时区")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date localTime;
    /**
     * 请求的URI和HTTP协议
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求的URI和HTTP协议")
    private String requestAgreen;
    /**
     * 请求地址，即浏览器中你输入的地址（IP或域名）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求地址，即浏览器中你输入的地址（IP或域名）")
    private String requestUrl;
    /**
     * HTTP请求状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "HTTP请求状态")
    private String status;
    /**
     * upstream状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "upstream状态")
    private String upstreamStatus;
    /**
     * 发送给客户端文件内容大小
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发送给客户端文件内容大小")
    private String bodyBytesSent;
    /**
     * url跳转来源
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "url跳转来源")
    private String httpReferer;
    /**
     * 用户终端浏览器等信息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户终端浏览器等信息")
    private String httpUserAgent;
    /**
     * SSL协议版本
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "SSL协议版本")
    private String sslProtocol;
    /**
     * 交换数据中的算法
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "交换数据中的算法")
    private String sslCipher;
    /**
     * 后台upstream的地址，即真正提供服务的主机地址
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "后台upstream的地址，即真正提供服务的主机地址")
    private String upstreamAddr;
    /**
     * 整个请求的总时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "整个请求的总时间")
    private Long timeConsum;
    /**
     * 请求过程中，upstream响应时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求过程中，upstream响应时间")
    private String upstreamResponseTime;

    /**
     * the number of bytes sent to a client （发送给客户端的字节数。）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private Long bytesSent;

    /**
     * connection serial number （连接数）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private Long connection;

    /**
     * the current number of requests made through a connection (1.1.18) （目前通过一个连接请求数（1.1.18））
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private Long connectionRequests;

    /**
     * time in seconds with a milliseconds resolution at the time of the log write
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private String msec;

    /**
     * “p” if request was pipelined, “.” otherwise
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private String pipe;

    /**
     * request length (including request line, header, and request body) (请求长度（包括请求行、标头和请求正文）)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private Long requestLength;

    /**
     * local time in the ISO 8601 standard format
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private Date timeIso8601;

    /**
     * local time in the Common Log Format
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " ")
    private Date timeLocal;


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

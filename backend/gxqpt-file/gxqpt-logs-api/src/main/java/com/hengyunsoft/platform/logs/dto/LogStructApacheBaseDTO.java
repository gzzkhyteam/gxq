package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * apache 结构化日志
 */
@Data
public class LogStructApacheBaseDTO {
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
     * 远程IP地址
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
     * 已发送的字节数，不包含HTTP头
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "已发送的字节数，不包含HTTP头")
   private String sendByte;
    /**
     * 环境变量FOOBAR的内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "环境变量FOOBAR的内容")
    private String foobarE;
   /**
     * Foobar的内容，发送给服务器的请求的标头行
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Foobar的内容，发送给服务器的请求的标头行")
    private String foobarI;
    /**
     * 来自另外一个模块的注解“Foobar”的内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "来自另外一个模块的注解“Foobar”的内容")
    private String foobarN;
    /**
     * Foobar的内容，应答的标头行
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "Foobar的内容，应答的标头行")
    private String foobarO;
    /**
    * CLF格式的已发送字节数量，不包含HTTP头。例如当没有发送数据时，写入‘-’而不是0。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "CLF格式的已发送字节数量，不包含HTTP头。例如当没有发送数据时，写入‘-’而不是0。")
    private String clfByteCount;
    /**
     * 文件名字
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名字")
    private String fileName;
    /**
     * 远程主机
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "远程主机")
    private String host;
    /**
     * 请求的协议
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求的协议")
    private String requestAgreement;
    /**
     * 远程登录名字（来自identd，如提供的话）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "远程登录名字（来自identd，如提供的话）")
    private String remoteLoginName;
    /**
     * 请求的方法
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求的方法")
    private String method;
    /**
     * 服务器响应请求时使用的端口
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务器响应请求时使用的端口")
    private String port;
    /**
     * 响应请求的子进程ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "响应请求的子进程ID")
    private String threadId;
    /**
     * 查询字符串（如果存在查询字符串，则包含“?”后面的部分；否则，它是一个空字符串。）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查询字符串（如果存在查询字符串，则包含“?”后面的部分；否则，它是一个空字符串。）")
    private String queryStr;
    /**
     * 请求的第一行
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "请求的第一行")
    private String reqFirstLine;
    /**
     * 状态。对于进行内部重定向的请求，这是指*原来*请求的状态。如果用%…>s，则是指后来的请求。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态。对于进行内部重定向的请求，这是指*原来*请求的状态。如果用%…>s，则是指后来的请求。")
    private String status;
    /**
     * 以公共日志时间格式表示的时间（或称为标准英文格式）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTime;
    /**
     * 为响应请求而耗费的时间，以秒计
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "为响应请求而耗费的时间，以秒计")
    private Long timeConsum;
    /**
     * 远程用户（来自auth；如果返回状态（%s）是401则可能是伪造的）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "远程用户（来自auth；如果返回状态（%s）是401则可能是伪造的）")
    private String remoteUser;
    /**
     * 用户所请求的URL路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户所请求的URL路径")
    private String requestUrl;
    /**
     * 响应请求的服务器的ServerName
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "响应请求的服务器的ServerName")
    private String rspServerName;
    /**
     * 依照UseCanonicalName设置得到的服务器名字
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "依照UseCanonicalName设置得到的服务器名字")
    private String ucnServerName;


    @ApiModelProperty(value = "")
    private String percentSign;

    @ApiModelProperty(value = "")
    private Long microseconds;

    @ApiModelProperty(value = "")
    private String keepAlive;

    @ApiModelProperty(value = "")
    private String responseGenerate;

    @ApiModelProperty(value = "")
    private String serving;

    @ApiModelProperty(value = "")
    private String responseCompleted;

    @ApiModelProperty(value = "")
    private String bytesReceived;

    @ApiModelProperty(value = "")
    private String bytesSent;

    @ApiModelProperty(value = "")
    private String varnameTi;

    @ApiModelProperty(value = "")
    private String varnameTo;

    @ApiModelProperty(value = "")
    private String unitT;

    @ApiModelProperty(value = "")
    private String formatP;

    @ApiModelProperty(value = "")
    private String formatBigp;

    @ApiModelProperty(value = "")
    private String foobarC;

    @ApiModelProperty(value = "")
    private String foobarT;

    @ApiModelProperty(value = "")
    private String accept;

    @ApiModelProperty(value = "")
    private String acceptEncoding;

    @ApiModelProperty(value = "")
    private String acceptLanguage;

    @ApiModelProperty(value = "")
    private String connectionI;

    @ApiModelProperty(value = "")
    private String cookie;

    @ApiModelProperty(value = "")
    private String referer;

    @ApiModelProperty(value = "")
    private String userAgent;

    @ApiModelProperty(value = "")
    private String allowCredentials;

    @ApiModelProperty(value = "")
    private String accessControlAllowOrigin;

    @ApiModelProperty(value = "")
    private String transferEncoding;

    @ApiModelProperty(value = "")
    private String vary;

    @ApiModelProperty(value = "")
    private String xApplicationContext;

    @ApiModelProperty(value = "")
    private String dateO;

    @ApiModelProperty(value = "")
    private String server;

    @ApiModelProperty(value = "")
    private String connectionO;

    @ApiModelProperty(value = "")
    private String contentType;

    @ApiModelProperty(value = "")
    private String cacheControl;

    @ApiModelProperty(value = "")
    private String xxxC;

    @ApiModelProperty(value = "")
    private String xxxR;

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

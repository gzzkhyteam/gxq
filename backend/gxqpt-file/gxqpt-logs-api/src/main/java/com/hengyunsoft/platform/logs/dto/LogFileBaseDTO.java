package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 日志文件
 */
@Data
public class LogFileBaseDTO {
    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统id")
    private String appId;
    /**
     * 文件名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    /**
     * 文件类型,APACHE、TOMCAT、APP、NGINX
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件类型")
    private String logType;
    /**
     * 文件服务器返回的文件id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件服务器返回文件ID")
    private String documentId;
    /**
     * 文件存放路径
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件存放路径")
    private String documentPath;
    /**
     * 采集渠道,UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "采集渠道")
    private String dataChannel;
    /**
     * 采集渠道,UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统IP")
    private String remoteIp;
    /**
     *上传时间(创建时间)
     */
    @ApiModelProperty(value = "上传时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 日志时间区 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志时间区")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logStartTime;
    /**
     * 日志时间区结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志时间区")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logEndTime;
    /**
     * 是否解析,1：是；0：否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否解析")
    private String isParsed;
    /**
     * 解析时间
     */
    @ApiModelProperty(value = "解析时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date parseTime;
    /**
     * 数据是否已提取到日志管理系统,1：是；0：否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否提取到日志系统")
    private String isPull;
    /**
     * 提取时间
     */
    @ApiModelProperty(value = "提取时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date pullTime;
    /**
     * 该日志文件已解析过的结构化的数据是否已经被删除。1：代表已删除 0：代表未删除。
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "该日志文件已解析过的结构化的数据是否已经被删除")
    private String isDeleteStruct;
    /**
     * 日志文件格式
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志文件格式")
    private String logPattern;
    /**
     * 日志条数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志条数")
    private Long logCount;
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
    /**
     *文件解析状态 已解析 未解析 已失效 解析失败
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "文件解析状态")
    private String parsedStatus;
}

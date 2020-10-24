package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 应用日志结构化数据
 */
@Data
public class LogStructAppBaseDTO {
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
     *log名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "log名称")
    private String logName;
    /**
     *记录日志时间
     */
    @ApiModelProperty(value = "记录日志时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date logTime;
    /**
     *类名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类名")
    private String className;
    /**
     *源文件名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "源文件名")
    private String sourceFileName;
    /**
     *日志级别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志级别")
    private String level;
    /**
     *日志内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志内容")
    private String content;
    /**
     *线程名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "线程名")
    private String thread;
    /**
     *方法名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "方法名")
    private String method;
    /**
     *代码行数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "代码行数")
    private String line;
    /**
     *应用存活时间（毫秒数）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用存活时间（毫秒数）")
    private String systemLiveTime;
    /**
     *日志业务类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志业务类型")
    private String logBusinessType;
    /**
     *采集渠道,WRITE：直接写入; UPLOAD：文件上传服务；FTP：ftp；IMPORT：日志系统导入
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "采集渠道")
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

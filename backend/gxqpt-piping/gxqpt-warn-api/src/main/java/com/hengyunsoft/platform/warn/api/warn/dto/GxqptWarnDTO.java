package com.hengyunsoft.platform.warn.api.warn.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：预警信息DTO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "GxqptWarn", description = "预警信息")
public class GxqptWarnDTO implements Serializable{

    /**
     * 主键TD
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 预警标题
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警标题" )
    private String title;
    /**
     * 预警类型
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型")
    private String type;
    /**
     * 应用程序id
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序id")
    private String appId;
    /**
     * 应用程序名称
     */
    @ApiModelProperty(value = "应用程序名称")
    private String appName;
    /**
     * 预警内容
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警内容")
    private String content;
    /**
     * 预警状态 1、未处理 2、已处理、3.已忽略
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警状态 1、未处理 2、已处理、3.已忽略")
    private String status;
    /**
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警级别")
    private Integer level;
    /**
     * 预警时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警时间")
    private Date warntime;
    /**
     *预警开始时间
     */
    @ApiModelProperty(value = "预警开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date warntimeStart;

    /**
     *预警截止时间
     */
    @ApiModelProperty(value = "预警截止时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date warntimeEnd;
    /**
     *预警处理人
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警处理人")
    private String handler;
    /**
     * 处理备注
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理方式")
    private String processNotes;
    /**
     * 处理时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理时间")
    private Date hanTime;
    /**
     * 平台是否可处理1、可处理 0、不可处理
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台是否可处理1、可处理 0、不可处理")
    private Boolean isHandle;
    /**
     * 应用处理回调地址
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用处理回调地址")
    private String callback_url;
    /**
     * 同一事件
     * @mbggenerated
     */
    @ApiModelProperty(value = "同一事件")
    private String sameThing;
    /**
     * 预警处理人级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警处理人级别")
    private Integer handlerLeve;

    private static final long serialVersionUID = 1L;


}

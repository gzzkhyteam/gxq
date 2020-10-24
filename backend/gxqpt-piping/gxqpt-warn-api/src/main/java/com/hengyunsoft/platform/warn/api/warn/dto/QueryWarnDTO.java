package com.hengyunsoft.platform.warn.api.warn.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 描述：预警信息DTO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "GxqptWarn", description = "预警信息")
public class QueryWarnDTO implements Serializable{
    /**
     * 预警id
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警id" )
    private Long warnId;
    /**
     * 预警标题
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警标题" )
    private String title;
    /**
     * 预警类型id
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型")
    private Long typeId;
    /**
     * 预警类型名称列表
     * @mbggenerated
     */
    private List<Long> typeList;
    /**
     * 应用程序id
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序id")
    private String appId;
    /**
     * 应用程序名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序名称")
    private String appName;
    /**
     * 预警状态 1、未处理 2、已处理、3.已忽略
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警状态 未确认、已确认、已处理")
    private String status;
    /**
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警级别")
    private Integer level;
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
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 是否是管理员
     */
    @ApiModelProperty(value = "是否是管理员")
    private Boolean isAdmin;

    private static final long serialVersionUID = 1L;


}

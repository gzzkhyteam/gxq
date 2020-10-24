package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 预警数据展示
 */
@Data
public class LogWarningBaseDTO {
    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统id")
    private String appId;

    /**
     * 规则id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "规则id")
    private String ruleId;
    /**
     * 告警时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String createTime;
    /**
     * 日志类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     * 告警级别，1：一级；2：二级；3：三级
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警级别")
    private String warnLevel;
    /**
     * 告警规则类型，KEY:关键字告警；QUANTITY：数量告警
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警类型")
    private String warnType;
    /**
     * 告警名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警名称")
    private String name;
    /**
     * 告警内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警内容")
    private String warnDescription;
    /**
     * 告警内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警内容")
    private String logDescription;
    /**
     * 处理状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理状态")
    private String isDeal;
    /**
     * 处理结果，DEAL：处理；WRONG：误告；IGNORE：忽略
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理结果，DEAL：处理；WRONG：误告；IGNORE：忽略")
    private String dealResult;
   /**
     * 处理结果描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理结果描述")
    private String dealResultDescription;
    /*
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
     * 处理结果说明
     *@mbggenerated
     */
    @ApiModelProperty(value = "处理结果说明")
    private String dealResultShow;


}

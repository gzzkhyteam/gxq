package com.hengyunsoft.platform.logs.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *日志预警规则设置
 */
@Data
public class LogWarnRuleBaseDTO {
    /**
     * 应用系统id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用系统id")
    private String appId;
    /**
     *
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志类型")
    private String logType;
    /**
     *规则编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "规则编码")
    private String code;
    /**
     *告警名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警名称")
    private String name;
    /**
     *告警规则类型，KEY:关键字告警；QUANTITY：数量告警;RESPONSE:响应时长
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警规则类型")
    private String warnType;
    /**
     *告警级别，1：一级；2：二级；3：三级
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警级别")
    private String warnLevel;
    /**
     *告警描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警描述")
    private String warnDescription;
    /**
     *告警关键词，多个用“,”隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "告警关键词")
    private String keyContent;
    /**
     *数量告警：时间间隔，单位：分钟
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "时间间隔")
    private Long quantityTimeInterval;
    /**
     *数量告警：日志级别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志级别")
    private String quantityLogLevel;
    /**
     *数量告警：日志条数上限
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "日志条数上限")
    private Long quantityUpperLimit;
    /**
     * 响应告警：响应时长
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "响应时长")
    private Long responseDuration;
    /**
     * 是否启用 1：是；0：否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用")
    private String isEnable;
    /**
     * 是否删除 1：是；0：否
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否删除")
    private String isDelete;
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

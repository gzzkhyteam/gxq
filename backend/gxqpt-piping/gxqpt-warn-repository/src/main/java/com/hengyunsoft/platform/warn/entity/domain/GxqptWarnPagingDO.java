package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：预警信息分页列表DO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "GxqptWarnPagingDO", description = "预警信息分页列表")
public class GxqptWarnPagingDO implements Serializable{

   /**
     * 主键TD
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 用户id
     * @mbggenerated
     */
     @ApiModelProperty(value = "用户ID")
     private Long userId;
    /**
    * 预警ID
    */
    @ApiModelProperty(value = "预警ID")
    private Long warnId;
    /**
     * 预警标题
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警标题" )
    private String title;
    /**
     * 预警内容
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警内容" )
    private String content;
    /**
     * 预警类型
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警类型")
    private String typeName;
    /**
     * 应用程序名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序")
    private String appName;
    /**
     * 预警时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警时间")
    private Date warntime;
    /**
     * 预警状态  未确认、已确认、已处理
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警状态  未确认、已确认、已处理")
    private String status;
    /**
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警级别")
    private Integer level;
    /**
     * 预警接收人类型
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警接收人类型")
    private String recType;
    /**
     * 预警责任人名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警接收人名称")
    private String dName;
    /**
     * 预警处理人级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警处理人级别")
    private Integer handlerLeve;
    /**
     * 处理人标识
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理人标识")
    private Boolean whoHandle;
    /**
     * 应用处理回调地址
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用处理回调地址")
    private String callbackUrl;
    /**
     * 平台是否可处理
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台是否可处理")
    private Boolean isHandle;

    private static final long serialVersionUID = 1L;


}

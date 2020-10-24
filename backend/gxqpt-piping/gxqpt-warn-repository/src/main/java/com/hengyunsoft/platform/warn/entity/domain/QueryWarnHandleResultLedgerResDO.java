package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：预警处理结果台账分页响应DTO
 * @author sxy
 * @date 2018/07/09
 * @return
 */
@Data
@ApiModel(value = "QueryWarnHandleResultLedgerResDO", description = "预警处理结果台账分页响应DTO")
public class QueryWarnHandleResultLedgerResDO implements Serializable{

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
     * 应用程序名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用程序名称")
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
    @ApiModelProperty(value = "预警状态 1、未确认 2、已确认 3、已处理")
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
    private String recName;
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
     * 平台是否可处理
     * @mbggenerated
     */
    @ApiModelProperty(value = "平台是否可处理")
    private Boolean isHandle;
    /**
     * 判断确认人级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "判断确认人级别")
    private Boolean isLevel;

   /**
    * 预警确认时长
    * @mbggenerated
    */
   @ApiModelProperty(value = "预警确认时长")
   private String confirmCostTime;

   /**
    * 预警处理时长
    * @mbggenerated
    */
   @ApiModelProperty(value = "预警处理时长")
   private String handleCostTime;

    /**
     * 处理信息
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理信息")
    private String remarks;

   private static final long serialVersionUID = 1L;


}

package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：预警处理台账信息分页列表DO
 * @author zjr
 * @date 2018/06/29
 * @return
 */
@Data
@ApiModel(value = "GxqptWarnHandlePagingDO", description = "预警处理台账信息分页列表")
public class GxqptWarnHandlePagingDO implements Serializable{

   /**
     * 主键TD
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 用户TD
     * @mbggenerated
     */
    @ApiModelProperty(value = "userId")
    private Long userId;
    /**
    * 预警ID
    */
    @ApiModelProperty(value = "warnId")
    private Long warnId;
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
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警级别")
    private Integer level;
     /**
      * 预警接收人姓名
      * @mbggenerated
      */
     @ApiModelProperty(value = "预警接收人姓名")
     private String recName;
    /**
     * 预警接收人类型
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警接收人类型")
    private String recType;
     /**
      * 预警处理结果
      * @mbggenerated
      */
     @ApiModelProperty(value = "预警处理结果")
     private Boolean result;
     /**
      * 处理信息
      * @mbggenerated
      */
     @ApiModelProperty(value = "处理信息")
     private String remarks;
     /**
      * 处理时间
      */
     @ApiModelProperty(value = "处理时间")
     private Date handTime;

    private static final long serialVersionUID = 1L;


}

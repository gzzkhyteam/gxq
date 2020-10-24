package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：预警处理结果台账信息分页列表DO
 * @author zjr
 * @date 2018/06/29
 * @return
 */
@Data
@ApiModel(value = "GxqptWarnResultPagingDO", description = "预警处理结果台账信息分页列表")
public class GxqptWarnResultPagingDO implements Serializable{

   /**
     * 主键TD
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
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
     * 预警处理时长
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警处理时长")
    private String hantimeL;
    /**
     * 预警确认时长
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警确认时长")
    private String contimeL;
    /**
     * 预警级别
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警级别")
    private Integer level;
     /**
      * 责任人名称
      * @mbggenerated
      */
     @ApiModelProperty(value = "责任人名称")
     private String dutyName;
     /**
      * 预警处理结果
      * @mbggenerated
      */
     @ApiModelProperty(value = "预警处理结果")
     private Boolean result;
     /**
      * 预警时间
      * @mbggenerated
      */
     @ApiModelProperty(value = "预警处理结果")
     private Date warntime;
     /**
      * 责任人处理备注
      * @mbggenerated
      */
     @ApiModelProperty(value = "处理信息")
     private String remarks;

    private static final long serialVersionUID = 1L;


}

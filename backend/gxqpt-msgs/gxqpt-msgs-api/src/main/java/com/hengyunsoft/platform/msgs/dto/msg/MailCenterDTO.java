package com.hengyunsoft.platform.msgs.dto.msg;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class MailCenterDTO implements Serializable { 
	private static final long serialVersionUID = 1L;
	/**
    * 主键id
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "主键id")
   private Long id;

   /**
    * 是否已读
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "是否已读0=未读，1=已读")
   private Integer readed;

   /**
    * 消息主题
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "消息主题")
   private String topic;

   /**
    * 发布时间
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "发布时间")
   private Date sendTime;

   /**
    * 发布人
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "发布人")
   private String sender;

   /**
    * 消息发生地址
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "消息发生地址")
   private String url;

   /**
    * 创建人
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "创建人")
   private String createUser;
   /**
    * 创建人id
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "创建人id")
   private String createUserId;

   /**
    * 创建时间
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "创建时间")
   private Date createTime;
   /**
    * 更新时间
    *
    * @mbggenerated
    */
   @ApiModelProperty(value = "更新时间")
   private Date updateTime;
   /**
    * 发布时间
    *
    * @mbggenerated
    */
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   public Date getSendTime() {
       return sendTime;
   }
   /**
    * 任务创建时间
    *
    * @mbggenerated
    */
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   public Date getCreateTime() {
       return createTime;
   }
   /**
    * 更新时间
    *
    * @mbggenerated
    */
   @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
   public Date getUpdateTime() {
       return updateTime;
   }
}
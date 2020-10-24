package com.hengyunsoft.platform.supervise.dto.ledger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 描述：预警处理结果台账分页请求DTO
 * @author sxy
 * @date 2018/07/09
 * @return
 */
@Data
@ApiModel(value = "WarnLedgerHandleResultPagingReqDTO", description = "预警处理结果台账分页请求DTO")
public class WarnLedgerHandleResultPagingReqDTO implements Serializable{

       private static final long serialVersionUID = 1L;

       /**
        * 预警级别
        * @mbggenerated
        */
       @ApiModelProperty(value = "预警级别 1、一般 2、较重 3、严重 4、特别严重 5、(全部)")
       private Integer level;

       /**
        * 预警类型ID
        * @mbggenerated
        */
       @ApiModelProperty(value = "预警类型ID:默认为0,查所有类型数据")
       private Long typeId;

       /**
        * 预警标题
        * @mbggenerated
        */
       @ApiModelProperty(value = "预警标题" )
       private String title;

       /**
        * 应用名称
        * @mbggenerated
        */
       @ApiModelProperty(value = "应用名称")
       private String appName;

       /**
        * 预警状态  未确认、已确认、已处理
        * @mbggenerated
        */
      /* @ApiModelProperty(value = "预警状态 1、未确认：unconfirmed 2、已确认：confirmed 3、已处理：handled 4、(全部):all")
       private String status;*/

       /**
        * 预警开始时间
        * @mbggenerated
        */
       @ApiModelProperty(value = "预警开始时间")
       private String warnStartTime;

       /**
        * 预警结束时间
        * @mbggenerated
        */
       @ApiModelProperty(value = "预警结束时间")
       private String warnEndTime;

       /**
        * 用户ID
        * @mbggenerated
        */
       @ApiModelProperty(value = "用户ID")
       private Long userId;

       /**
        * 预警类型主键列表
        * @mbggenerated
        */
       private List<Long> typeList;
}

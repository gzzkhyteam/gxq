package com.hengyunsoft.platform.warn.api.warnresult.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 描述：责任人信息分页列表DTO
 * @author zjr
 * @date 2018/07/05
 * @return
 */
@Data
@ApiModel(value = "DutyerMessage", description = "责任人信息分页列表")
public class DutyerMessageDTO implements Serializable{
    /**
    * 预警ID
    */
    @ApiModelProperty(value = "warnId")
    private Long warnId;
     /**
      * 责任人名称
      * @mbggenerated
      */
     @ApiModelProperty(value = "责任人名称")
     private String recName;
     /**
      * 责任人处理备注
      * @mbggenerated
      */
     @ApiModelProperty(value = "处理信息")
     private String remarks;

    private static final long serialVersionUID = 1L;


}

package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：预警责任人
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "DutyerDO", description = "预警责任人")
public class DutyerDO implements Serializable{

//   /**
//     * 主键TD
//     * @mbggenerated
//     */
//    @ApiModelProperty(value = "id")
//    private Long id;
    /**
    * 用户ID
    */
    @ApiModelProperty(value = "用户ID")
    private Long userId;
    /**
     * 预警接收人名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "预警接收人名称")
    private String recName;

    private static final long serialVersionUID = 1L;


}

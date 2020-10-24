package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：处理预警信息DTO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "ConfirmGxqptWarn", description = "处理预警信息DTO")
public class HandleGxqptWarnDTO implements Serializable{

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
    private Long userId;
    /**
     * 预警id
     * @mbggenerated
     */
    @ApiModelProperty(value = "warnId")
    private Long warnId;
    /**
     * 接收人姓名
     *
     * @mbggenerated
     */
    private String recName;
    /**
     * 备注
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理备注")
    private String remarks;
    /**
     * 预警级别
     * @mbggenerated
     */
    private Integer level;
    /**
     * 处理结果标识
     * @mbggenerated
     */
    @ApiModelProperty(value = "处理结果标识")
    private Boolean result;

    private static final long serialVersionUID = 1L;



}

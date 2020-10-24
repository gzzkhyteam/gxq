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
public class ConfirmTimeDTO implements Serializable{
    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;
    /**
     * 确认时长
     *
     * @mbggenerated
     */
    private String confirmTime;
    /**
     * 处理时长
     *
     * @mbggenerated
     */
    private String handleTime;
    private static final long serialVersionUID = 1L;


}

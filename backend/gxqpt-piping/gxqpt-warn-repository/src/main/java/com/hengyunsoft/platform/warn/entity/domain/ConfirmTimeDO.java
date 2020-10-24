package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：责任人信息分页列表DO
 * @author zjr
 * @date 2018/07/05
 * @return
 */
@Data
@ApiModel(value = "ConfirmTimeDO", description = "责任人信息分页列表")
public class ConfirmTimeDO implements Serializable{
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

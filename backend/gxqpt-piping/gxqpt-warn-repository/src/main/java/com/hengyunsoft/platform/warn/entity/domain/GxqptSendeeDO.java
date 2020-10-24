package com.hengyunsoft.platform.warn.entity.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述：预警接收人信息DO
 * @author zjr
 * @date 2018/03/27
 * @return
 */
@Data
@ApiModel(value = "GxqptSendeeDO", description = "预警接收人信息")
public class GxqptSendeeDO implements Serializable{

    /**
     * 主键id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * 接收人姓名
     *
     * @mbggenerated
     */
    private String recName;

    /**
     * 备注
     *
     * @mbggenerated
     */
    private String remarks;

    /**
     * 处理结果标识
     *
     * @mbggenerated
     */
    private Boolean result;


    private static final long serialVersionUID = 1L;


}

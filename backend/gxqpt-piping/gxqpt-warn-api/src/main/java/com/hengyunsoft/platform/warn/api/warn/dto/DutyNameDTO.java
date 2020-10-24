package com.hengyunsoft.platform.warn.api.warn.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 责任人信息对象
 * @author zjr
 */
@Data
@ApiModel(value = "DutyName", description = "责任人信息对象")
public class DutyNameDTO implements Serializable {
    /**
     * 用户id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * 接收人姓名
     *
     * @mbggenerated
     */
    private String recName;

    private static final long serialVersionUID = 1L;

}

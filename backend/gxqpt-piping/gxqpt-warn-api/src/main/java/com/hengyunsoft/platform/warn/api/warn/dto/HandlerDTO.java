package com.hengyunsoft.platform.warn.api.warn.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 处理人信息对象
 * @author zjr
 */
@Data
@ApiModel(value = "Handler", description = "处理人信息对象")
public class HandlerDTO implements Serializable {
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
    /**
     * 处理人级别 1代表最低的级别
     *
     * @mbggenerated
     */
    private Integer handlerLeve;

    private static final long serialVersionUID = 1L;

}

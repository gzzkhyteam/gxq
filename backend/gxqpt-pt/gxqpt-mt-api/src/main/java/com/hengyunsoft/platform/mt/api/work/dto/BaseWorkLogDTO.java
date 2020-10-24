package com.hengyunsoft.platform.mt.api.work.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public abstract  class BaseWorkLogDTO {



    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;
    /**
     * 用户id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;
    /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建时间")
    private Date createDate;
}



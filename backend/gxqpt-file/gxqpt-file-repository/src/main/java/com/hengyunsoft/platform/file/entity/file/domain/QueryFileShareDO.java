package com.hengyunsoft.platform.file.entity.file.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zjr
 * @date 2018/09/06
 */
@Data
public class QueryFileShareDO implements Serializable {

    /**
     * 初始时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "初始时间")
    private String createTimeStart;

    /**
     * 截止时间
     * @mbggenerated
     */
    @ApiModelProperty(value = "截止时间")
    private String createTimeEnd;
    /**
     * 用户id
     * @mbggenerated
     */
    @ApiModelProperty(value = "用户id")
    private Long userId;

}

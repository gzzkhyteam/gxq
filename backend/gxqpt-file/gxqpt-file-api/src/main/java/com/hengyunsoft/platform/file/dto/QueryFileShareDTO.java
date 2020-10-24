package com.hengyunsoft.platform.file.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zjr
 * @date 2018/09/06
 */
@Data
public class QueryFileShareDTO implements Serializable {

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

}

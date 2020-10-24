package com.hengyunsoft.platform.mt.api.work.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-05-28
 */
@Data
public class WorkLogLookDTO implements Serializable {



    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 创建人")
    private Long userId;
    /**
     * 姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 姓名")
    private String name;
    /**
     * 头像
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "头像")
    private String  photo;


}

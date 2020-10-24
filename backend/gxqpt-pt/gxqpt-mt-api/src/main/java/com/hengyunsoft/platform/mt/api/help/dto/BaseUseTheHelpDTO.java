package com.hengyunsoft.platform.mt.api.help.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-05-27
 */
@Data
public abstract  class BaseUseTheHelpDTO {

    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;



    /**
     * 审核状态；1：未审核,2：审核通过，3：审核未通过
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核状态")
    private Integer status;

    /**
     * 常用标准；1：Yes,2：NO
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "常用标准")
    private Integer commonlyMark;

    /**
     * 审核人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核人")
    private Long auditor;

    /**
     * 审核时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date auditorTime;

  /**
     * 创建时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


}

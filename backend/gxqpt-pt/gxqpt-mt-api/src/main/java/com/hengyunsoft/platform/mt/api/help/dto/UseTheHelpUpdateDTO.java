package com.hengyunsoft.platform.mt.api.help.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UseTheHelpUpdateDTO extends  BaseUseTheHelpDTO implements Serializable{
    /**
     * 标题
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 内容
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 审核意见
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审核意见")
    private String auditOpinion;
    /**
     * 模块id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块id")
    private Long modularId;
}

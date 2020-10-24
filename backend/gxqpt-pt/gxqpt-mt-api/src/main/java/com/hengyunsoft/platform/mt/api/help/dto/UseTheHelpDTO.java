package com.hengyunsoft.platform.mt.api.help.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UseTheHelpDTO extends BaseUseTheHelpDTO implements Serializable{
    /**
     * 主键id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "标题")
    private Long id;
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
     * 模块id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模块id")
    private Long modularId;
}

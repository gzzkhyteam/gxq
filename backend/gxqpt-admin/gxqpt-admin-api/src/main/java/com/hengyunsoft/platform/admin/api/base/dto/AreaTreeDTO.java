package com.hengyunsoft.platform.admin.api.base.dto;


import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2017-2-24
 */
@Data
@ApiModel(value = "AreaTree", description = "区域树")
public class AreaTreeDTO extends TreeNode<AreaTreeDTO,Long> implements Serializable {

    /**
     * 主键id
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private Long id;
    /**
     * 区域名称
     * @mbggenerated
     */
    @ApiModelProperty(value = "区域名称")
    private String name;


   /* *//**
     * 全名
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "全名")
    private String fullName;

    *//**
     * 排序
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "排序")
    private Integer orderNum;


    *//**
     * 路径
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "路径")
    private String treePath;

    *//**
     * 经度
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "经度")
    private String longitude;

    *//**
     * 维度
     *
     * @mbggenerated
     *//*
    @ApiModelProperty(value = "维度")
    private String latitude;*/
}

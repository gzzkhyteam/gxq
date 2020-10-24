package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
public abstract class BaseDataDirectoryDTO {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    private String applyCode;



    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 操作类型")
    private Integer optType;




    /**
     * 领域分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "领域分类")
    private String domain;

    /**
     * 专题分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "专题分类")
    private String specialType;

    /**
     * 主题大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题大类")
    private String themeOne;

    /**
     * 主题中类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题中类")
    private String themeTwo;

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ithemeThree")
    private String themeThree;

    /**
     * 行业大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "行业大类")
    private String industryOne;

    /**
     * 行业中类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "industryTwo")
    private String industryTwo;

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "industryThree")
    private String industryThree;

    /**
     * 服务大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务大类")
    private String serviceOne;

    /**
     * 服务中类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务中类")
    private String serviceTwo;

    /**
     * 服务小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "服务小类")
    private String serviceThree;

    /**
     * 开放方式:1,开发；2，不开放
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开放方式")
    private Integer openWay;

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "共享方式")
    private Integer shareWay;

    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据类型")
    private Integer dataType;

    /**
     * 不同享、不开放、有条件共享原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "共享原因")
    private String reason;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集id")
    private Long setId;
    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否元目录")
    private Integer isBottom;


}

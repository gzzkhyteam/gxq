package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import com.hengyunsoft.platform.exchange.api.directory.dto.element.BaseDataElementDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
public class DataDirectoryUpdateDTO extends BaseDataDirectoryDTO implements Serializable {
    /**
     * 目录名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录名称")
    private String dirName;
    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String unitId;
    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    /**
     * 目录编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录编码")
    private String dirCode;
    /**
     * 单位简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位简称")
    private String unitAbbr;
    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录标识")
    private Integer dirType;

    /**
     * 目录描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "  目录描述")
    private String desc;
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
    @ApiModelProperty(value = "主题大类")
    private String themeTwo;

    /**
     * 主题小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主题大类")
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
    @ApiModelProperty(value = "行业中类")
    private String industryTwo;

    /**
     * 行业小类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "行业小类")
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
    @ApiModelProperty(value = "不同享、不开放、有条件共享原因")
    private String reason;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集id")
    private Long setId;

    /**
     * 审批状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态")
    private String status_;

    /**
     * 共享单位unitIds
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "共享单位unitIds")
    private List<String> unitIds;

}

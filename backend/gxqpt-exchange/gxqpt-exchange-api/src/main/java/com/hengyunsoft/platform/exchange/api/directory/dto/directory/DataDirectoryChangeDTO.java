package com.hengyunsoft.platform.exchange.api.directory.dto.directory;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-04-24
 */
@Data
public  class DataDirectoryChangeDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 变动主表id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "变动主表id")
    private Long chgId;

    /**
     * 申请编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "申请编号")
    private String applyCode;

    /**
     * 目录名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录名称")
    private String dirName;

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
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private Long unitId;

    /**
     * 目录描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 目录描述")
    private String desc;

    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录标识")
    private Integer dirType;

    /**
     * 数据量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据量")
    private Integer dataCount;

    /**
     * 查看次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "查看次数")
    private Integer seeCount;

    /**
     * 下载次数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "下载次数")
    private Integer downCount;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 操作类型")
    private Integer optType;

    /**
     * 状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已下架
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 是否元目录:1,否；2，是
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否元目录")
    private Integer isBottom;

    /**
     * 领域分类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "领域分类")
    private String domain;

    /**
     * 主题大类
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "题大类")
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
    @ApiModelProperty(value = "主题小类")
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


}

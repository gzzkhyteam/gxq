package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
public class DataDirectoryDictDTO extends BaseDataDirectoryDTO implements Serializable {
    /**
     * 单位简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位简称")
    private String unitAbbr;

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
    @ApiModelProperty(value = " 目录编码")
    private String dirCode;

    /**
     * 目录/单位描述
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
     * 状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已下架
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Integer status;
    /**
     * 更新时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 更新人
     *
     * @mbggenerated
     */
    private Long updateUser;
    /**
     * 主题大类_name
     *
     * @mbggenerated
     */
    private String themeOneName;

    /**
     * 主题中类_name
     *
     * @mbggenerated
     */
    private String themeTwoName;

    /**
     * 主题小类_name
     *
     * @mbggenerated
     */
    private String themeThreeName;

    /**
     * 行业大类_name
     *
     * @mbggenerated
     */
    private String industryOneName;

    /**
     * 行业中类_name
     *
     * @mbggenerated
     */
    private String industryTwoName;

    /**
     * 行业小类_name
     *
     * @mbggenerated
     */
    private String industryThreeName;

    /**
     * 服务大类_name
     *
     * @mbggenerated
     */
    private String serviceOneName;


    /**
     * 服务中类_name
     *
     * @mbggenerated
     */
    private String serviceTwoName;

    /**
     * 服务小类_name
     *
     * @mbggenerated
     */
    private String serviceThreeName;
    /**
     * 共享单位unitIds
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "共享单位unitIds")
    private List<String> unitIds;


    @ApiModelProperty(value = "是否已经存在申请的API 1：是，2：否")
    private Integer isOwner;

    @ApiModelProperty(value = "是否为共享单位")
    private Integer shareUnit;
    @ApiModelProperty
    private String loginUnitId;
    @ApiModelProperty(value = "数据类型")
    private Integer dataType;

}

package com.hengyunsoft.platform.exchange.api.directory.dto.directory;

import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
@ApiModel(value = "DataDirectoryTree", description = "数据目录树")
public class DataDirectoryTreeDTO extends TreeNode<DataDirectoryTreeDTO,Long> implements Serializable {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

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
     * 单位简称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 单位简称")
    private String unitAbbr;

    /**
     * 父id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 父id")
    private String parentId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 单位id")
    private String unitId;
    /**
     * 目录标识:1,单位；2，数据目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录标识")
    private Integer dirType;
    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除；4，禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作类型")
    private Integer optType;

    /**
     * 审批状态:1,未发布；2，审批中；3，驳回；4，已发布；
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "审批状态")
    private Integer status;

    /**
     * 是否元目录
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = " 是否元目录")
    private String isBottom;

    /**
     * 数据状态；1，正常；2，已删除；3，已禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据状态")
    private Integer dataStatus;
    /**
     * 数据类型:1,结构化数据；2，非结构化数据
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据类型")
    private Integer dataType;
    /**
     * 发布记录表id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "发布记录表id")
    private Long wareId;

    /**
     * 数据集id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集id")
    private Long setId;
    /**
     * 开放方式:1,开发；2，不开放
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开放方式:1,开发；2，不开放")
    private Integer openWay;

    /**
     * 共享方式:1,共享；2，有条件共享；3，不共享
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "共享方式:1,共享；2，有条件共享；3，不共享")
    private Integer shareWay;
}

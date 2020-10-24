package com.hengyunsoft.platform.exchange.api.directory.dto.element;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author tianai
 * @createTime 2018-04-21
 */
@Data
public class DataElementCopyDTO  implements Serializable {

    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键id")
    private Long id;

    /**
     * 目录id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "目录id")
    private String  dirId;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String unitId;
    /**
     * 状态:1,未发布；2，审批中；3，驳回；4，已发布；5，已禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态")
    private Integer status;

    /**
     * 操作类型(最近一次)：1,新增；2，修改；3，删除
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "操作类型")
    private Integer optType;
    /**
     * 字段名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段名称")
    private String fieldName;

    /**
     * 字段标识
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段标识")
    private String fieldCode;

    /**
     * 字段类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段类型")
    private String fieldType;

    /**
     * 字段描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "字段描述")
    private String desc;

    /**
     * 数据集字段
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据集字段")
    private String setField;
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
    @ApiModelProperty(value = "更新人")
    private String updateUser;
}

package com.hengyunsoft.platform.admin.api.base.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author tianai
 * @createTime 2018-2-2
 */
@Data
public abstract class BaseHolidayDataDTO {


    /**
     * 编号(节假日元数据编码)
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编号(节假日元数据编码)")
    private String number;

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称")
    private String name;

    /**
     * 开始日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始日期")
    private String startTime;

    /**
     * 结束日期
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束日期")
    private String endTime;

    /**
     * 年
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "年")
    private String year;

    /**
     * 状态：1启用，禁用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "状态：1启用，禁用")
    private Integer status;

    /**
     * 类型（放假、调休加班）
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "类型（放假、调休加班）")
    private String type;

}

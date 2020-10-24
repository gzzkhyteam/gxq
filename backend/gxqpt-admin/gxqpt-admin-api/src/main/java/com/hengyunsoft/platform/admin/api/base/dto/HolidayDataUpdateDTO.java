package com.hengyunsoft.platform.admin.api.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author tianai
 * @createTime 2018-02-2
 */
@Data
@ApiModel(value = "HolidayDataSave", description = "节假日")
public class HolidayDataUpdateDTO implements Serializable {


    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 节假日名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "节假日名称",required = true)
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

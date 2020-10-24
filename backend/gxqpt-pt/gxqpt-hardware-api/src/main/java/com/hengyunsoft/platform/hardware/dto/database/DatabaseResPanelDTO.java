package com.hengyunsoft.platform.hardware.dto.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DatabaseResPanelDTO", description = "数据库资源面板实体")
public class DatabaseResPanelDTO {

    /**
     * 数据库数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库数量")
    private int databaseNum;
    /**
     * 本月新增
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "本月新增")
    private int addNum;
    /**
     * 本月释放
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "本月释放")
    private int release;
    /**
     * 新增占比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "新增占比")
    private float newProportion;

    /**
     * 释放占比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "释放占比")
    private float releaseRatio;

    /**
     * 新增环比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "新增环比")
    private float newRingRatio;

    /**
     * 释放环比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "释放环比")
    private float releaseRingRatio;

    /**
     * 净增
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "净增")
    private int netIncrease;

    /**
     * 净增占比
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "净增占比")
    private float netIncreaseRatio;
}

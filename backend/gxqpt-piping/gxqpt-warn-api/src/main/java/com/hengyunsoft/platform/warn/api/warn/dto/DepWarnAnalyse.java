package com.hengyunsoft.platform.warn.api.warn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author madengbo
 * @create 2019-05-06 16:44
 * @desc 部门预警分析
 * @Version 1.0
 **/
@Data
@ApiModel(value = "DepWarnAnalyse", description = "接收人信息对象")
public class DepWarnAnalyse {

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private String departmentId;
    /**
     *  部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String department;

    /**
    ** 部门预警总数量
     */
    @ApiModelProperty(value = "部门预警总数量")
    private Integer totalNum;

    /**
     * 预警级别及数量
     */
    @ApiModelProperty(value = "预警级别及数量")
    List<LevelNum> levelNums;
}

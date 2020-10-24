package com.hengyunsoft.platform.developer.api.fast.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sunxiaoya
 * @create 2018-05-03
 * @desc 快速应用分页
 **/
@Data
@ApiModel(value = "FastApplicationPage",description = "快速应用分页")
public class FastApplicationPageDTO implements Serializable{
    /**
     * 应用名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名称")
    private String name;

    /**
     * 创建人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "创建人")
    private String createUser;

    /**
     * 业务类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "业务类型")
    private String type;

    /**
     * 开始时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "开始时间")
    private String startTime;

    /**
     * 结束时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "结束时间")
    private String endTime;

}
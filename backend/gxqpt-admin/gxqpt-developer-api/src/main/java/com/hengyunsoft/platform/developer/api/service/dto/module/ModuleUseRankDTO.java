package com.hengyunsoft.platform.developer.api.service.dto.module;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：调用排名
 * 修改人：sunxiaoya
 * 修改时间：2018/9/28
 * 修改内容：
 */
@Data
@ApiModel(value = "ModuleUseRankDTO", description = "调用排名")
public class ModuleUseRankDTO implements Serializable {


    /**
     * 调用总数
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "调用总数")
    private Integer totalNum;

    /**
     * 应用名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "应用名")
    private String appName;

}
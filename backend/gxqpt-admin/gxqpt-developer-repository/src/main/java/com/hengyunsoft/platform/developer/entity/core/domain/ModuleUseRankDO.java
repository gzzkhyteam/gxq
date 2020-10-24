package com.hengyunsoft.platform.developer.entity.core.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 调用排名
 */
@Data
@ApiModel(value = "ModuleUseRankDTO", description = "调用排名")
public class ModuleUseRankDO implements Serializable {


    /**
     * 调用总数
     *
     * @mbggenerated
     */
    private Integer totalNum;

    /**
     * 应用名
     *
     * @mbggenerated
     */
    private String appName;

}
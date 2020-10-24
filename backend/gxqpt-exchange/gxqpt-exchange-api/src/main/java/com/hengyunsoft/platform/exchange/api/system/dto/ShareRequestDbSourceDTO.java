package com.hengyunsoft.platform.exchange.api.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "ShareRequestDbSourceDTO", description = "数据源请求信息")
public class ShareRequestDbSourceDTO implements Serializable {

    /**
     * 数据源名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据源名称")
    private String sourceName;

    /**
     * 数据库名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库名")
    private String dbName;

    /**
     * 数据库类型:1,orcale;2,mysql;3,sqlserver;
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型")
    private Integer dbType;

    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "关联系统")
    private String sysName;
}

package com.hengyunsoft.platform.hardware.dto.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DatabaseTypeRatioStatisticsDTO", description = "数据库类型占比统计实体")
public class DatabaseTypeRatioStatisticsDTO {

    /**
     * MYSQL
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "MYSQL")
    private int mysql;
    /**
     * ORACLE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ORACLE")
    private int oracle;
    /**
     * SQLSERVER
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "SQLSERVER")
    private int sqlServer;
    /**
     * ACCESS
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "ACCESS")
    private int access;
    /**
     * SYBASE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "SYBASE")
    private int sybase;

}

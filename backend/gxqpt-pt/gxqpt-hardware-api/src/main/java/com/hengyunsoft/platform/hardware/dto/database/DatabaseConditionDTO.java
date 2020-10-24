package com.hengyunsoft.platform.hardware.dto.database;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "DatabaseConditionDTO", description = "查询数据库列表条件实体")
public class DatabaseConditionDTO {

    /**
     * 数据库实例ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库实例ID")
    private String instanceDi;

    /**
     * 数据库管理员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库管理员")
    private String admin;


    /**
     * 数据库类型：1、MYSQL；2、ORACLE；3、SQLSERVER；4、ACCESS、5、SYBASE
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "数据库类型：1、MYSQL；2、ORACLE；3、SQLSERVER；4、ACCESS、5、SYBASE")
    private Integer type;

    /**
     * 关联业务系统
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "关联业务系统市")
    private String associatedServiceSystem;

}

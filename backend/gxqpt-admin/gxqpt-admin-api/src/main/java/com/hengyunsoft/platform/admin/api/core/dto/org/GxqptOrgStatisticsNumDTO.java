package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgStatisticsNum",description = "获取权限系统统计首页数据概况返回实体")
public class GxqptOrgStatisticsNumDTO {
    /**
     * 单位数量
     */
    @ApiModelProperty(value = "单位数量")
    private int orgNum;
    /**
     * 部门数量
     */
    @ApiModelProperty(value = "部门数量")
    private int dpmNum;
    /**
     * 应用数量
     */
    @ApiModelProperty(value = "应用数量")
    private int appNum;
    /**
     * 人员数量
     */
    @ApiModelProperty(value = "人员数量")
    private int empNum;
}

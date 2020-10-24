package com.hengyunsoft.platform.admin.api.core.dto.dpm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptDpmResPage", description = "部门模糊查询分页实体")
public class GxqptDpmResPageDTO{
    /**
     * 模糊查询-部门名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-部门名称")
    private String name;
    /**
     * 模糊查询-部门级别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-部门级别")
    private String forClass;
    /**
     * 模糊查询-部门类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-部门类型")
    private String forType;
    /**
     * 是否启用
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "是否启用")
    private String isenable;
    /**
     * 上级部门id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级部门id")
    private String parentId;
    /**
     * 体系编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "体系编码")
    private String systemCode;
    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String orgId;
}

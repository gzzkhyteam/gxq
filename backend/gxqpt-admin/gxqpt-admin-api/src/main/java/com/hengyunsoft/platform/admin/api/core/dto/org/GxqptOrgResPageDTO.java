package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgResPage", description = "单位批量模糊查询")
public class GxqptOrgResPageDTO{

    /**
     * 批量查询id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "批量查询id")
    private String[] ids;

    /**
     * 模糊查询-单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-单位名称")
    private String name;

    /**
     * 模糊查询-单位级别
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-单位级别")
    private String forClass;

    /**
     * 模糊查询-单位类型
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-单位类型")
    private String forType;

    /**
     * 模糊查询-体系编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "体系编码")
    private String systemCode;

    /**
     * 模糊查询-启用状态
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "模糊查询-启用状态")
    private String isenable;
}

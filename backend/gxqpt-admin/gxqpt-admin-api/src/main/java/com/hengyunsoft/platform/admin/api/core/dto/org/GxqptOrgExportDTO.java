package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgExport", description = "导出所需实体信息")
public class GxqptOrgExportDTO extends GxqptOrgSaveDTO{

    /**
     * 编辑单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "编辑单位id")
    private String id;

    /**
     * 单位管理员账号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位管理员账号")
    private String orgadmin;

    /**
     * 上级单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "上级单位名称")
    private String parentName;
}

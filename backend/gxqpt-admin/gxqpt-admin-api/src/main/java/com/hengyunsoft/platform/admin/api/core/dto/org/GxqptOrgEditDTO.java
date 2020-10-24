package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgEdit", description = "编辑实体")
public class GxqptOrgEditDTO extends GxqptOrgSaveDTO {

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
     * 要删除的分享应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "要删除的分享应用id")
    private String []deleteId;

    /**
     * 要添加的分享应用id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "要添加的分享应用id")
    private String []insertId;
}

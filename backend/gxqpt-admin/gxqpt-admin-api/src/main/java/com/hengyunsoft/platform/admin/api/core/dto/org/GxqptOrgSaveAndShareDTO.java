package com.hengyunsoft.platform.admin.api.core.dto.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "GxqptOrgSaveAndShare", description = "查询返回实体(带分享应用权限)")
public class GxqptOrgSaveAndShareDTO extends GxqptOrgSaveDTO{

    /**
     * 分享应用信息
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "分享应用信息")
    private String shareIds[];
}

package com.hengyunsoft.platform.hardware.dto.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrgServerCountDTO", description = "各单位服务器数量统计")
public class OrgServerCountDTO {
    /**
     * 单位id
     */
    @ApiModelProperty("单位id")
    private String orgId;

    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    private String orgName;

    /**
     * 服务器数量
     */
    @ApiModelProperty("服务器数量")
    private int serverCount;
}

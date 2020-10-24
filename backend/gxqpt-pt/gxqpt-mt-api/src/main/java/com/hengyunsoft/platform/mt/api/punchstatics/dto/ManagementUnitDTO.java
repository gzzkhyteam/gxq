package com.hengyunsoft.platform.mt.api.punchstatics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.mt.api.punchstatics.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：管理的单位id和单位名称
 * 修改人：gbl
 * 修改时间：2019/7/2
 * 修改内容：
 */
@Data
@ApiModel(value = "ManagementUnitDTO", description = "管理的单位id和单位名称")
public class ManagementUnitDTO {
    @ApiModelProperty(value = "单位id")
    private String id;
    @ApiModelProperty(value = "单位名称")
    private String name;
}

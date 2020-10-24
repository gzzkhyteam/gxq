package com.hengyunsoft.platform.admin.api.core.dto.duties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.admin.api.core.dto.duties
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：职务简单信息
 * 修改人：gbl
 * 修改时间：2018/7/27
 * 修改内容：
 */
@Data
@ApiModel(value = "SimpDutiesDTO", description = "职务简单信息")
public class SimpDutiesDTO {
    /**
     * ID
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "菜单编码")
    private String id;

    /**
     * 职务名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "职务名称")
    private String name;
}

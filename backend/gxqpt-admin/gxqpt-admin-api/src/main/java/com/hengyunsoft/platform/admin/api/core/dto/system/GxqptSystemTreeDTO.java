package com.hengyunsoft.platform.admin.api.core.dto.system;

import com.hengyunsoft.platform.admin.api.core.dto.org.GxqptOrgTreeBySystemDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "GxqptSystemTree", description = "体系单位树实体")
public class GxqptSystemTreeDTO {
    /**
     * 主键
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 体系编码
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "体系编码")
    private String code;

    /**
     * 体系名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "体系名称")
    private String name;
    /**
     * 所有单位
     */
    @ApiModelProperty(value = "所有单位")
    private List<GxqptOrgTreeBySystemDTO> list = new ArrayList<>();
}

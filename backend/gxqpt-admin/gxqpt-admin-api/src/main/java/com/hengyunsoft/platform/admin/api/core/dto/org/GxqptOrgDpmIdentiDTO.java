package com.hengyunsoft.platform.admin.api.core.dto.org;

import com.hengyunsoft.platform.admin.api.core.dto.dpm.GxqptDpmByUserDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "GxqptOrgDpmIdentiTree", description = "所在单位部门返回树")
public class GxqptOrgDpmIdentiDTO {
    /**
     * 单位id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位id")
    private String id;
    /**
     * 单位名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "单位名称")
    private String name;
    /**
     * 所属体系
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "所属体系")
    private String systemCode;
    /**
     * 其所在部门集合
     *
     * @mbggenerated
     */
    @ApiModelProperty(value = "其所在部门集合")
    private List<GxqptDpmByUserDTO> dpms = new ArrayList<>();
}

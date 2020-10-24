package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "GxqptOrgAddEmpRes", description = "单位+体系返回")
public class GxqptOrgAddEmpResDTO {
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
     * 单位下人员集合
     */
    @ApiModelProperty(value = "单位下人员集合")
    private List<GxqptEmpRetDTO> emps = new ArrayList<>();
}

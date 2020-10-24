package com.hengyunsoft.platform.admin.api.core.dto.emp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 描述:用户对外接口Emp
 * @author chb
 * @date 2018/3/27 10:03 
 * @return
 */
@Data
@ApiModel(value = "GxqptEmpOpenQueryDTO", description = "用户对外接口Emp")
public class GxqptEmpOpenQueryDTO implements Serializable{

    /**
     * id：userId、orgId、deptId 根据接口情况对应进行传值
     */
    @ApiModelProperty(value = "id:userId、orgId、deptId 根据接口情况对应进行传值")
    private String id;


    /**
     * 系统编码
     */
    @ApiModelProperty(value = "系统编码")
    private String systemCode;

}

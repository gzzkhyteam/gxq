package com.hengyunsoft.platform.admin.api.core.dto.emp;

import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "GxqptOrgTreeDTO", description = "单位信息")
public class GxqptOrgTreeDTO extends TreeNode<GxqptOrgTreeDTO,Long> implements Serializable {

    @ApiModelProperty(value = "单位名称")
    private String name;
    @ApiModelProperty(value = "单位下部门")
    private List<GxqptDeptEmpInfoDTO> deptList = new ArrayList<>();
    @ApiModelProperty(value = "类型org单位，dept部门")
    private String type = "org";
}

package com.hengyunsoft.platform.admin.api.core.dto.org;

import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "GxqptOrgTreeBySystem",  description = "根据体系做单位树的保存实体")
public class GxqptOrgTreeBySystemDTO extends TreeNode<GxqptOrgTreeBySystemDTO,Long>{
    @ApiModelProperty(value = "单位名称")
    private String name;
    @ApiModelProperty(value = "体系编码")
    private String systemCode;
    @ApiModelProperty(value = "部门list")
    private List<GxqptDpmTreeBySystemDTO> list = new ArrayList<>();
}

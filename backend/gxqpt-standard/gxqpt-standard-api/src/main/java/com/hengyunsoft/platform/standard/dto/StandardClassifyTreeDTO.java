package com.hengyunsoft.platform.standard.dto;
import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class StandardClassifyTreeDTO extends TreeNode<StandardClassifyTreeDTO,Long> implements Serializable {
    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "是否选中")
    private Boolean checked;
}

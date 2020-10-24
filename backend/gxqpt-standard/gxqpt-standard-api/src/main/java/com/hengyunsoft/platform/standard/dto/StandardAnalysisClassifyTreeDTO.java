package com.hengyunsoft.platform.standard.dto;

import com.hengyunsoft.platform.commons.utils.TreeNode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "StandardAnalysisClassifyTree", description = "各类文档下载数量统计")
public class StandardAnalysisClassifyTreeDTO extends TreeNode<StandardAnalysisClassifyTreeDTO,Long> implements Serializable {
    @ApiModelProperty(value = "分类名称")
    private String classifyName;

    @ApiModelProperty(value = "文档数量")
    private Integer fileCount;
}

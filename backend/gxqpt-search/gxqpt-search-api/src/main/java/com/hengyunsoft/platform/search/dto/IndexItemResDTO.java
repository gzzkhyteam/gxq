package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "IndexItemRes", description = "查询返回参数")
public class IndexItemResDTO extends IndexItemDTO {

    @ApiModelProperty(value = "标题")
    private String highlightTitle;

    @ApiModelProperty(value = "内容")
    private String highlightContent;
}

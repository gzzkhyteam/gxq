package com.hengyunsoft.platform.exchange.api.screen.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 共享交换调用关系
 */
@Data
@ApiModel(value = "RelationshipDTO", description = "大屏共享交换调用关系图")
public class RelationshipDTO {
    @ApiModelProperty(value = "节点简写",required = true)
    private String category;
    @ApiModelProperty(value = "节点名称",required = true)
    private String name;
    @ApiModelProperty(value = "节点类别",required = true)
    private int sortValue;
    @ApiModelProperty(value = "节点关系",required = true)
    private List<Map<String,Object>> target;



}

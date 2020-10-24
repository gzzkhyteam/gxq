package com.hengyunsoft.platform.search.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * com.hengyunsoft.platform.search.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：
 * 修改人：gbl
 * 修改时间：2018/4/9
 * 修改内容：新增
 */
@Data
@ApiModel(value = "SearchResItem", description = "搜索结果返回项")
public class SearchResItemDTO {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;
    @ApiModelProperty(value = "业务id")
    private String bizId;
    @ApiModelProperty(value = "自定义数据类型")
    private String type;
    @ApiModelProperty(value = "打开地址")
    private String url;
    @ApiModelProperty(value = "自定义扩展数据")
    private String ext;

    @ApiModelProperty(value = "保留字段1")
    private String retainField1;
    @ApiModelProperty(value = "保留字段2")
    private String retainField2;
    @ApiModelProperty(value = "保留字段3")
    private String retainField3;
}
